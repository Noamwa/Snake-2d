package com.enw.games.snake.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import com.enw.games.snake.engine.Snake.SnakeDirection;
import com.enw.games.snake.engine.exceptions.InvalidBoardSizeException;

public class Game {
	
	private static final int MIN_BOARD_SIZE = 20;
	private static final int INITIAL_SNAKE_SIZE = 4;
	
	private Arena arena;
	private Snake snake;
	private GameStatus status;
	private Position foodPosition;
	
	public Game() {
		this.arena = new Arena();
		this.snake = new Snake();
		this.status = GameStatus.UNINTIALIZED;
	}
	
	public void initGame(int n) throws InvalidBoardSizeException {
		
		if(this.status != GameStatus.UNINTIALIZED){
			throw new IllegalStateException("Cannot initialize an already initialized game");
		}
		if(n < MIN_BOARD_SIZE){
			throw new InvalidBoardSizeException("Invalid board size, minimum is: " + MIN_BOARD_SIZE);
		}
		arena.initSquareArena(n);
		this.initSnake();
		this.generateFood();
		this.status = GameStatus.READY;
	}
	
	private void initSnake() {
		List<SnakePart> initialSnakeBody = new ArrayList<>();
		for(int i = 2; i < INITIAL_SNAKE_SIZE + 2; i++) { /// might be a problem i = 0
			SnakePart snakePart = new SnakePart(i, 2);
			if (i == INITIAL_SNAKE_SIZE - 1){
				snakePart.setHead(true);
			}
			initialSnakeBody.add(snakePart);
		}
		snake.setDirection(SnakeDirection.RIGHT);
	}
	
	public Snake getSnake() {
		return snake;
	}

	public Position getFoodPosition() {
		return foodPosition;
	}

	private void generateFood() {
		
		Set<Position> snakePartsPositions = this.snake.getBody().stream()
											.map(snakePart -> snakePart.getPosition())
											.collect(Collectors.toSet());
		
		List<Position> emptyPositions = this.arena.getBoard().stream()
											.filter(tile -> !tile.isWall())
											.map(tile -> tile.getPosition())
											.filter(position -> !snakePartsPositions.contains(position))
											.collect(Collectors.toList());
		Random random = new Random();
		this.foodPosition = emptyPositions.get(random.nextInt(emptyPositions.size()));
	}
	public static enum GameStatus {
		UNINTIALIZED, READY, ACTIVE, GAME_OVER, ARCHIVED;
	}
	
}
