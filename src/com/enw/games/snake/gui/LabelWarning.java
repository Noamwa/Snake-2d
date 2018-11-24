package com.enw.games.snake.gui;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class LabelWarning extends Thread {
	
	private String warning;
	private Label label;
	private int displayTime;
	
	public LabelWarning(String warning, Label label, int displayTime) {
		this.warning = warning;
		this.label = label;
		this.displayTime = displayTime;
	}
	
	public static void displayWarningLabel(String warning, Label label, int displayTime) {
		LabelWarning labelWarning = new LabelWarning(warning, label, displayTime);
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
