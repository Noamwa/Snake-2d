package com.enw.games.snake.gui.controllers;

import com.enw.games.snake.engine.Game;
import com.enw.games.snake.gui.Grid;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class GameController {
		
	@FXML
	private Canvas gameCanvas;
	
	@FXML
	private AnchorPane statusBar;
	
	private Game game;

	public void startGame(Game game) {
		
		this.game = game;
		
		GraphicsContext gc = gameCanvas.getGraphicsContext2D();
		
		// paint arena
		this.game.getArena().getWalls().forEach(wall -> {
			Grid.paintWall(gc, wall.getPosition());
		});
		
		// paint food
		Grid.paintFood(gc, this.game.getFoodPosition());
	
		// paint snake
		this.game.getSnake().getBodyParts().forEach(snakeBodyPart -> {
			gc.setFill(Color.CHARTREUSE);
			Grid.paintSnakeBodyPart(gc, snakeBodyPart.getPosition());
		});
		
		// paint snake head
		gc.setFill(Color.GOLD);
		Grid.paintSnakeBodyPart(gc, this.game.getSnake().getHead().getPosition());
		
		// start game loop!!
	}
}
