package com.enw.games.snake.gui.sound;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javafx.application.Platform;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;

public class BackgroundMusicPlayer extends Thread {
	
	private AudioClip bgMusic;
	
	public BackgroundMusicPlayer(String path) {
		this.bgMusic = new AudioClip(getClass().getClassLoader().getResource(path).toString());
	}
	
	@Override
	public void run() {
		try {
            Platform.runLater(()-> {
            	bgMusic.setCycleCount(MediaPlayer.INDEFINITE);
            	bgMusic.play();
            	});
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
	}
 
	public void stopBgMusic() {
		this.bgMusic.stop();
	}
}
