package com.enw.games.snake.consoleUI;

public class ListenerThread extends Thread {
	
	private boolean run = true;
	
	@Override
	public void run() {
		
		while (run) {
			
		}
	}
	
	public void stopListener() {
		this.run = false;
	}
}
