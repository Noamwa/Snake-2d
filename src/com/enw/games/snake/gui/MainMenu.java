package com.enw.games.snake.gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

import com.enw.games.snake.gui.sound.BackgroundMusicPlayer;
import com.enw.games.snake.gui.sound.GameSoundsManager;

public class MainMenu {

	public void display(Stage stage, NewGameHandler newGameHandler) {
		
		// GameSoundsManager soundsManager = new GameSoundsManager();
		// soundsManager.playBackgroudMusic("bg1.wav");
       
		Button newGameBtn = new Button("Start New Game");
		Button viewHighscoreBtn = new Button("View High-score");	// not implemented
		Button exitBtn = new Button("Exit");				
		
		newGameBtn.setOnAction(eventHandler -> {
			newGameHandler.handleNewGame(stage);
		});
		
		exitBtn.setOnAction(eventHandler -> System.exit(0));
		VBox root = new VBox();
		root.getChildren().addAll(newGameBtn, viewHighscoreBtn, exitBtn);
		root.setAlignment(Pos.TOP_CENTER);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}

}
