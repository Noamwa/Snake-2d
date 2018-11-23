package com.enw.games.snake.gui;

import javafx.stage.Stage;

public class MainStage {
	
	private static MainStage instance;
	
	private Stage stage;
	
	private MainStage() { 
	}
	
	public static MainStage getInstance() {
		if (instance == null) {
			instance = new MainStage();
		}
		return instance;
	}
	
	public Stage getStage() {
		return this.stage;
	}
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
}
