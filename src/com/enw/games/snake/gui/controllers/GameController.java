package com.enw.games.snake.gui.controllers;

import java.io.IOException;

import com.enw.games.snake.engine.Game;
import com.enw.games.snake.engine.Game.GameStatus;
import com.enw.games.snake.engine.GameUtils;
import com.enw.games.snake.engine.Snake;
import com.enw.games.snake.engine.Snake.SnakeDirection;
import com.enw.games.snake.gui.Grid;
import com.enw.games.snake.gui.MainAppComponents;
import com.enw.games.snake.gui.sound.GameSoundsManager;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameController {

	@FXML
	private Canvas gameCanvas;

	@FXML
	private AnchorPane statusBar;

	@FXML
	private Label scoreText;

	@FXML
	private Label statusLabel;

	private Game game;

	public void startGame(Game game) {

		this.game = game;
		this.statusLabel.setText(this.game.getStatus().toString());

		GraphicsContext gc = gameCanvas.getGraphicsContext2D();

		// paint arena
		this.game.getArena().getWalls().forEach(wall -> {
			Grid.paintWall(gc, wall.getPosition());
		});

		// paint food
		Grid.paintFood(gc, this.game.getFoodPosition());

		// paint snake
		this.paintSnake(gc);
		
		MainAppComponents.getInstance().getStage().getScene().setOnKeyPressed(eventHandler -> {
			this.game.setStatus(GameStatus.ACTIVE);
		});
		
		this.start();
	}
	
	private void start() {

		GraphicsContext gc = gameCanvas.getGraphicsContext2D();

		new AnimationTimer() {
			long initialTime = System.nanoTime();

			@Override
			public void handle(long now) {
				if (now - initialTime >= 1e9 / game.getGameDifficulty().getFps()) {
				
					if (game.getStatus() == GameStatus.ACTIVE) {
						scoreText.setText(Integer.toString(game.getScore()));
						handleArrowPress();
						clearSnake(gc);
						game.getSnake().move(game.getSnake().getDirection());
						paintSnake(gc);
						if (isFoodEaten()) {
							handleFoodConsumption(gc);
						}
					}
					if (isGameOver()) {
						handleGameOver();
						this.stop();
					}
					initialTime = now;
					statusLabel.setText(game.getStatus().toString());
				}
			}
		}.start();
	}
	
	private void paintSnake(GraphicsContext gc) {
		// paint snake
		this.game.getSnake().getBodyParts().forEach(snakeBodyPart -> {
			gc.setFill(Color.CHARTREUSE);
			Grid.paintSnakeBodyPart(gc, snakeBodyPart.getPosition());
		});
		// paint snake head
		gc.setFill(Color.GOLD);
		Grid.paintSnakeBodyPart(gc, this.game.getSnake().getHeadPosition());
	}

	
	private void clearSnake(GraphicsContext gc) {
		this.game.getSnake().getBodyParts().forEach(snakeBodyPart -> {
			Grid.clearSnakeBodyPart(gc, this.game.getSnake().getHead().getPosition());
			Grid.clearSnakeBodyPart(gc, snakeBodyPart.getPosition());
		});
	}

	private boolean isFoodEaten() {
		return this.game.getSnake().getHeadPosition().equals(this.game.getFoodPosition());
	}

	private synchronized void handleArrowPress() {
		MainAppComponents.getInstance().getStage().getScene().setOnKeyPressed(eventHandler -> {
			switch (eventHandler.getCode()) {
				case UP:
					if (this.game.getSnake().getDirection() != SnakeDirection.DOWN) {
						this.game.getSnake().setDirection(SnakeDirection.UP);
					}
					break;
				case DOWN:
					if (this.game.getSnake().getDirection() != SnakeDirection.UP) {
						this.game.getSnake().setDirection(SnakeDirection.DOWN);
					}
					break;
				case RIGHT:
					if (this.game.getSnake().getDirection() != SnakeDirection.LEFT) {
						this.game.getSnake().setDirection(SnakeDirection.RIGHT);
					}
					break;
				case LEFT:
					if (this.game.getSnake().getDirection() != SnakeDirection.RIGHT) {
						this.game.getSnake().setDirection(SnakeDirection.LEFT);
					}
					break;
				case SPACE:
					if (this.game.getStatus() == GameStatus.PAUSED) {
						this.game.setStatus(GameStatus.ACTIVE);
					} else {
						this.game.setStatus(GameStatus.PAUSED);
					}
					break;	
					
				default: // do nothing for any other key
			}
		});
	}
	
	private void handleFoodConsumption(GraphicsContext gc) {

		GameSoundsManager.playFoodSound("sounds/food_eat_sfx1.wav");
		Grid.clearFood(gc, this.game.getFoodPosition());
		this.game.generateFood();
		Grid.paintFood(gc, this.game.getFoodPosition());

		Snake snake = this.game.getSnake();
		
		// try adding to tail
		snake.spawnNewTail();

		// spawning new tail caused game over - try adding to head
		if (isGameOver()) {
			
			snake.removeTail();
			snake.spawnNewHead();
		}
	}

	private boolean isGameOver() {
		
		boolean wallHit = GameUtils.asPositions(this.game.getArena().getWalls())
				 .contains(this.game.getSnake().getHeadPosition());

		boolean snakeHit = GameUtils.asPositions(this.game.getSnake().getBodyParts())
					.contains(this.game.getSnake().getHeadPosition());
		
		return wallHit || snakeHit;
	}
	
	private void handleGameOver() {
		GameSoundsManager.playFoodSound("sounds/GameOver.wav");
		// pop up new window :
		// new game or main menu
		FXMLLoader fxmlLoader = new FXMLLoader(
				getClass().getClassLoader().getResource("fxmls/NewGame.fxml"));
		AnchorPane pane = null;
		try {
			pane = fxmlLoader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Stage stage = MainAppComponents.getInstance().getStage();
		stage.setScene(new Scene(pane));
		stage.show();
	}
}
