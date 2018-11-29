package com.enw.games.snake.gui.sound;

public class GameSoundsManager {

	public static void playBackgroundMusic(String path) {
		BackgroundMusicPlayer backgroundMusicPlayer = new BackgroundMusicPlayer(path);
		backgroundMusicPlayer.start();
	}
	public static void PlaySound(String path) {
		FoodSoundPlayer foodSoundPlayer= new FoodSoundPlayer(path); 
		foodSoundPlayer.playSound();
	}
	
}
