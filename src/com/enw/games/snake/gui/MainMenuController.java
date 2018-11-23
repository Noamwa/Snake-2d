package com.enw.games.snake.gui;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import com.enw.games.snake.gui.sound.GameSoundsManager;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainMenuController {

	private NewGameHandler newGameHandler;
	
	@FXML
	private ImageView theAmazingSnakeImg;
	
	@FXML
	private Button newGameButton;
	
	@FXML
	private Button exitGame;
	
	public MainMenuController(NewGameHandler newGameHandler) {
		this.newGameHandler = newGameHandler;
	}
	
	public void display() throws IOException {
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxmls/MainMenuSample.fxml"));
			AnchorPane pane = fxmlLoader.load();
			
			Stage mainStage = MainStage.getInstance().getStage();
			
			mainStage.setScene(new Scene(pane));
			mainStage.show();
			
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void handleNewGame() throws IOException {
		this.newGameHandler.display(MainStage.getInstance().getStage());
	}
	
	public void exitGame() {
		System.exit(0);
	}

//	@Override
//	public void initialize(URL location, ResourceBundle resources) {
//		InputStream is = getClass().getClassLoader().getResourceAsStream("/images/theAmazingSnake.jpg");
//		File file = new File("snake-game\\resources\\theAmazingSnake.jpg");
//		Image image = new Image(file.toURI().toString());
//		this.theAmazingSnakeImg.setImage(image);
//		GameSoundsManager musicPlayer = new GameSoundsManager();
//		musicPlayer.playBackgroudMusic("C:\\Users\\Noam\\dev\\snake-2d\\snake-game\\resources\\sounds\\bg1.wav");
//	}
	
}
