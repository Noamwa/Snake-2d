package com.enw.games.snake.common;

import com.enw.games.snake.engine.Game;

public class GameInitResult {
	
	private boolean success;
	private String error;
	private Game game;
	
	public GameInitResult(boolean success, String error) {
		this.success = success;
		this.error = error;
	}
	public GameInitResult(boolean success, Game game) {
		this.success = success;
		this.game = game;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	@Override
	public String toString() {
		return "GameInitResult [success=" + success + ", error=" + error + ",game=" + game + "]";
	}
}
