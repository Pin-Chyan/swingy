package com.ctaljaar.swingy.model;

import java.io.*;
import java.util.*;
import com.ctaljaar.swingy.controller.CharacterValidator;
import com.ctaljaar.swingy.util.Globals;

public class FileHandler {
	public static void createCharacter(String name, String heroClass) {
        try {
			Player player = new Player(name, heroClass);

			// write object to file
			FileOutputStream fos = new FileOutputStream("saves/heroes/" + name + ".ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(player);
            oos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String validateCharacter(String mode) {
		Scanner scanner = Globals.scanner;
        String name = "";
		String heroClass = "";
		
		name = CharacterValidator.validateName(scanner, mode);
		if (mode.equals("create")) {
			heroClass = CharacterValidator.validateClass(scanner);
            FileHandler.createCharacter(name, heroClass);
        }
            
        if (mode.equals("Create")) {
            System.out.println("Character created");
            return (name);
        } else { 
            System.out.println("Character accepted.\nLoading character");
            return (name);
        }
	}

	public static Player loadPlayer(String name) {
        try {
			FileInputStream fis = new FileInputStream("saves/heroes/" + name + ".ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Player result = (Player) ois.readObject();
			fis.close();
            ois.close();
            
            return (result);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
        }
        return (null);
    }
        
	public static void updatePlayer(Player player) {
        try {
            File f = new File("saves/heroes/" + player.getName() + ".ser");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(player);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            System.out.println("IO EXCEPTION UPDATING");
            return;
        }
    }
}