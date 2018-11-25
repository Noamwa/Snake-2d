package com.enw.games.snake.gui.sound;

import javafx.scene.media.AudioClip;

public class GameSoundsManager {
	
	public static void playBackgroundMusic(String path) {
		BackgroundMusicPlayer backgroundMusicPlayer = new BackgroundMusicPlayer(path);
		backgroundMusicPlayer.start();
	}
}
