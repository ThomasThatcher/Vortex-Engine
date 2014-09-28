package audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sound {
	
	public Clip clip;
	public AudioInputStream inputStream;
	public Thread thread;
	
	public boolean paused;
	public boolean playing;
	
	public Sound(String path) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		this.inputStream = AudioSystem.getAudioInputStream(new File(path));
		this.clip = AudioSystem.getClip();
		this.clip.open(this.inputStream);
		
		this.thread = new Thread(new Runnable(){

			@Override
			public void run() {
				clip.start();
			}
			
		});
		
	}
	
	public synchronized void start(){
		
		if(this.paused){
			this.thread.notify();
		}else{
			this.thread.start();
		}
		
		this.paused = false;
		this.playing = true;
	}
	
	public synchronized void stop() throws InterruptedException{
		this.thread.join();
		this.paused = false;
		this.playing = false;
	}
	
	public synchronized void pause() throws InterruptedException{
		this.thread.wait();
		this.paused= true;
		this.playing = false;
	}
	
	public synchronized void destroy() throws InterruptedException, IOException{
		stop();
		clip.close();
		inputStream.close();
	}
	
}
