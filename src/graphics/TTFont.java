package graphics;

import java.awt.Font;

import core.math.Vector2;

public class TTFont extends Font {

	private static final long serialVersionUID = 1L;

	public Vector2 location;
	
	protected TTFont(Font font, Vector2 location) {
		super(font);
			this.location = location;
	}
	
	public void setSize(int size){
		this.size = size;
	}
	
	public void setStyle(int style){
		this.style = style;
	}
	
}
