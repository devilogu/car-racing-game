package domain;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String nameList;
		int count = 0; 
		
		RacingGame game = new RacingGame();
		
		game.settingGame();
		game.run();
	}
}
