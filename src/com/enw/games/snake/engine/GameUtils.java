package com.enw.games.snake.engine;

import java.util.List;
import java.util.stream.Collectors;

public class GameUtils {
	
	/**
	 * Given a list of positionables return a list of their positions
	 * 
	 * @param positionables
	 * @return list of positions
	 */
	public static List<Position> asPositions(List<? extends Positionable> positionables) {
		return positionables.stream()
				.map(positionable -> positionable.getPosition())
				.collect(Collectors.toList());
	}
}
