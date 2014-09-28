package core;

public class Timing {

	protected long lastTime = getTime();
	protected long lastFrame = getTime();
	protected int fpsCounter;
	
	public int targetFPS;
	public int fps;
	
	public long getTime(){
		return System.nanoTime() / 1000000000;
	}
	
	public int delta(){
		
		long now = getTime();
		int delta = (int)(now - lastTime);
		lastTime = getTime();
		
		return delta;
		
	}
	
	public void updateFPS(){
		
		fpsCounter++;
		
		if(getTime() - lastFrame > 1 / targetFPS){
			fps = fpsCounter;
			fpsCounter = 0;
			lastFrame = getTime();
		}
		
	}
	
}
