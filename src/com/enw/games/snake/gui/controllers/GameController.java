package com.enw.games.snake.gui.controllers;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.enw.games.snake.engine.Game;
import com.enw.games.snake.engine.Snake;
import com.enw.games.snake.engine.Snake.SnakeDirection;
import com.enw.games.snake.engine.SnakePart;
import com.enw.games.snake.gui.Grid;
import com.enw.games.snake.gui.MainAppComponents;
import com.enw.games.snake.gui.sound.GameSoundsManager;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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
		this.paintSnake(gc);

		new AnimationTimer() {
			long initialTime = System.nanoTime();

			@Override
			public void handle(long now) {
				if (now - initialTime >= 1000000000 / game.getGameDifficulty().getVal()) {
					handleArrowPress();
					clearSnake(gc);
					game.getSnake().move(game.getSnake().getDirection());
					paintSnake(gc);
					if (isfoodEaten()) {
						handleFoodConsumption(gc);
					}
					if (isGameOver()) {
						System.out.println("game over");
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
						this.stop();
					}
					initialTime = now;
				}
			}
		}.start();
	}

	private void handleFoodConsumption(GraphicsContext gc) {

		GameSoundsManager.PlayfoodSound("sounds/food_eat_sfx1.wav");
		List<SnakePart> body = this.game.getSnake().getBody();
		Grid.clearFood(gc, this.game.getFoodPosition());
		Grid.paintFood(gc, this.game.getFoodPosition());
		this.game.generateFood();
		Grid.paintFood(gc, this.game.getFoodPosition());

		SnakePart newSnakePart;
		int newSnakePartX;
		int newSnakePartY;
		
		// try adding to tail
		SnakePart tail = body.get(body.size() - 1);
		SnakePart beforeTail = body.get(body.size() - 2);
		newSnakePartX = body.get(body.size() - 1).getPosition().getX();
		newSnakePartY = body.get(body.size() - 1).getPosition().getY();
		if (tail.getPosition().getX() == beforeTail.getPosition().getX()) {
			if (tail.getPosition().getY() > beforeTail.getPosition().getY()) {
				newSnakePartY--;
			} else {
				newSnakePartY++;
			}
		}
		if (tail.getPosition().getY() == beforeTail.getPosition().getY()) {
			if (tail.getPosition().getX() > beforeTail.getPosition().getX()) {
				newSnakePartX--;
			} else {
				newSnakePartX++;
			}
		}
		newSnakePart = new SnakePart(newSnakePartX, newSnakePartY);
		body.add(body.size() - 1, newSnakePart);
		
		// try adding to head
		if (isGameOver()) {
			body.remove(body.size() - 1);
			newSnakePartX = this.game.getSnake().getHead().getPosition().getX();
			newSnakePartY = this.game.getSnake().getHead().getPosition().getY();
			newSnakePart = new SnakePart(newSnakePartX, newSnakePartY);
			body.add(body.size() - 1, newSnakePart);

			newSnakePartX = this.game.getSnake().getHead().getPosition().getX();
			newSnakePartY = this.game.getSnake().getHead().getPosition().getY();
			switch (this.game.getSnake().getDirection()) {
			case UP:
				newSnakePartY--;
				break;
			case DOWN:
				newSnakePartY++;
				break;
			case RIGHT:
				newSnakePartX++;
				break;
			case LEFT:
				newSnakePartX--;
				break;
			}
			newSnakePart = new SnakePart(newSnakePartX, newSnakePartY);
			this.game.getSnake().replaceHead(newSnakePart);
		}
	}

	private void clearSnake(GraphicsContext gc) {
		this.game.getSnake().getBodyParts().forEach(snakeBodyPart -> {
			Grid.clearSnakeBodyPart(gc, this.game.getSnake().getHead().getPosition());
			Grid.clearSnakeBodyPart(gc, snakeBodyPart.getPosition());
		});
	}

	private void paintSnake(GraphicsContext gc) {
		// paint snake
		this.game.getSnake().getBodyParts().forEach(snakeBodyPart -> {
			gc.setFill(Color.CHARTREUSE);
			Grid.paintSnakeBodyPart(gc, snakeBodyPart.getPosition());
		});
		// paint snake head
		gc.setFill(Color.GOLD);
		Grid.paintSnakeBodyPart(gc, this.game.getSnake().getHead().getPosition());
	}

	private boolean isfoodEaten() {
		return this.game.getSnake().getHead().getPosition().equals(this.game.getFoodPosition());
	}

	private boolean isGameOver() {
		boolean wallHit = this.game.getArena().getWalls().stream().map(tile -> tile.getPosition())
				.collect(Collectors.toList()).contains(this.game.getSnake().getHead().getPosition());
		boolean snakeHit = this.game.getSnake().getBody().stream().filter(snakePart -> !snakePart.isHead())
				.map(snakePart -> snakePart.getPosition()).collect(Collectors.toList())
				.contains(this.game.getSnake().getHead().getPosition());
		return wallHit || snakeHit;
	}

	private void handleArrowPress() {
		MainAppComponents.getInstance().getStage().getScene().setOnKeyPressed(eventHandler -> {
			String input = eventHandler.getCode().toString();
			switch (input) {
			case ("UP"):
				if (this.game.getSnake().getDirection() != SnakeDirection.DOWN) {
					this.game.getSnake().setDirection(SnakeDirection.UP);
				}
				break;
			case ("DOWN"):
				if (this.game.getSnake().getDirection() != SnakeDirection.UP) {
					this.game.getSnake().setDirection(SnakeDirection.DOWN);
				}
				break;
			case ("RIGHT"):
				if (this.game.getSnake().getDirection() != SnakeDirection.LEFT) {
					this.game.getSnake().setDirection(SnakeDirection.RIGHT);
				}
				break;
			case ("LEFT"):
				if (this.game.getSnake().getDirection() != SnakeDirection.RIGHT) {
					this.game.getSnake().setDirection(SnakeDirection.LEFT);
				}
				break;
			}
		});
	}
}
