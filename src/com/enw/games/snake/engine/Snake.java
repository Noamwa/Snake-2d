package com.enw.games.snake.engine;
import java.util.List;
import java.util.ListIterator;
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
	public void move(SnakeDirection direction) {
		
		this.direction = direction;
		SnakePart newHead = new SnakePart(this.getHead().getPosition().getX(),
										this.getHead().getPosition().getY());
		this.body.add(0, newHead);
		this.getHead().setHead(false);
		newHead.setHead(true);
		this.body.remove(this.body.size() - 1);
		switch(this.direction) {
			case UP:
				newHead.getPosition().setY(newHead.getPosition().getY() - 1);
				break;
			case DOWN:
				newHead.getPosition().setY(newHead.getPosition().getY() + 1);
				break;
			case RIGHT:
				newHead.getPosition().setX(newHead.getPosition().getX() + 1);
				break;
			case LEFT:
				newHead.getPosition().setX(newHead.getPosition().getX() - 1);
				break;
		}
	}
	public void replaceHead(SnakePart newHead) {
		this.body.add(0, newHead);
		this.getHead().setHead(false);
		newHead.setHead(true);
	}
	public static enum SnakeDirection {
		UP, RIGHT, DOWN, LEFT;
	}
}
