package graphics;

public class Sprite {

	public int width, height;
	public int[] pixels;
	
	public Sprite(int[] pixels, int width, int height){
		this.pixels = pixels;
		this.width = width;
		this.height = height;
		this.width = width;
	}
	
	public int getPixel(int x, int y){
		return pixels[x + (y * width)];
	}
	
	public void setPixel(int x, int y, int colour){
		this.pixels[x + (y * width)] = colour;
	}
	
}
