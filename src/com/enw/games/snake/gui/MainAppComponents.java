package com.enw.games.snake.gui;

import com.enw.games.snake.controller.Snake2DController;

import javafx.stage.Stage;

public class MainAppComponents {
	
	private static MainAppComponents instance;
	
	private Stage stage;
	private Snake2DController gameController;
	
	private MainAppComponents() { 
	}
	
	public static MainAppComponents getInstance() {
		if (instance == null) {
			instance = new MainAppComponents();
		}
		return instance;
	}
	
	public Stage getStage() {
		return this.stage;
	}
	
	public Snake2DController getGameController() {
		return this.gameController;
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public void setGameController(Snake2DController snake2dController) {
		this.gameController = snake2dController;
	}
}
