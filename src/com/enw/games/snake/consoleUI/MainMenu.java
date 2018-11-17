package com.enw.games.snake.consoleUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

	private List<String> menuOptions = new ArrayList<>(Arrays.asList(
			"1) Start new game", 
			"2) View High-score", 
			"3) Load game", 
			"4) Exit"));

	public void displayManu() {
	
	}

	public Integer getSelectionFromUser() {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		boolean validSelection = false;
		Integer selection = null;

		while (!validSelection) {
			try {
				selection = scan.nextInt();
				if (selection >= 1 && selection <= 4) {
					validSelection = true;
				} else {
					System.out.println("Please Enter a valid option");
				}
			} catch (InputMismatchException e) {
				System.out.println("Please Enter a valid option");
			}
		}
		return selection;
	}

}
