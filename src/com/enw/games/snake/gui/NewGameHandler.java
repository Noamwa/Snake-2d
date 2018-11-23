package com.enw.games.snake.gui;



import java.awt.Button;
import java.io.IOException;

import com.enw.games.snake.controller.Snake2DController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NewGameHandler {
	
	private Snake2DController gameController;
	
	@FXML
	private Button backButton;
	
	private Scene prev;

	public NewGameHandler(Snake2DController gameController) {
		this.gameController = gameController;
	}
	
	public void display(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmls/HandleNewGame.fxml"));
		AnchorPane pane = fxmlLoader.load();
		prev = stage.getScene();
		stage.setScene(new Scene(pane));
		stage.show();
	}
	public void goBack() {
		Stage current = MainStage.getInstance().getStage();
		current.setScene(this.prev);
		current.show();
	}
}
