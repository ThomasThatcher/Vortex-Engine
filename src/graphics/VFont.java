package graphics;

import java.awt.Color;
import java.awt.Font;

import core.math.Vector2;

public class VFont extends Font {

	private static final long serialVersionUID = 1L;

	public Color colour;
	public Vector2 location;
	
	protected VFont(Font font, Vector2 location, Color colour) {
		super(font);
			this.location = location;
			this.colour = colour;
	}
	
	public Color createColour(int r, int g, int b){
		return new Color(r, g, b);
	}
	
	public void setSize(int size){
		this.size = size;
	}
	
	public void setStyle(int style){
		this.style = style;
	}
	
}
