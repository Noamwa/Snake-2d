package com.enw.games.snake.gui.controllers;



import java.net.URL;
import java.util.ResourceBundle;

import com.enw.games.snake.common.GameInitResult;
import com.enw.games.snake.common.GameProperties;
import com.enw.games.snake.controller.Snake2DController;
import com.enw.games.snake.gui.LabelWarning;
import com.enw.games.snake.gui.MainStage;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class NewGameController implements Initializable {
	
	@FXML
	private Button startGameButton;
	
	@FXML
	private Button backButton;
	
	@FXML
	private ChoiceBox<Integer> boardSizeChoiceBox;
	
	@FXML
	private Label emptyBoardSizeWarning;

	private Snake2DController gameController;
	private Scene prev;
	
	public NewGameController() {
		this.prev = MainStage.getInstance().getStage().getScene();
	}
	
	public void setGameController(Snake2DController gameController) {
		this.gameController = gameController;
	}
	
	public void goBack() {
		Stage stage = MainStage.getInstance().getStage();
		stage.setScene(this.prev);
		stage.show();
	}
	
	public void startNewGame() {
		
		Integer boardSizeInput = (Integer) this.boardSizeChoiceBox.getValue();
		if(boardSizeInput == null) {
			LabelWarning.displayWarningLabel("Please enter board size", this.emptyBoardSizeWarning, 3000);
		}
		else {
			GameInitResult gameInitResult = this.gameController.initGame(new GameProperties(boardSizeInput));
		}
	}

	private void displayInvalidGameSizeMessage() {
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for(int i = 20; i < 100; i++ ) {
			this.boardSizeChoiceBox.getItems().add(i);
		}
	}
}
