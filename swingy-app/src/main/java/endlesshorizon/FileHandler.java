package endlesshorizon;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileHandler {
	public static void writeToFile(Hero h) throws IOException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(h.name + ".bin"));
	
		objectOutputStream.writeObject(h);
	}

	public static void readFile(Hero hero,String name) throws IOException, ClassNotFoundException {
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(name + ".bin"));
		

		hero = (Hero) objectInputStream.readObject();
		System.out.println(hero);
	}

	public static void newHero(Hero hero, Scanner myObj) throws IOException {
		Validator.newName(hero, myObj);
		hero.setLevel(450);
		Validator.selectClass(hero, myObj);
		//hero.addExp(11000);
		hero.statUpdate();
		try {
			FileHandler.writeToFile(hero);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static void saveHero(Hero hero) throws IOException {
		try {
			FileHandler.writeToFile(hero);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static void loadHero(Hero hero,Scanner myObj) throws IOException {
		System.out.print("Enter Hero Name: ");
		String name = myObj.nextLine().toLowerCase();
		try {
			FileHandler.readFile(hero ,name);
		} catch (ClassNotFoundException | IOException e) {
			System.out.println(e.getMessage());
		}
	}
}