package com.enw.games.snake;

import com.enw.games.snake.consoleUI.Snake2DConsoleUI;
import com.enw.games.snake.controller.Snake2DController;

public class App {
	
	public static void main(String[] args) {
		
		Snake2DConsoleUI consoleUI = new Snake2DConsoleUI(new Snake2DController());
		consoleUI.start();
	
	}
	
}
