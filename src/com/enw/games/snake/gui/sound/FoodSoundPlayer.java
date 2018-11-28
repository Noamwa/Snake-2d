package com.enw.games.snake.gui.sound;

import javafx.scene.media.AudioClip;

public class FoodSoundPlayer {
	
	private AudioClip foodSound;

	public FoodSoundPlayer(String path) {
		this.foodSound = new AudioClip(getClass().getClassLoader().getResource(path).toString());
	}
	public void playSound() {
		foodSound.play();
	}
	
}
