package endlesshorizon;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */

public class App 
{
	
	public static void main( final String[] args) throws IOException, InterruptedException {
		Hero hero = new Hero();
		final Scanner myObj = new Scanner(System.in);

		if (args.length != 1 || (!args[0].equals("console")) && (!args[0].equals("gui"))) {
			System.out.println("Command is invalid please try again for instance:");
			System.out.println("java -jar [path] console || gui");
			System.exit(0);
		}

		if (args[0].equals("console")) {
			hero = Validator.startUp(hero , myObj);
			GameEngine.gameStart(hero, myObj);
			System.exit(0);
		} else if (args[0].equals("gui")) {
			new Gui();
			hero = Validator.startUp(hero , myObj);
			GameEngine.gameStart(hero, myObj);
			System.exit(0);
		}
	}

}
