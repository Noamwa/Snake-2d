package com.enw.games.snake.gui;

import javafx.scene.image.Image;

public class Resources {
	
	// images 
	private static final String IMAGES_BASE = "images/";
	public static final String FOOD_IMAGE_PATH = IMAGES_BASE + "pizza.png";
	public static final String WALL_IMAGE_PATH = IMAGES_BASE + "wall.png";
	
	public static final Image WallImage = new Image(Resources.WALL_IMAGE_PATH, Grid.UNIT_SIZE, 
			Grid.UNIT_SIZE, true, true);
	
	public static final Image FoodImage = new Image(Resources.FOOD_IMAGE_PATH, Grid.UNIT_SIZE, 
			Grid.UNIT_SIZE, true, true);
	 
}
