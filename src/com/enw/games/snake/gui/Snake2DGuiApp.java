package com.enw.games.snake.gui;


import java.net.URL;

import com.enw.games.snake.controller.Snake2DController;
import com.enw.games.snake.gui.sound.GameSoundsManager;

import javafx.application.Application;
import javafx.stage.Stage;

public class Snake2DGuiApp extends Application {

	private static final String DEFAULT_GAME_SOUND_PATH = "sounds/bg1.wav";

	private Snake2DController gameController;
	private GameSoundsManager gameSoundsManager;
	private MainMenu mainMenu;
	
	public Snake2DGuiApp() {
		this.gameController = new Snake2DController();
		this.mainMenu = new MainMenu(new NewGameHandler(gameController));
	}
	
	public static void main(String[] args)  {  
        launch(args);  
    }  
	
	@Override
	public void start(Stage stage) throws Exception {
		
		MainStage.getInstance().setStage(stage);
		
		stage.setTitle("The Amazing Snake!");
		stage.setHeight(400);
		stage.setWidth(700);
		this.mainMenu.display();
		
	}
}
