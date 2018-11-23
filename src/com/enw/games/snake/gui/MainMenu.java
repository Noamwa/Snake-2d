package com.enw.games.snake.gui;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.enw.games.snake.gui.sound.BackgroundMusicPlayer;
import com.enw.games.snake.gui.sound.GameSoundsManager;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainMenu implements Initializable {

	private NewGameHandler newGameHandler;
	
	@FXML
	private ImageView theAmazingSnakeImg;
	
	@FXML
	private Button newGameButton;
	
	@FXML
	private Button exitGame;
	
	public MainMenu(NewGameHandler newGameHandler) {
		this.newGameHandler = newGameHandler;
	}
	
	public void display() throws IOException {
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainMenuSample.fxml"));
			AnchorPane pane = fxmlLoader.load();
			
			Stage mainStage = MainStage.getInstance().getStage();
			
			mainStage.setScene(new Scene(pane));
			mainStage.show();
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void handleNewGame() throws IOException {
	
	}
	
	public void exitGame() {
		System.exit(0);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		 File file = new File("C:\\Users\\Noam\\dev\\snake-2d\\snake-game\\resources\\theAmazingSnake.jpg");
	     Image image = new Image(file.toURI().toString());
	     this.theAmazingSnakeImg.setImage(image);
	     GameSoundsManager musicPlayer = new GameSoundsManager();
	     musicPlayer.playBackgroudMusic("C:\\Users\\Noam\\dev\\snake-2d\\snake-game\\resources\\sounds\\bg1.wav");
	}
	
}
