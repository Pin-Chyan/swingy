package endlesshorizon;

import java.io.IOException;
import java.util.Scanner;

public class GameEngine {
	private static int timewait = 2000;

	public static void gameStart(Hero hero, Scanner commands) throws IOException, InterruptedException {
		while (true) {
			heroChoice(hero, commands);
		}
	}

	public static void heroChoice(Hero hero, Scanner commands) throws IOException, InterruptedException {
		clearScreen();
		System.out.println("\nHero Name: " + hero.name);
		System.out.println(hero.look);
		System.out.println("\nCommands Available:");
		System.out.print(" | Status | Inventory | Explore | Save | Shops | ");
		System.out.println("");
		System.out.print("Command: ");
		String choice = commands.nextLine().toLowerCase();
		switch (choice) {
			case "status":
				showHeroStatus(hero);
				Thread.sleep(timewait);
				break;
			case "inventory":
				showInventory(hero);
				Thread.sleep(timewait);
				break;
			case "explore":
				moveHero(hero, commands);
				Thread.sleep(timewait);
				break;
			case "shops":
				shopDisctrict(hero, commands);
				Thread.sleep(timewait);
				break;
			case "save":
				FileHandler.saveHero(hero);
				break;
			//case "load":
			//	FileHandler.loadHero(hero, commands);
			//	break;
			default: 
				System.out.println("Invalid Command. Try Again.");
				Thread.sleep(timewait);
				heroChoice(hero, commands);
				break;
		}
	}

	public static void heroLocation(Hero hero) {
		showHeroStatus(hero);
		System.out.println("\nPosition:");
		System.out.println("x:" + hero.getX());
		System.out.println("y:" + hero.getY());
		System.out.println("");
		System.out.println("Travel Directions:");
		System.out.print(" | North | South | East | West | Home | ");
		System.out.println("");
	}

	//public static void heroMap() {

	//}

	public static void moveHero(Hero hero, Scanner commands) throws InterruptedException, IOException {
		clearScreen();
		heroLocation(hero);
		System.out.print("Command: ");
		String move = commands.nextLine().toLowerCase();
		while (true) {
			switch(move) {
				case "north":
					hero.goNorth();
					Thread.sleep(timewait);
					unforeseenEvent(hero, commands);
					break;
				case "south":
					hero.goSouth();
					Thread.sleep(timewait);
					unforeseenEvent(hero, commands);
					break;
				case "west":
					hero.goWest();
					Thread.sleep(timewait);
					unforeseenEvent(hero, commands);
					break;
				case "east":
					hero.goEast();
					Thread.sleep(timewait);
					unforeseenEvent(hero, commands);
					break;
				case "home":
					heroChoice(hero, commands);
					break;
				default:
					System.out.println("Invalid Command. Try Again.");
					moveHero(hero, commands);
					break;
			}
		}
	}

	public static void checkGameStatus(Hero hero, Scanner commands) throws InterruptedException, IOException {
		int outBound = ((hero.level - 1) * 5 + 10 - (hero.level % 2) - 1) / 2;
		if (hero.x > outBound) {
			gameComplete();
		} else if (hero.y > outBound) {
			gameComplete();
		} else {
			moveHero(hero, commands);
		}
	}

	public static int posibilityGen() {
		int Min = 1;
		int Max = 100;
		int chance = Min + (int)(Math.random() * ((Max - Min) + 1));
		return chance;
	}

	public static void unforeseenEvent(Hero hero, Scanner commands) throws InterruptedException, IOException {
		Creature creature = new Creature();
		int chance = posibilityGen();
		if (chance >= 1 && chance <= 10) {
			treasureDrop(hero);
			checkGameStatus(hero, commands);
		} else if (chance >= 11 && chance <= 60) {
			creatureAppearance(hero, creature, commands);
		} else {
			System.out.println("Nothing appeared resuming exploration.");
			checkGameStatus(hero, commands);
			Thread.sleep(timewait);
		}
	}

	public static void creatureAppearance(Hero hero, Creature creature, Scanner commands)
			throws InterruptedException, IOException {
		clearScreen();
		creature.randomCreature();
		System.out.println("A Creature Appeared\n");
		Thread.sleep(timewait);
		creature.getStatus();
		System.out.println("\nAvailable Commands:");
		System.out.print(" | Fight | Escape | ");
		
		String task = commands.nextLine().toLowerCase();
		switch (task) {
			case "fight":
				System.out.println("Gone to Battle.");
				Thread.sleep(timewait);
				fightEvent(hero, creature, commands);
				break;
			case "escape":
				System.out.println("Attempting to escape.");
				Thread.sleep(timewait);
				checkGameStatus(hero, commands);
				break;
			default:
		}
	}

