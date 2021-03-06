package com.enw.games.snake.engine;

public class Position {
	
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
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
	
	public void incY() {
		this.y++;
	}
	
	public void decY() {
		this.y--;
	}
	
	public void incX() {
		this.x++;
	}
	
	public void decX() {
		this.x--;
	}
	
	@Override
	public String toString() {
		return "(" + this.x +", " + this.y + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
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
}
