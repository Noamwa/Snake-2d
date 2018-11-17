package com.enw.games.snake.consoleUI;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NewGameMenu {
	
	public Integer getGamePropertiesFromUser() {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		boolean validSelection = false;
		Integer n = null;

		while (!validSelection) {
			try {
				System.out.println("Enter board size (n*n): ");
				n = scan.nextInt();
				validSelection = true;
			} catch (InputMismatchException e) {
				System.out.println("Please Enter a valid input");
			}
		}
		return n;
	}
	
}
