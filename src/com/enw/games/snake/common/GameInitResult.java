package com.enw.games.snake.common;

import com.enw.games.snake.engine.Arena;
import com.enw.games.snake.engine.Position;
import com.enw.games.snake.engine.Snake;

public class GameInitResult {
	
	private boolean success;
	private String error;
	private Snake snake;
	private Position foodPosition;
	private Arena arena;
	
	
	public GameInitResult(boolean success, String error) {
		this.success = success;
		this.error = error;
	}
	public GameInitResult(boolean success, Arena arena, Snake snake, Position foodPosition) {
		this.success = success;
		this.snake = snake;
		this.foodPosition = foodPosition;
		this.arena = arena;
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
	public Arena getArena() {
		return arena;
	}
	public Snake getSnake() {
		return snake;
	}
	public Position getFoodPosition() {
		return foodPosition;
	}
	
	@Override
	public String toString() {
		return "GameInitResult [success=" + success + ", error=" + error + ", snake=" + snake + ", foodPosition="
				+ foodPosition + ", arena=" + arena + "]";
	}
}
