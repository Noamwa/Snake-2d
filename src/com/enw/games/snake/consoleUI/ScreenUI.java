package com.enw.games.snake.consoleUI;

import java.nio.charset.Charset;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.ScreenWriter;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalPosition;


public class ScreenUI {
	
	private static final Terminal.Color DEFAULT_BACKGROUND_COLOR = Terminal.Color.DEFAULT;
	private static final Terminal.Color DEFAULT_FOREGROUND_COLOR = Terminal.Color.WHITE;
	
	private static ScreenUI instance;
	
	private Terminal terminal;
	private Screen screen;
	private ScreenWriter screenWriter;
	
	private ScreenUI() {	
	}
	
	public static ScreenUI getInstance() {
		if (instance == null) {
			instance = new ScreenUI();
			instance.terminal = TerminalFacade.createTerminal(
					System.in, System.out, Charset.forName("UTF8"));
			instance.screen = new Screen(instance.terminal);
			instance.screenWriter = new ScreenWriter(instance.screen);
		}
		return instance;
	}
	
	public void startScreen() {
		this.screen.startScreen();
	}
	
	public void stopScreen() {
		this.screen.stopScreen();
	}

	public void print(String str) {
		TerminalPosition terminalPosition = screen.getCursorPosition();
		this.screen.putString(terminalPosition.getRow(), terminalPosition.getColumn(), 
				str, DEFAULT_FOREGROUND_COLOR, DEFAULT_BACKGROUND_COLOR);
		this.screen.refresh();
	}
}
