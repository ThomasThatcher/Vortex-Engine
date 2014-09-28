package core;

import javax.swing.JFrame;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;

	public Engine engine;
	
	public Window(Engine e, String title){
		this.engine = e;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(e.getPreferredSize());
		this.setTitle(title);
		this.addWindowListener(engine.input.window);
		this.add(engine);
		this.pack();
		this.setVisible(true);
	}
	
}
