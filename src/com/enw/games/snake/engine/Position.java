package com.enw.games.snake.engine;

public class Position {
	
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object other) {
		
		if(other == null){
			return false;
		}
		if(!(other instanceof Position)){
			return false;
		}
		Position pos = (Position)other;
		return pos.x == this.x && pos.y == this.y;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
