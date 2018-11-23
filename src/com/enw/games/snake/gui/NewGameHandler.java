package com.enw.games.snake.gui;



import java.io.IOException;

import com.enw.games.snake.controller.Snake2DController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NewGameHandler {
	
	private Snake2DController gameController;

	public NewGameHandler(Snake2DController gameController) {
		this.gameController = gameController;
	}
	
	public void handleNewGame(Stage stage) throws IOException {
		
	}
}
