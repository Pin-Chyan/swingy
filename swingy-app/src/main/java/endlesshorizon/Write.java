package endlesshorizon;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Write {
	public static void writeToFile(Hero h) throws IOException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Hero.bin"));
	
		objectOutputStream.writeObject(h);
	}

	public static void readFile() throws IOException, ClassNotFoundException {
		ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Hero.bin"));
		

		Hero hero = (Hero) objectInputStream.readObject();
		System.out.println(hero);
	}
}