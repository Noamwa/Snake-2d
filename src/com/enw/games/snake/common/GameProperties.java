package com.enw.games.snake.common;

public class GameProperties {
	
	private int boardSize;
	
	public GameProperties(int boardSize) {
		this.boardSize = boardSize;
	}
	public int getBoardSize() {
		return boardSize;
	}

	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}
	
}
