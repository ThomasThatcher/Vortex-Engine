package core;

import graphics.Sprite;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class AssetLoader {

	public BufferedImage loadImage(String path) throws IOException{
		return ImageIO.read(new File(path));
	}
	
	public int[] getImagePixels(BufferedImage bi){
		return bi.getRGB(0, 0, bi.getWidth(), bi.getHeight(), 
				new int[bi.getWidth() * bi.getHeight()], 0, bi.getWidth());
	}
	
	public Sprite loadSprite(String path) throws IOException{
		BufferedImage bi = loadImage(path);
		return new Sprite(getImagePixels(bi), bi.getWidth(), bi.getHeight());
	}
	
}
