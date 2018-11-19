package com.enw.games.snake.gui;



import com.enw.games.snake.common.GameInitResult;
import com.enw.games.snake.common.GameProperties;
import com.enw.games.snake.controller.Snake2DController;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NewGameHandler {
	
	private static final int MAX_BOARD_SIZE = 100;
	private static final int MIN_BOARD_SIZE = 20;
	
	private Snake2DController gameController;

	public NewGameHandler(Snake2DController gameController) {
		this.gameController = gameController;
	}
	
	public void handleNewGame(Stage stage) {
		
		Scene prev = stage.getScene();
		GridPane grid = new GridPane();
		
		Label label = new Label("Set board n*n size: ");
		grid.setConstraints(label, 0, 0);
		
		ChoiceBox choiceBox = new ChoiceBox();
		for(int i = MIN_BOARD_SIZE; i <= MAX_BOARD_SIZE; i++) {
			choiceBox.getItems().add(i);
		}
		grid.setConstraints(choiceBox, 2, 0);
		
		
		Button submit = new Button("Submit");
		submit.setOnAction(eventHandler -> {
			Integer boardSize = (Integer) choiceBox.getValue();
			if(boardSize == null) {
				SubmitAlertWindow submitAlertWindow = new SubmitAlertWindow(
						"Please set board size", "Alert window");
				submitAlertWindow.display();
			}
			else {
				GameInitResult gameInitResult = this.gameController.initGame(
						new GameProperties(boardSize));
			}
		});
		grid.setConstraints(submit, 0, 1);
		
		
		Button back = new Button("Back");
		back.setOnAction(eventHandler -> {
			 stage.setScene(prev);
		});
		grid.setConstraints(back, 0, 2);
		
		grid.setAlignment(Pos.TOP_CENTER);
		grid.getChildren().addAll(label, choiceBox, back, submit);
        Scene newGame = new Scene(grid);
        stage.setScene(newGame);
        stage.show();
	}
}
