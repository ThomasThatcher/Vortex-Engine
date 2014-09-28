package graphics;

import java.awt.Rectangle;

import core.math.Vector2;

public class Camera extends Rectangle {

	private static final long serialVersionUID = 1L;

	public Vector2 velocity;
	
	public Camera(Rectangle bounds){
		this.setBounds(bounds);
	}
	
	public void update(int delta){
		this.x += this.velocity.x;
		this.y += this.velocity.y;
	}
	
	public void setVelocity(Vector2 v){
		this.velocity = v;
	}
	
	public void setVelocity(int x, int y){
		this.velocity.setLocation(x, y);
	}
	
}
