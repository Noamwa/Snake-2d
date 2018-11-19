package com.enw.games.snake.gui;


import com.enw.games.snake.controller.Snake2DController;
import com.enw.games.snake.gui.sound.GameSoundsManager;

import javafx.application.Application;
import javafx.stage.Stage;

public class Snake2DGuiApp extends Application {

	private static final String DEFAULT_GAME_SOUND_PATH = "sounds/bg1.wav";

	private Snake2DController gameController;
	private MainMenu mainMenu;
	private GameSoundsManager gameSoundsManager;
	
	public Snake2DGuiApp() {
		this.mainMenu = new MainMenu();
		this.gameController = new Snake2DController();
	}
	
	public static void main(String[] args)  {  
        launch(args);  
    }  
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("The Amazing Snake!");
		stage.setHeight(500);
		stage.setWidth(500);Snake2DGuiApp snake2dGuiApp = new Snake2DGuiApp();
		this.mainMenu.display(stage,new NewGameHandler(this.gameController));
		
	}
}
