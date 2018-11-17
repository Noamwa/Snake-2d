package com.enw.games.snake.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu {

	public void display(Stage stage) {
		Button newGameBtn = new Button("Start New Game");
		Button viewHighscoreBtn = new Button("View High-score");	// not implemented
		Button exitBtn = new Button("Exit");				

		newGameBtn.setOnAction(eventHandler -> {
			
		});
		
		exitBtn.setOnAction(eventHandler -> System.exit(0));
		
		VBox root = new VBox();
		root.getChildren().addAll(newGameBtn, viewHighscoreBtn, exitBtn);
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

}
