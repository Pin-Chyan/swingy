package endlesshorizon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FileHandler {
	public static void writeToFile(Hero h) throws IOException, InterruptedException {
		System.out.println(h);
		Thread.sleep(5000);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(h.name + ".ser"));
	
		objectOutputStream.writeObject(h);
		objectOutputStream.close();
	}


	public static void newHero(Hero hero, Scanner myObj) throws IOException, InterruptedException {
		try {
			// write object to file
			Validator.newName(hero, myObj);
			Validator.selectClass(hero, myObj);
			//hero.setLevel(450);
			FileOutputStream fos = new FileOutputStream(hero.name + ".ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(hero);
            oos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void saveHero(Hero hero) throws IOException, InterruptedException {
		try {
			FileHandler.writeToFile(hero);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static Hero loadHero(Hero hero,Scanner myObj) throws IOException, InterruptedException {
		try {
			System.out.print("Enter Hero Name: ");
			String name = myObj.nextLine().toLowerCase();
			FileInputStream fis = new FileInputStream(name + ".ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Hero result = (Hero) ois.readObject();
			System.out.println(result);
			fis.close();
            ois.close();
            
            return (result);

		} catch (FileNotFoundException e) {
			System.out.println("The File Name Which You Inserted Does Not Exist Please Try Again Or Make A New Campaign.");
			System.exit(0);
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
        }
        return (null);
	}
}