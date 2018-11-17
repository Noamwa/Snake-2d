package com.enw.games.snake.gui;

import com.enw.games.snake.common.GameInitResult;
import com.enw.games.snake.common.GameProperties;
import com.enw.games.snake.controller.Snake2DController;
import com.enw.games.snake.gui.sound.GameSoundsManager;

import javafx.application.Application;
import javafx.stage.Stage;

public class Snake2DGuiApp extends Application {

	private static final String DEFAULT_GAME_SOUND_PATH = "sounds/bg1.wav";

	private Snake2DController gameController;
	private MainMenu mainMenu;
	private GameSoundsManager gameSoundsManager;
	
	public static void main(String[] args)  {  
        launch(args);  
    }  
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setHeight(600);
		stage.setWidth(700);
		this.mainMenu.display(stage);
	}
	
	public Snake2DGuiApp() {
		this.mainMenu = new MainMenu();
		this.gameController = new Snake2DController();
	}


//	public void start() {
//		this.mainMenu.displayManu();
//		this.gameSoundsManager.playBackgroudMusic(DEFAULT_GAME_SOUND_PATH);
//		Integer selection = this.mainMenu.getSelectionFromUser();
//		switch (selection) {
//		case 1:
//			GameInitResult gameInitResult = handleNewGame();
//			GameViewManager gameViewInitializer = new GameViewManager();
//			clearScreen();
//			gameViewInitializer.printInitializedBoard(gameInitResult);
//			break;
//		case 2:
//			// TODO
//			break;
//		case 3:
//			// TODO
//			break;
//		case 4:
//			return;
//		}
//	}

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

}
