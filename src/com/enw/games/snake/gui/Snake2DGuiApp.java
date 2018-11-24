package com.enw.games.snake.gui;


import com.enw.games.snake.controller.Snake2DController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Snake2DGuiApp extends Application {

	public static void main(String[] args)  {  
        launch(args);  
    }  
	
	@Override
	public void start(Stage stage) throws Exception {
		
		init(stage);
		
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
	
	private void init(Stage stage) {
		MainAppComponents.getInstance().setStage(stage);
		MainAppComponents.getInstance().setGameController(new Snake2DController());
	}
}