	public static void fightDialog() {
		System.out.println("\nFight Has Begun");
		System.out.println("Available Commands:");
		System.out.print(" | Attack | Defend | Escape | ");
	}

	public static void fightEvent(Hero hero, Creature creature, Scanner commands)
			throws InterruptedException, IOException {
		while(true) {
			clearScreen();
			showHeroStatus(hero);
			showCreatureStatus(creature);
			if (hero.hp <= 0) {
				System.out.println(hero.name +" has been defeated.");
				System.out.println("Game will now close.");
				Thread.sleep(timewait);
				System.exit(0);
			} else if (creature.hp <= 0) {
				System.out.println(creature.name + " has been defeated.");
				hero.setGold(hero.getGold() + creature.gold);
				System.out.println("You have gained " + creature.gold + " gold.");
				hero.addExp(creature.exp);
				System.out.println("You have gained " + creature.exp + " exp.");
				System.out.println("Will now resume exploring.");
				Thread.sleep(timewait);
				checkGameStatus(hero, commands);
			}
			fightDialog();
			String task = commands.nextLine().toLowerCase();
			switch (task) {
				case "attack":
					heroAtkTurn(hero, creature);
					creatureChoice(hero, creature, commands);
					break;
				case "defend":
					creatureChoice(hero, creature, commands);
					heroDefTurn(hero);
					break;
				case "escape":
					System.out.println("Attempting to escape.");
					Thread.sleep(timewait);
					checkGameStatus(hero, commands);
					break;
			}
			if (hero.hp <= 0) {
				System.out.println("You Have Been Defeated By " + creature.name + "-san.");
			}
			if (creature.hp <= 0) {
				System.out.println("You Have Defeated " + creature.name + "-san.");
			}
		}
	}

	public static void heroAtkTurn(Hero hero, Creature creature) {
		creature.creatureHit(hero.getAtk() + diceRoll() );
	}

	public static void heroDefTurn(Hero hero) {
		hero.regainHp();
	}

	public static void creatureChoice(Hero hero, Creature creature, Scanner commands) throws InterruptedException, IOException {
		int choice = posibilityGen();
		if (choice >= 1 && choice <= 90) {
			creatureRetaliate(hero, creature);
		} else if (choice >= 91 && choice <= 98) {
			creatureEscapes(hero, creature);
			moveHero(hero, commands);
		} else {
			creatureSurrenders(hero, creature);
			moveHero(hero, commands);
		}
	}

	public static void creatureRetaliate(Hero hero, Creature creature) throws InterruptedException {
		System.out.println(creature.name + "-san decided to retaliate.");
		hero.heroHit((creature.atk + diceRoll()) ,creature);
		Thread.sleep(timewait);
	}

	public static void creatureEscapes(Hero hero, Creature creature) throws InterruptedException {
		System.out.println(creature.name + "-san has ran away from the battle.");
		System.out.println("You have gained " + creature.exp + " exp.");
		hero.addExp(creature.exp);
		Thread.sleep(timewait);
	}

	public static void creatureSurrenders(Hero hero, Creature creature) throws InterruptedException {
		System.out.println(creature.name + "-san surrenders.");
		System.out.println("You have gained " + creature.exp + " exp.");
		hero.addExp(creature.exp);
		System.out.println("You have gained " + creature.gold + " gold.");
		hero.setGold(hero.getGold() + creature.gold);
		Thread.sleep(timewait);
	}

	public static void treasureDrop(Hero hero) throws InterruptedException {
		clearScreen();
		int Gold = goldGen();
		System.out.println("You Have Found A Treasure Chest.");
		System.out.println("Gold Gained: " + Gold);
		hero.setGold(hero.getGold() + Gold);
		Thread.sleep(timewait);
	}

	public static int goldGen() {
		int Min = 1;
		int Max = 5;
		int gold = Min + (int)(Math.random() * ((Max - Min) + 1));
		return gold;

	}

	public static void showHeroStatus(Hero hero) {
		clearScreen();
		System.out.println("Hero Status:");
		hero.setLevel(hero.exp);
		System.out.println("Level: " + hero.level);
		System.out.println("Experience: " + hero.exp);
		System.out.println("Attack: " + hero.atk + " | +" + hero.weapon);
		System.out.println("Defense: " + hero.def + " | +" + hero.armor);
		System.out.println("Hit Points: " + hero.hp  + " | +" + hero.accessory);
		System.out.println("Max Hit Points: " + hero.updateNewMaxHp());
	}

	public static void showCreatureStatus(Creature creature) {
		//clearScreen();
		System.out.println("");
		System.out.println("Creature Status:");
		System.out.println("Attack: " + creature.atk);
		System.out.println("Defense: " + creature.def);
		System.out.println("Hit Points: " + creature.hp);
	}

