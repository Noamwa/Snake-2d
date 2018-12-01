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
	
	public Position getHeadPosition() {
		return this.getHead().getPosition();
	}
	
	public SnakePart getSnakePart(int i) {
		if (i >= 0) {
			return this.getBody().get(i);	
		}
		else {
			// if i is negative, get from tail
			return this.getBody().get(this.getBody().size() + i);
		}
	}
	
	public void move(SnakeDirection newDirection) {

		SnakePart newHead = new SnakePart(this.getHeadPosition().getX(),
										this.getHeadPosition().getY());
		this.replaceHead(newHead);
		this.removeTail();
		
		switch(newDirection) {
			case UP:
				newHead.getPosition().decY();
				break;
			case DOWN:
				newHead.getPosition().incY();
				break;
			case RIGHT:
				newHead.getPosition().incX();
				break;
			case LEFT:
				newHead.getPosition().decX();
				break;
		}

		this.setDirection(newDirection);
	}
	
	public void spawnNewHead() {
		int newSnakePartX = getHeadPosition().getX();
		int newSnakePartY = getHeadPosition().getY();
		
		switch (this.getDirection()) {
			case UP:
				newSnakePartY--;
				break;
			case DOWN:
				newSnakePartY++;
				break;
			case RIGHT:
				newSnakePartX++;
				break;
			case LEFT:
				newSnakePartX--;
				break;
		}
		this.replaceHead(new SnakePart(newSnakePartX, newSnakePartY));
	}
	
	public void spawnNewTail() {
		
		SnakePart tail = getSnakePart(-1);
		SnakePart beforeTail = getSnakePart(-2);
		
		int newSnakePartX = tail.getPosition().getX();
		int newSnakePartY = tail.getPosition().getY();
		
		if (tail.getPosition().getX() == beforeTail.getPosition().getX()) {
			if (tail.getPosition().getY() > beforeTail.getPosition().getY()) {
				newSnakePartY++;
			} else {
				newSnakePartY--;
			}
		}
		if (tail.getPosition().getY() == beforeTail.getPosition().getY()) {
			if (tail.getPosition().getX() > beforeTail.getPosition().getX()) {
				newSnakePartX--;
			} else {
				newSnakePartX++;
			}
		}
		
		this.getBody().add(new SnakePart(newSnakePartX, newSnakePartY));
	}

	public void replaceHead(SnakePart newHead) {
		this.body.add(0, newHead);
		this.getHead().setHead(false);
		newHead.setHead(true);
	}

	public void removeTail() {
		this.body.remove(this.body.size() - 1);
	}

	public static enum SnakeDirection {
		UP, RIGHT, DOWN, LEFT;
	}
}
