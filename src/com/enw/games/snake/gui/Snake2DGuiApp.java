package com.enw.games.snake.gui;


import com.enw.games.snake.controller.Snake2DController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Snake2DGuiApp extends Application {

	private Snake2DController gameController;
	
	public Snake2DGuiApp() {
		this.gameController = new Snake2DController();
	}
	
	public static void main(String[] args)  {  
        launch(args);  
    }  
	
	@Override
	public void start(Stage stage) throws Exception {
		
		MainStage.getInstance().setStage(stage);
		
		stage.setTitle("The Amazing Snake!");
		stage.setHeight(400);
		stage.setWidth(700);
		
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("fxmls/MainMenu.fxml"));
			AnchorPane pane = fxmlLoader.load();
			stage.setScene(new Scene(pane));
			stage.show();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
