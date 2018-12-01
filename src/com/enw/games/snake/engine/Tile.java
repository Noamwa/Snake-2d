package com.enw.games.snake.engine;

public class Tile implements Positionable {
	
	private Position position;
	private boolean isWall;

	public Tile(int x, int y) {
		this.position = new Position(x, y);
	}
	
	@Override
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public boolean isWall() {
		return isWall;
	}

	public void setWall(boolean isWall) {
		this.isWall = isWall;
	}
}
