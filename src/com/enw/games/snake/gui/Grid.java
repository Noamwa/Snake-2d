package com.enw.games.snake.gui;

import com.enw.games.snake.engine.Position;

import javafx.scene.canvas.GraphicsContext;

public class Grid {
	
	public static final int UNIT_SIZE = 16;

	public static final int SNAKE_W = Grid.UNIT_SIZE - 8; // snake width
	public static final int SNAKE_H = Grid.UNIT_SIZE - 6; // snake height

	
	public static final void paintWall(GraphicsContext gc, Position pos) {
		gc.drawImage(Resources.WallImage, pos.getX() * Grid.UNIT_SIZE, 
				pos.getY() * Grid.UNIT_SIZE);
	}

	public static final void paintFood(GraphicsContext gc, Position pos) {
		gc.drawImage(Resources.FoodImage, pos.getX() * Grid.UNIT_SIZE, pos.getY() * Grid.UNIT_SIZE);
	}

	public static final void paintSnakeBodyPart(GraphicsContext gc, Position pos) {
		gc.fillRect(Grid.getSnakeX(pos), 
				Grid.getSnakeY(pos), 
				Grid.SNAKE_W, 
				Grid.SNAKE_H);	
	}
	public static final void clearSnakeBodyPart(GraphicsContext gc, Position pos) {
		gc.clearRect(Grid.getSnakeX(pos), 
				Grid.getSnakeY(pos), 
				Grid.SNAKE_W, 
				Grid.SNAKE_H);	
	}
	public static final void clearFood(GraphicsContext gc, Position pos) {
		gc.clearRect(Grid.getFoodX(pos), 
				Grid.getFoodY(pos), 
				Grid.UNIT_SIZE, 
				Grid.UNIT_SIZE);	
	}
	public static final int getFoodX(Position position) {
		return position.getX() * UNIT_SIZE;
	}
	public static final int getFoodY(Position position) {
		return position.getY() * UNIT_SIZE;
	}
	public static final int getSnakeX(Position position) {
		return position.getX() * UNIT_SIZE + ((UNIT_SIZE - SNAKE_W) / 2);
	}
	
	public static final int getSnakeY(Position position) {
		return position.getY() * UNIT_SIZE + ((UNIT_SIZE - SNAKE_H) / 2);
	}
	
	
}
