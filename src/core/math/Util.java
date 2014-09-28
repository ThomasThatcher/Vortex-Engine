package core.math;

import mob.Entity;

public class Util {

	public Vector2 distanceBetween(Entity e1, Entity e2){
		return new Vector2((int)(e2.getCenterX() - e1.getCenterX()), 
							 (int)(e2.getCenterY() - e1.getCenterY()));
	}
	
	public double angleBetween(Entity e1, Entity e2){
		Vector2 distanceBetween = distanceBetween(e1, e2);
		return Math.toDegrees(Math.atan2(distanceBetween.y, distanceBetween.x));
	}
	
}
