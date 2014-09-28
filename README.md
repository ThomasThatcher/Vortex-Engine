Vortex-Engine
=============
A Pure Java Game Engine. In Development.

Notable Features:
	-	GPU Acceleration

Audio Support:
	- .WAVE .AU .AIFF .AIFC .SND <- Only
	- Supported file formats can be either 8-bit or 16-bit, 
	  with sampling rate from 8 kHz to 48 kHz.

Short Comings (In Development):
	-	Rotation not yet supported :(
	-	Sprite Transparency not supported yet
			- Work Around: When creating graphics for your application,
						   set pixels that would otherwise be set to
						   transparent. To a fluro pink/green and 'Override'
						   the 'setPixel' method in the Surface class.
						   Force the function to not render the fluro 
						   pink/green pixels.
			
			public void setPixel(int x, int y, int colour){
			
				/*
				
													  A { R  G  B }
					Colour Format (integer) -> 0x FF  00 00 00 -> 0xFF000000
					
				*/
				
				int colour = 0xFFFF00FF <- Fluro Pink
				int colour = 0xFF00FF00 <- Fluro Green
				int colour = 0xFF00EE00 <- What ever you want, realy.
				
				if(colour != pink/green/your_chosen_colour){
				
					int location = x + (y * bounds.width);
					
					if(location > 0 && location < pixels.length){
						this.pixels[(x - camera.x) + ((y - camera.y) * bounds.width)] = colour;
					}
					
				}
				
			}
						   
General Usage:

	public static void main(String[] args){

		Window window = new Window(new Engine(new Dimensions(width, height)){
			
			@Override
			public void initialise(AssetLoader assets){
				
			}
			
			@Override
			public void update(Input input, int delta){
			
			}
			
			@Override
			public void render(Surface surface){
				
			}
			
		}, "Window Title");
		
		window.engine.start();
		
	}