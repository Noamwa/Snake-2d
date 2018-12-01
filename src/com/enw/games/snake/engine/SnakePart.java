package com.enw.games.snake.engine;

public class SnakePart implements Positionable {

	private Position position;
	private boolean isHead;
	
	public SnakePart(int x, int y) {
		this.position = new Position(x, y); 
	}
	
	@Override
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public boolean isHead() {
		return isHead;
	}

	public void setHead(boolean isHead) {
		this.isHead = isHead;
	}

	@Override
	public String toString() {
		return "SnakePart [position=" + position + ", isHead=" + isHead + "]";
	}
}
