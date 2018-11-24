package com.enw.games.snake.gui.controllers;

import java.io.IOException;

import com.enw.games.snake.gui.MainStage;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainMenuController {

	@FXML
	private ImageView theAmazingSnakeImg;
	
	@FXML
	private Button newGameButton;
	
	@FXML
	private Button exitGame;
	
	public MainMenuController() {
	}
	
	public void handleNewGame() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("fxmls/NewGame.fxml"));
		AnchorPane pane = fxmlLoader.load();
		Stage stage = MainStage.getInstance().getStage();
		stage.setScene(new Scene(pane));
		stage.show();
	}
	
	public void exitGame() {
		System.exit(0);
	}
}
