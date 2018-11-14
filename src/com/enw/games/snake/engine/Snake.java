package com.enw.games.snake.engine;
import java.util.List;

public class Snake {
	
	private List<SnakePart> body;
	private SnakeDirection direction;

	public List<SnakePart> getBody() {
		return body;
	}

	public void setBody(List<SnakePart> body) {
		this.body = body;
	}

	public SnakeDirection getDirection() {
		return direction;
	}

	public void setDirection(SnakeDirection direction) {
		this.direction = direction;
	}

	public static enum SnakeDirection {
		UP, RIGHT, DOWN, LEFT;
	}
}
