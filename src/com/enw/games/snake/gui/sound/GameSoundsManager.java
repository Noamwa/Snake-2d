package com.enw.games.snake.gui.sound;

public class GameSoundsManager {
	
	private BackgroundMusicPlayer backgroundMusicPlayer;
	
	public void playBackgroudMusic(String soundPath) {
		this.backgroundMusicPlayer = new BackgroundMusicPlayer(soundPath);
		this.backgroundMusicPlayer.start();
	}
	

}
