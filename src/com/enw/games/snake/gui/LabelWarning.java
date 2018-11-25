package com.enw.games.snake.gui;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class LabelWarning extends Thread {
	
	private String warning;
	private Label label;
	private int displayTime;
	
	public LabelWarning(String warning, Label label, int displayTime) {
		this.warning = warning;
		this.label = label;
		this.displayTime = displayTime;
	}
	
	public static void warn(String warning, Label label, int displayTime) {
		display(warning, label, displayTime, Color.ORANGE);
	}
	

	public static void error(String warning, Label label, int displayTime) {
		display(warning, label, displayTime, Color.ORANGERED);
	}
	
	private static void display(String warning, Label label, int displayTime, Color color) {
		LabelWarning labelWarning = new LabelWarning(warning, label, displayTime);
		label.setTextFill(color);
		labelWarning.start();
	}
	
	@Override
	public void run() {
		try {
			Platform.runLater(() -> label.setText(warning));
			Thread.sleep(displayTime);
			Platform.runLater(() -> label.setText(""));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
