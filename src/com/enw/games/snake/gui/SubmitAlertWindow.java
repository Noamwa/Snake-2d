package com.enw.games.snake.gui;

import java.awt.Dialog.ModalityType;

import javax.script.ScriptEngine;

import javafx.stage.Stage;
import javafx.stage.Stage.*;
import javafx.scene.Scene;
import javafx.scene.Scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.geometry.Pos;


public class SubmitAlertWindow {
	
	private String msg;
	private String title;
	private Stage window;
	
	public SubmitAlertWindow(String msg, String title) {
		this.msg = msg;
		this.title = title;
		this.window = new Stage();
		this.window.initModality(Modality.APPLICATION_MODAL);
		this.window.setMinWidth(300);
		this.window.setMinHeight(100);
		this.window.setMaxWidth(300);
		this.window.setMaxHeight(100);
	}
	
	public void display() {
		this.window.setTitle(this.title);
		Label windowLabel = new Label(this.msg);
		
		Button close = new Button("Close");
		close.setOnAction(eventHandler -> this.window.close());
		
		VBox layOut = new VBox();
		layOut.getChildren().addAll(windowLabel, close);
		layOut.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layOut);
		this.window.setScene(scene);
		this.window.showAndWait();
	}
}
