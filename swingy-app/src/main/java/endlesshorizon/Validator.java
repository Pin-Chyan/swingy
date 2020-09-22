package endlesshorizon;

import java.io.IOException;
import java.util.Scanner;

public class Validator {

	public static Hero startUp(Hero hero, Scanner commands) throws IOException, InterruptedException {
		System.out.println("\n⠀⠀⠀⠀⣠⣶⡾⠏⠉⠙⠳⢦⡀⠀⠀⠀⢠⠞⠉⠙⠲⡀⠀\n   ⣴⠿⠏⠀⠀⠀⠀⠀⠀⢳⡀⠀⡏⠀⠀⠀⠀⠀⢷\n  ⢠⣟⣋⡀⢀⣀⣀⡀⠀⣀⡀⣧⠀⢸⠀⠀⠀⠀⠀ ⡇\n⠀⠀⢸⣯⡭⠁⠸⣛⣟⠆⡴⣻⡲⣿⠀⣸⠀⠀OK⠀ ⡇\n⠀⠀⣟⣿⡭⠀⠀⠀⠀⠀⢱⠀⠀⣿⠀⢹⠀⠀⠀⠀⠀ ⡇\n⠀⠀⠙⢿⣯⠄⠀⠀⠀⢀⡀⠀⠀⡿⠀⠀⡇⠀⠀⠀⠀⡼\n⠀⠀⠀⠀⠹⣶⠆⠀⠀⠀⠀⠀⡴⠃⠀⠀⠘⠤⣄⣠⠞⠀\n⠀⠀⠀⠀⠀⢸⣷⡦⢤⡤⢤⣞⣁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⠀⠀⢀⣤⣴⣿⣏⠁⠀⠀⠸⣏⢯⣷⣖⣦⡀⠀⠀⠀⠀⠀⠀\n⢀⣾⣽⣿⣿⣿⣿⠛⢲⣶⣾⢉⡷⣿⣿⠵⣿⠀⠀⠀⠀⠀⠀\n⣼⣿⠍⠉⣿⡭⠉⠙⢺⣇⣼⡏⠀⠀⠀⣄⢸⠀⠀⠀⠀⠀⠀\n⣿⣿⣧⣀⣿………⣀⣰⣏⣘⣆⣀⠀⠀");
		System.out.println("Commands Available:");
		System.out.println("1 | New Campaign");
		System.out.println("2 | Load");
		String type = commands.nextLine().toLowerCase();
		switch (type) {
			case "1":
				FileHandler.newHero(hero ,commands);
				break;
			case "new":
				FileHandler.newHero(hero ,commands);
				break;
			case "2":
				hero = FileHandler.loadHero(hero, commands);
				System.out.println(hero);
				Thread.sleep(10000);
				return hero;
			case "load":
				hero = FileHandler.loadHero(hero, commands);
				System.out.println(hero);
				Thread.sleep(10000);
				return hero;
			default:
				System.out.println("Invalid Command. Try Again.");
				startUp(hero, commands);
				break;
			}
		return hero;
	}

	public static void newName(Hero hero, Scanner commands) {
		System.out.print("Enter Hero Name: ");
		String name = commands.nextLine();
		hero.setName(name);
	}

	public static void selectClass(Hero hero, Scanner commands) {
		System.out.println("Classes Available:");
		System.out.println("1 | Paladin");
		System.out.println("2 | Rogue");
		System.out.println("3 | Warrior");
		System.out.println("4 | Fighter");

		String type = commands.nextLine().toLowerCase();
		switch (type) {
			case "1":
				hero.classSet("paladin");
				break;
			case "paladin":
				hero.classSet("paladin");
				break;
			case "2":
				hero.classSet("rogue");
				break;
			case "rogue":
				hero.classSet("rogue");
				break;
			case "3":
				hero.classSet("warrior");
				break;
			case "warrior":
				hero.classSet("warrior");
				break;
			case "4":
				hero.classSet("fighter");
				break;
			case "fighter":
				hero.classSet("fighter");
				break;
			default:
				System.out.println("Invalid Command. Try Again.");
				selectClass(hero, commands);
				break;
				
		}
	}

}
