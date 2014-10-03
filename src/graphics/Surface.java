package graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import mob.Entity;
import core.math.Vector2;

public class Surface {

	public Dimension bounds;
	public int[] pixels;
	public BufferedImage image;
	public Camera camera;
	
	public Surface(Dimension bounds){
		this.bounds = bounds;
		this.image = new BufferedImage(bounds.width, bounds.height, BufferedImage.TYPE_INT_ARGB);
		this.pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
		this.camera = new Camera(new Rectangle(0, 0, bounds.width, bounds.height));
	}
	
	public void clear(){
		for(int p = 0; p < pixels.length; p++) pixels[p] = 0xFF000000;
	}
	
	public void renderFont(VFont font, String text){
		Graphics g = image.createGraphics();
		g.setFont(font);
		g.setColor(font.colour);
		g.drawString(text, font.location.x, font.location.y);
		g.dispose();
	}
	
	public void render(Sprite s, Entity e){
		
		for(int x = e.x; x < e.x + s.width; x++){
			for(int y = e.y; y < e.y + s.height; y++){
				Vector2 cor = new Vector2((int)e.getCenterX(), (int)e.getCenterY());
				setPixel(x, y, s.getPixel(x, y), e.rotation, cor);
			}
		}
		
	}
	
	public void render(Sprite s, Vector2 location, int rotation){
		
		for(int x = location.x; x < location.x + s.width; x++){
			for(int y = location.y; y < location.y + s.height; y++){
				Vector2 cor = new Vector2(location.x + (s.width / 2), location.y + (s.height / 2));
				setPixel(x, y, s.getPixel(x, y), rotation, cor);
			}
		}
		
	}
	
	public void setPixel(int x, int y, int colour, int rotation, Vector2 centerOfRotation){
		
		double hyp = Math.hypot(centerOfRotation.x - x, centerOfRotation.y - y);
		x = (int) (hyp * Math.signum(Math.toRadians(rotation)));
		y = (int) (hyp * Math.signum(Math.toRadians(rotation)));
		
		int location = (x - camera.x) + ((y - camera.y) * bounds.width);
		if(location > 0 && location < pixels.length){
			this.pixels[location] = colour;
		}
		
	}
	
	public int getPixel(int x, int y){
		return pixels[(x - camera.x) + ((y - camera.y) * bounds.width)];
	}
	
}
