package com.enw.games.snake.gui;



import java.awt.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.xml.stream.events.StartDocument;

import com.enw.games.snake.common.GameInitResult;
import com.enw.games.snake.common.GameProperties;
import com.enw.games.snake.controller.Snake2DController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class NewGameHandler implements Initializable {
	
	private Snake2DController gameController;
	private Scene prev;
	
	@FXML
	private Button submitButton;
	
	@FXML
	private Button backButton;
	
	@FXML
	private ChoiceBox<Integer> boardSizeChoiceBox;
	
	@FXML
	private Label emptyBoardSizeWarning;
	
	

	public NewGameHandler(Snake2DController gameController) {
		this.gameController = gameController;
	}
	
	public void display() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmls/NewGameHandler.fxml"));
		AnchorPane pane = fxmlLoader.load();
		Stage stage = MainStage.getInstance().getStage();
		this.prev = stage.getScene();
		stage.setScene(new Scene(pane));
		stage.show();
	}
	public void goBack() {
		Stage current = MainStage.getInstance().getStage();
		current.setScene(this.prev);
		current.show();
	}
	public void submit() {
		
		Integer boardSizeInput = (Integer) this.boardSizeChoiceBox.getValue();
		if(boardSizeInput == null) {
			Thread ShowBoardSizeWarning = new Thread(
					new LableWarning("Please enter board size", this.emptyBoardSizeWarning)
					);
			ShowBoardSizeWarning.start();
		}
		else {
			GameInitResult gameInitResult = this.gameController.initGame(new GameProperties(boardSizeInput));
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		for(int i = 20; i < 100; i++ ) {
			this.boardSizeChoiceBox.getItems().add(i);
		}
	}
}
