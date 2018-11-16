package com.enw.games.snake.engine;

import java.util.ArrayList;
import java.util.List;

public class Arena {
	
	private List<Tile> board;
	
	public List<Tile> getBoard() {
		return board;
	}
	public void initSquareArena(int size){
		this.board = new ArrayList<>();
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				Tile tile = new Tile(i, j);
				if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
					tile.setWall(true);
				}
				board.add(tile);
			}
		}
	}
	
}
