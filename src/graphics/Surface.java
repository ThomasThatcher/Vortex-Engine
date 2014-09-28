package graphics;

import java.awt.Dimension;
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
	
	public void render(Sprite s, Entity e){
		
		for(int x = e.x; x < e.x + s.width; x++){
			for(int y = e.y; y < e.y + s.height; y++){
				setPixel(x, y, s.getPixel(x, y));
			}
		}
		
	}
	
	public void render(Sprite s, Vector2 location){
		
		for(int x = location.x; x < location.x + s.width; x++){
			for(int y = location.y; y < location.y + s.height; y++){
				setPixel(x, y, s.getPixel(x, y));
			}
		}
		
	}
	
	public void setPixel(int x, int y, int colour){
		int location = x + (y * bounds.width);
		if(location > 0 && location < pixels.length){
			this.pixels[(x - camera.x) + ((y - camera.y) * bounds.width)] = colour;
		}
	}
	
	public int getPixel(int x, int y){
		return this.pixels[(x - camera.x) + ((y - camera.y) * bounds.width)];
	}
	
}
