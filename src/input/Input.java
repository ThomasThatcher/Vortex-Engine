package input;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Input {
	
	public Keyboard keyboard;
	public Mouse mouse;
	public Window window;
	
	public Input(){
		keyboard = new Keyboard();
		mouse = new Mouse();
		window = new Window();
	}
	
	public class Keyboard implements KeyListener {

		public boolean[] keys = new boolean[128];
		
		public boolean isKeyDown(int keyCode){
			return keys[keyCode];
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			keys[e.getKeyCode()] = true;
		}

		@Override
		public void keyReleased(KeyEvent e) {
			keys[e.getKeyCode()] = false;
		}
		
		@Override
		public void keyTyped(KeyEvent e){}
		
	}
	
	public class Mouse implements MouseListener {

		public boolean LEFT, RIGHT;
		public MouseMotion mouseMotion;
		
		public Mouse(){
			mouseMotion = new MouseMotion();
		}
		
		public Point getMousePosition(){
			return new Point(mouseMotion.x, mouseMotion.y);
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			
			switch(e.getButton()){
				case MouseEvent.BUTTON1:
					LEFT = true;
				case MouseEvent.BUTTON2:
					RIGHT = true;
			}
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {

			switch(e.getButton()){
				case MouseEvent.BUTTON1:
					LEFT = false;
				case MouseEvent.BUTTON2:
					RIGHT = false;
			}
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {}

		@Override
		public void mouseEntered(MouseEvent e) {}

		@Override
		public void mouseExited(MouseEvent e) {}
		
		public class MouseMotion implements MouseMotionListener {

			public int x, y;
			
			@Override
			public void mouseMoved(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {}
			
		}
		
	}
	
	public class Window implements WindowListener {

		public boolean isOpen;
		
		@Override
		public void windowOpened(WindowEvent e) {
			isOpen = true;
		}

		@Override
		public void windowClosed(WindowEvent e) {
			isOpen = false;
		}
		
		@Override
		public void windowClosing(WindowEvent e) {}

		@Override
		public void windowIconified(WindowEvent e) {}

		@Override
		public void windowDeiconified(WindowEvent e) {}

		@Override
		public void windowActivated(WindowEvent e) {}

		@Override
		public void windowDeactivated(WindowEvent e) {}
		
	}
	
}
