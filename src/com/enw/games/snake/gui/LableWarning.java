package com.enw.games.snake.gui;

import javafx.scene.control.Label;

public class LableWarning implements Runnable {
	
	private String warning;
	private Label label;

	public LableWarning(String warning, Label label) {
		this.warning = warning;
		this.label = label;
	}
	@Override
	public void run() {
		this.label.setText(this.warning);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		this.label.setText("");
	}
	
}
