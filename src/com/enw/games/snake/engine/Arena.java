package com.enw.games.snake.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Arena {
	
	private List<Tile> board;
	private int xSize;
	private int ySize;
	
	public Arena(int xSize, int ySize) {
		this.xSize = xSize;
		this.ySize = ySize;
		this.board = new ArrayList<>();
	}
	
	public List<Tile> getBoard() {
		return board;
	}
	
	public void initArena() {

		for (int i = 0; i < this.xSize; i++) {
			for (int j = 0; j < this.ySize; j++) {
				Tile tile = new Tile(i, j);
				if (i == 0 || i == this.xSize - 1 || j == 0 || j == this.ySize - 1) {
					tile.setWall(true);
				}
				board.add(tile);
			}
		}
	}
	
	public List<Tile> getWalls() {
		return this.board.stream()
				.filter(tile -> tile.isWall())
				.collect(Collectors.toList());
	}
}
