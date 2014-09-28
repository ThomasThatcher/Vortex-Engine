package mob;

import java.awt.Rectangle;
import core.math.Vector2;

public class Entity extends Rectangle {

	private static final long serialVersionUID = 1L;
	
	public Vector2 velocity;
	
	public Entity(Rectangle bounds){
		this.setBounds(bounds);
		this.setVelocity(new Vector2(0, 0));
	}
	
	public Entity(int x, int y, int width, int height){
		this.setBounds(x, y, width, height);
		this.setVelocity(new Vector2(0, 0));
	}
	
	public boolean collision(Entity e){
		return intersects(e);
	}
	
	public void setVelocity(Vector2 v){
		this.velocity = v;
	}
	
	public void setVelocity(int x, int y){
		this.velocity.x = x;
		this.velocity.y = y;
	}
	
}
