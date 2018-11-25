package com.enw.games.snake.engine;
import java.util.List;
import java.util.stream.Collectors;

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
	
	public List<SnakePart> getBodyParts() {
		return this.body.stream().filter(part -> !part.isHead()).collect(Collectors.toList());
	}
	
	public SnakePart getHead() {
		return this.body.stream().filter(part -> part.isHead()).findFirst().get();
	}
	
	public static enum SnakeDirection {
		UP, RIGHT, DOWN, LEFT;
	}
}
