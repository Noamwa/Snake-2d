package com.enw.games.snake.gui;

import com.enw.games.snake.engine.Position;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Grid {
	
	public static final int UNIT_SIZE = 16;

	// Snake 
	public static final int SNAKE_W = Grid.UNIT_SIZE - 8; // snake width
	public static final int SNAKE_H = Grid.UNIT_SIZE - 6; // snake height
	
	public static final void paintWall(GraphicsContext gc, Position pos) {
		
		Image wallImage = new Image(Resources.WALL_IMAGE_PATH, Grid.UNIT_SIZE, 
				Grid.UNIT_SIZE, true, true);
		
		gc.drawImage(wallImage, pos.getX() * Grid.UNIT_SIZE, 
				pos.getY() * Grid.UNIT_SIZE);
	}

	public static final void paintFood(GraphicsContext gc, Position pos) {
		
		Image foodImage = new Image(Resources.FOOD_IMAGE_PATH, Grid.UNIT_SIZE, 
				Grid.UNIT_SIZE, true, true);
		
		gc.drawImage(foodImage, pos.getX() * Grid.UNIT_SIZE, pos.getY() * Grid.UNIT_SIZE);
	}
	
	public static final void paintSnakeBodyPart(GraphicsContext gc, Position pos) {
		gc.fillRect(Grid.getSnakeX(pos), 
				Grid.getSnakeY(pos), 
				Grid.SNAKE_W, 
				Grid.SNAKE_H);	
	}
	
	public static final int getSnakeX(Position position) {
		return position.getX() * UNIT_SIZE + ((UNIT_SIZE - SNAKE_W) / 2);
	}
	
	public static final int getSnakeY(Position position) {
		return position.getY() * UNIT_SIZE + ((UNIT_SIZE - SNAKE_H) / 2);
	}
	
	
}
