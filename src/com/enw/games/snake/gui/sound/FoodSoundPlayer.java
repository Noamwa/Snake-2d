package com.enw.games.snake.gui.sound;

import javafx.scene.media.AudioClip;

public class FoodSoundPlayer {
	
	private AudioClip sound;

	public FoodSoundPlayer(String path) {
		this.sound = new AudioClip(getClass().getClassLoader().getResource(path).toString());
	}
	public void playSound() {
		sound.play();
	}
	
}
