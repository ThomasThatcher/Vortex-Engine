package core;

import graphics.Sprite;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import audio.Sound;

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
	
	public Font loadFont(String path, int format) throws FontFormatException, IOException{
		return Font.createFont(format, new File(path));
	}
	
	public Sound loadSound(String path) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		return new Sound(path);
	}
	
}
