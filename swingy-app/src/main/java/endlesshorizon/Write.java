package endlesshorizon;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class Write {
	public static void writeToFile(Hero h) throws IOException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Hero.txt"));
	
		objectOutputStream.writeObject(h);
	}
}
