package com.enw.games.snake.gui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.enw.games.snake.common.GameInitResult;
import com.enw.games.snake.common.GameProperties;
import com.enw.games.snake.controller.Snake2DController;
import com.enw.games.snake.gui.Grid;
import com.enw.games.snake.gui.LabelWarning;
import com.enw.games.snake.gui.MainAppComponents;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NewGameController implements Initializable {
	
	private static final int STATUS_BAR_HEIGHT = 100; 
	
	@FXML
	private Button startGameButton;
	
	@FXML
	private Button backButton;
	
	@FXML
	private ChoiceBox<GameBoardType> gameBoardTypeChoiceBox;
	
	@FXML
	private Label warningLabel;
	
	private Scene prev;
	
	public NewGameController() {
		this.prev = MainAppComponents.getInstance().getStage().getScene();
	}
	
	public void goBack() {
		Stage stage = MainAppComponents.getInstance().getStage();
		stage.setScene(this.prev);
		stage.show();
	}
	
	public void startNewGame() {
		
		GameBoardType gameBoardType = (GameBoardType) this.gameBoardTypeChoiceBox.getValue();
		if(gameBoardType == null) {
			LabelWarning.warn("Please select valid board type", this.warningLabel, 3000);
		}
		else {
			Snake2DController gameController = MainAppComponents.getInstance().getGameController();
			GameProperties gameProps = createGameProperties();
			GameInitResult gameInitResult = gameController.initGame(gameProps);
			System.out.println(gameInitResult);
			
			// check if game init results is successful
			if (!gameInitResult.isSuccess()) {
				LabelWarning.error(gameInitResult.getError(), this.warningLabel, 3000);
				return;
			}
			
			this.loadGameScreen(gameInitResult);
		}
	}
	
	private void loadGameScreen(GameInitResult gameInitResult) {
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(getClass().getClassLoader().getResource("fxmls/Game.fxml"));
		
		try {
			AnchorPane pane = fxmlLoader.load();
			Stage stage = MainAppComponents.getInstance().getStage();
			stage.setScene(new Scene(pane));
			stage.show();
			GameController gameController = fxmlLoader.getController();
			gameController.startGame(gameInitResult.getGame());
		} catch (IOException e) {
			System.out.println("Failed to load game fxml: " + e);
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for(GameBoardType boardType : GameBoardType.values()) {
			this.gameBoardTypeChoiceBox.getItems().add(boardType);
		}
		this.gameBoardTypeChoiceBox.setValue(GameBoardType.Rectangle);
	}
	
	private GameProperties createGameProperties() {
		Stage mainStage = MainAppComponents.getInstance().getStage();
		return new GameProperties((int) mainStage.getWidth() / Grid.UNIT_SIZE, 
				(int)(mainStage.getHeight() - STATUS_BAR_HEIGHT) / Grid.UNIT_SIZE);
	}
	
	public static enum GameBoardType {
		
		Rectangle("rectangle");
		
		private String val;
		
		private GameBoardType(String val) {
			this.val = val;
		}

		public String getVal() {
			return val;
		}
	}
}
