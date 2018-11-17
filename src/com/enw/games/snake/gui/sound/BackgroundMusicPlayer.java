package com.enw.games.snake.gui.sound;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class BackgroundMusicPlayer extends Thread {
	
	private String soundPath;
	private Clip backgroundMusic;
	
	public BackgroundMusicPlayer(String soundPath) {
		this.soundPath = soundPath;
	}
	
	@Override
	public void run() {
		try {
            this.backgroundMusic = AudioSystem.getClip();
            ClassLoader classLoader = getClass().getClassLoader();
        	File file = new File(classLoader.getResource(this.soundPath).getFile());
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(
            		new FileInputStream(file)));
            this.backgroundMusic.open(inputStream);
            backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
	}
	
	public void stopBgMusic() {
		this.backgroundMusic.stop();
	}
}