	public static void showInventory(Hero hero) {
		clearScreen();
		System.out.println("Inventory Status:");
		System.out.println("Gold: " + hero.getGold());
		System.out.println("Weapon: " +hero.getWeapon());
		System.out.println("Armor: " + hero.getArmor());
		System.out.println("Accessory: " + hero.getAccessory());
	}

	public static void shopDisctrict(Hero hero, Scanner commands) throws InterruptedException, IOException {
		clearScreen();
		System.out.println("Shopping District:");
		System.out.print(" | Blacksmith | Clinic | Home | ");
		String goTo = commands.nextLine().toLowerCase();
		switch (goTo) {
			case "blacksmith":
				blacksmithItems(hero, commands);
				break;
			case "clinic":
				clinicOptions(hero, commands);
				break;
			case "home":
				heroChoice(hero, commands);
				break;
			default:
				System.out.println("Invalid Command. Try Again.");
				Thread.sleep(timewait);
				shopDisctrict(hero, commands);
				break;
		} 
	}

	public static void blacksmithItems(Hero hero, Scanner commands) throws InterruptedException, IOException {
		clearScreen();
		System.out.println("Welcome To The Infamouse Smith-san");
		System.out.println("");
		showInventory(hero);
		System.out.println("");
		System.out.println("Upgrades to:");
		System.out.print(" | Weapon | Armor | Accessory | Leave | ");
		String category = commands.nextLine().toLowerCase();
		switch (category) {
			case "weapon":
				weaponChoices(hero, commands);
				break;
			case "armor":
				armorChoices(hero, commands);
				break;
			case "accessory":
				accessoryChoices(hero, commands);
				break;
			case "leave":
				shopDisctrict(hero, commands);
				break;
			default:
				System.out.println("Invalid Command. Try Again.");
				Thread.sleep(timewait);
				blacksmithItems(hero, commands);
				break;
		}
	}

	public static void weaponChoices(Hero hero, Scanner commands) throws InterruptedException, IOException {
		clearScreen();
		System.out.println("So you want to upgrade your weapon?");
		System.out.println("10 Gold is required.");
		System.out.print(" | Upgrade | Leave | ");
		String choice = commands.nextLine().toLowerCase();
		switch (choice) {
			case "upgrade":
				weaponUpgrade(hero, commands);
				break;
			case "leave":
				blacksmithItems(hero, commands);
				break;
			default:
				System.out.println("Invalid Command. Try Again.");
				Thread.sleep(timewait);
				weaponChoices(hero, commands);
				break;
		}
	}

	public static void armorChoices(Hero hero, Scanner commands) throws InterruptedException, IOException {
		clearScreen();
		System.out.println("So you want to upgrade your armor?");
		System.out.println("10 Gold is required.");
		System.out.print(" | Upgrade | Leave | ");
		String choice = commands.nextLine().toLowerCase();
		switch (choice) {
			case "upgrade":
				armorUpgrade(hero, commands);
				break;
			case "leave":
				blacksmithItems(hero, commands);
				break;
			default:
				System.out.println("Invalid Command. Try Again.");
				Thread.sleep(timewait);
				armorChoices(hero, commands);
				break;
		}
	}

	public static void accessoryChoices(Hero hero, Scanner commands) throws InterruptedException, IOException {
		clearScreen();
		System.out.println("So you want to upgrade your accessory?");
		System.out.println("10 Gold is required.");
		System.out.print(" | Upgrade | Leave | ");
		String choice = commands.nextLine().toLowerCase();
		switch (choice) {
			case "upgrade":
				accessoryUpgrade(hero, commands);
				break;
			case "leave":
				blacksmithItems(hero, commands);
				break;
			default:
				System.out.println("Invalid Command. Try Again.");
				Thread.sleep(timewait);
				armorChoices(hero, commands);
				break;
		}
	}

	public static void weaponUpgrade(Hero hero, Scanner commands) throws InterruptedException, IOException {
		if (hero.getGold() > 10) {
			hero.setGold(hero.getGold() - 10);
			System.out.println("Weapon has been upgraded:");
			hero.setWeapon(hero.weapon + 1);			
			hero.getWeapon();
		} else {
			System.out.println("You Do Not Have Enough Gold");
			Thread.sleep(timewait);
			weaponChoices(hero, commands);
		}
	}

	public static void armorUpgrade(Hero hero, Scanner commands) throws InterruptedException, IOException {
		if (hero.getGold() > 10) {
			hero.setGold(hero.getGold() - 10);
			System.out.println("Armor has been upgraded:");
			hero.setArmor(hero.armor + 1);			
			hero.getArmor();
		} else {
			System.out.println("You Do Not Have Enough Gold");
			Thread.sleep(timewait);
			armorChoices(hero, commands);
		}
	}

