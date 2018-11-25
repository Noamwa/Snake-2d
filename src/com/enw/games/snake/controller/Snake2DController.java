package com.enw.games.snake.controller;

import com.enw.games.snake.common.GameInitResult;
import com.enw.games.snake.common.GameProperties;
import com.enw.games.snake.engine.Game;
import com.enw.games.snake.engine.exceptions.InvalidBoardSizeException;

public class Snake2DController {
	
	private Game game;
	
	public GameInitResult initGame(GameProperties gameProps) {
		
		this.game = new Game();
		try {
			game.initGame(gameProps.getWidth(), gameProps.getHeight());
		} 
		catch (InvalidBoardSizeException e) {
			return new GameInitResult(false, e.getMessage());
		}
		return new GameInitResult(true, game);
	}
	
}
