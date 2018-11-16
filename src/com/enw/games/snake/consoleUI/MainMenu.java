package com.enw.games.snake.consoleUI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/* 1) new game
	 2) view high score
	 3) load game
	 4) exit 
	 */

public class MainMenu {

	private List<String> menuOptions = new ArrayList<>(Arrays.asList(
			"1) Start new game", 
			"2) View high-score", 
			"3) Load game", 
			"4) Exit"
			));
	
	
	public void printMenu() {
		System.out.println("-- Main Menu --");
		for (String option : menuOptions) {
			System.out.println(option);
		}
	}
	
	public int getSelectionFromUser() {
		
		Scanner scan = new Scanner(System.in);
		int selection;
		
		while (true) {
			try {
				selection = scan.nextInt();
				if (selection >= 1 && selection <= 4) {
					return selection;
				}
				System.out.println("Please Enter the number of option you wish to select");
				selection = scan.nextInt();
			}
			catch (InputMismatchException e) {
				System.out.println("Please Enter the number of option you wish to select");
			}
		}
	}

}