	public static void accessoryUpgrade(Hero hero, Scanner commands) throws InterruptedException, IOException {
		if (hero.getGold() > 10) {
			hero.setGold(hero.getGold() - 10);
			System.out.println("Accessory has been upgraded:");
			hero.setAccessory(hero.accessory + 1);			
			hero.getAccessory();
		} else {
			System.out.println("You Do Not Have Enough Gold");
			Thread.sleep(timewait);
			accessoryChoices(hero, commands);
		}
	}

	public static void clinicOptions(Hero hero, Scanner commands) throws InterruptedException, IOException {
		clearScreen();
		System.out.println("Welcome to the Clinic");
		System.out.print(" | Heal | Leave | ");
		String choice = commands.nextLine().toLowerCase();
		switch (choice) {
			case "heal":
				healHero(hero, commands);
				break;
			case "leave":
				shopDisctrict(hero, commands);
				break;
			default:
				System.out.println("Invalid Command. Try Again.");
				Thread.sleep(timewait);
				clinicOptions(hero, commands);
				break;
		}
	}

	public static void healHero(Hero hero, Scanner commands) throws InterruptedException {
		if (hero.getHp() < hero.maxhp) {
			if (hero.getGold() > 1) {
				hero.setGold(hero.getGold() - 1);
				hero.setHp(hero.maxhp);
				System.out.println("You have been healed up");
				Thread.sleep(timewait);
			} else {
				System.out.println("You Do Not Have Enough Gold");
				Thread.sleep(timewait);
			}
		} else {
			System.out.println("You are already on full Hp");
			Thread.sleep(timewait);
		}
		showHeroStatus(hero);
		Thread.sleep(timewait);
	}

	public static int diceRoll() {
		int Min = 1;
		int Max = 6;
		int dice = Min + (int)(Math.random() * ((Max - Min) + 1));
		return dice;
	}

	public static void gameComplete() throws InterruptedException {
		System.out.println("Congrats You Have Completed The Game.");
		System.out.println("⣿⡇⣿⣿⣿⠛⠁⣴⣿⡿⠿⠧⠹⠿⠘⣿⣿⣿⡇⢸⡻⣿⣿⣿⣿⣿⣿⣿\n⢹⡇⣿⣿⣿⠄⣞⣯⣷⣾⣿⣿⣧⡹⡆⡀⠉⢹⡌⠐⢿⣿⣿⣿⡞⣿⣿⣿\n⣾⡇⣿⣿⡇⣾⣿⣿⣿⣿⣿⣿⣿⣿⣄⢻⣦⡀⠁⢸⡌⠻⣿⣿⣿⡽⣿⣿\n⡇⣿⠹⣿⡇⡟⠛⣉⠁⠉⠉⠻⡿⣿⣿⣿⣿⣿⣦⣄⡉⠂⠈⠙⢿⣿⣝⣿\n⠤⢿⡄⠹⣧⣷⣸⡇⠄⠄⠲⢰⣌⣾⣿⣿⣿⣿⣿⣿⣶⣤⣤⡀⠄⠈⠻⢮\n⠄⢸⣧⠄⢘⢻⣿⡇⢀⣀⠄⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⡀⠄⢀\n⠄⠈⣿⡆⢸⣿⣿⣿⣬⣭⣴⣿⣿⣿⣿⣿⣿⣿⣯⠝⠛⠛⠙⢿⡿⠃⠄⢸\n⠄⠄⢿⣿⡀⣿⣿⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⣿⣿⡾⠁⢠⡇⢀\n⠄⠄⢸⣿⡇⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⣫⣻⡟⢀⠄⣿⣷⣾\n⠄⠄⢸⣿⡇⠄⠈⠙⠿⣿⣿⣿⣮⣿⣿⣿⣿⣿⣿⣿⣿⡿⢠⠊⢀⡇⣿⣿\n⠒⠤⠄⣿⡇⢀⡲⠄⠄⠈⠙⠻⢿⣿⣿⠿⠿⠟⠛⠋⠁⣰⠇⠄⢸⣿⣿⣿\n⠄⠄⠄⣿⡇⢬⡻⡇⡄⠄⠄⠄⡰⢖⠔⠉⠄⠄⠄⠄⣼⠏⠄⠄⢸⣿⣿⣿\n⠄⠄⠄⣿⡇⠄⠙⢌⢷⣆⡀⡾⡣⠃⠄⠄⠄⠄⠄⣼⡟⠄⠄⠄⠄⢿⣿⣿");
		System.out.println("Game will now Shut Down.");
		Thread.sleep(timewait);
		System.exit(0);
	}

	public static void clearScreen() {   
		System.out.print("\033[H\033[2J");   
		System.out.flush();   
	}
	
}
