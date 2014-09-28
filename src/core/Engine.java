package core;

import graphics.Surface;
import input.Input;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public abstract class Engine extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	
	public boolean running;
	
	public Thread thread;
	public AssetLoader assets;
	public Graphics graphics;
	public Surface surface;
	public BufferStrategy strategy;
	public Input input;
	public Timing timing;
	
	public Engine(Dimension bounds){
		this.setPreferredSize(bounds);
		this.setRunning(true);
		this.initialise();
	}
	
	public abstract void initialise(AssetLoader assets);
	public abstract void update(Input input, int delta);
	public abstract void render(Surface s);
	
	public synchronized void start(){
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() throws InterruptedException{
		setRunning(false);
		thread.join();
	}
	
	public void setRunning(boolean running){
		this.running = running;
	}
	
	public void initialise(){
		this.input = new Input();
		this.surface = new Surface(this.getPreferredSize());
		this.timing = new Timing();
		this.assets = new AssetLoader();
		this.addKeyListener(input.keyboard);
		this.addMouseListener(input.mouse);
		this.addMouseMotionListener(input.mouse.mouseMotion);
	}
	
	public void render(){
		
		strategy = this.getBufferStrategy();
		
		if(strategy == null){
			this.createBufferStrategy(3);
			return;
		}
		
		surface.clear();
		render(surface);
		
		graphics = strategy.getDrawGraphics();
			graphics.drawImage(surface.image, 0, 0, null);
		graphics.dispose();
		strategy.show();
		
	}
	
	@Override
	public void run() {
		
		initialise(assets);
		
		while(input.window.isOpen){
			update(input, timing.delta());
			render();
		}
		
		try {
			stop();
		} catch (InterruptedException e) {
			System.err.println("Error: Failed to safely exit application");
			e.printStackTrace();
		}finally{
			System.out.println("Exited application safely. All Done :)");
		}
		
	}

}
