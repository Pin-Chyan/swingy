package endlesshorizon;

import java.io.IOException;
import java.util.Scanner;

public class GameEngine {
	public static void gameStart(Hero hero, Scanner commands) throws IOException {
		while (true) {
			heroChoice(hero, commands);
		}
	}

	public static void heroChoice(Hero hero, Scanner commands) throws IOException {
		//clearScreen();
		System.out.println("Hero Name: " + hero.name);
		System.out.println("\nCommands Available:");
		System.out.print("Status\t");
		System.out.print("Explore\t");
		System.out.print("Save\t");
		System.out.println("");
		System.out.print("Command: ");
		String choice = commands.nextLine().toLowerCase();
		switch (choice) {
			case "status":
				showHeroStatus(hero);
				break;
			case "explore":
				moveHero(hero, commands);
				break;
			case "save":
				FileHandler.saveHero(hero);
				break;
			default: 
				System.out.println("Invalid Command. Try Again.");
				heroChoice(hero, commands);
				break;
		}
	}

	public static void moveHero(Hero hero, Scanner commands) {
		clearScreen();
		System.out.println("Map Level: " + hero.getMapLvl());
		System.out.println("Position:");
		System.out.println("x:" + hero.getX());
		System.out.println("y:" + hero.getY());
		System.out.println("");
		System.out.println("Travel Directions:");
		System.out.print("North\t");
		System.out.print("South\t");
		System.out.print("East\t");
		System.out.print("West\t");
		System.out.print("Home\t");
		System.out.println("");
		System.out.print("Command: ");
		String move = commands.nextLine().toLowerCase();
		while (true) {
			switch(move) {
				case "north":
					hero.goNorth();
					moveHero(hero, commands);
					break;
				case "south":
					hero.goSouth();
					moveHero(hero, commands);
					break;
				case "west":
					hero.goWest();
					moveHero(hero, commands);
					break;
				case "east":
					hero.goEast();
					moveHero(hero, commands);
					break;
				case "home":
					try {
						heroChoice(hero, commands);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				default:
					System.out.println("Invalid Command. Try Again.");
					moveHero(hero, commands);
					break;
			}
		}
	}

	public static void showHeroStatus(Hero hero) {
		clearScreen();
		System.out.println("Hero Status:");
		System.out.println("Attack: " + hero.atk);
		System.out.println("Defense: " + hero.def);
		System.out.println("Hit Points: " + hero.hp);
		System.out.println("Max Hit Points: " + hero.maxhp);
	}

	public static void clearScreen() {   
		System.out.print("\033[H\033[2J");   
		System.out.flush();   
	   } 
}
