package com.enw.games.snake.consoleUI;

import java.io.IOException;

import com.enw.games.snake.common.GameInitResult;
import com.enw.games.snake.common.GameProperties;
import com.enw.games.snake.consoleUI.sounds.GameSoundsManager;
import com.enw.games.snake.controller.Snake2DController;

public class Snake2DConsoleUI {

	private static final String DEFAULT_GAME_SOUND_PATH = "sounds/bg1.wav";

	private Snake2DController gameController;
	private MainMenu mainMenu;
	private GameSoundsManager gameSoundsManager;

	public Snake2DConsoleUI(Snake2DController gameController) {
		this.gameController = gameController;
		this.mainMenu = new MainMenu();
		this.gameSoundsManager = new GameSoundsManager();
	}

	public void start() {
		this.mainMenu.displayManu();
		this.gameSoundsManager.playBackgroudMusic(DEFAULT_GAME_SOUND_PATH);
		Integer selection = this.mainMenu.getSelectionFromUser();
		switch (selection) {
		case 1:
			GameInitResult gameInitResult = handleNewGame();
			GameViewManager gameViewInitializer = new GameViewManager();
			clearScreen();
			gameViewInitializer.printInitializedBoard(gameInitResult);
			break;
		case 2:
			// TODO
			break;
		case 3:
			// TODO
			break;
		case 4:
			return;
		}
	}

	private GameInitResult handleNewGame() {
		NewGameMenu newGameMenu = new NewGameMenu();
		GameInitResult gameInitResult = null;

		do {
			Integer n = newGameMenu.getGamePropertiesFromUser();
			gameInitResult = this.gameController.initGame(new GameProperties(n));
			if (!gameInitResult.isSuccess()) {
				System.out.println(gameInitResult.getError());
			}
		} while (!gameInitResult.isSuccess());
		return gameInitResult;
	}

	private void clearScreen() {
		try {
			Runtime.getRuntime().exec("cmd /c cls");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
