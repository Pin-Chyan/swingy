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

		//GameEngine.unforeseenEvent();
		hero = Validator.startUp(hero , myObj);
		//System.out.println(hero);
		GameEngine.gameStart(hero, myObj);

	}

}


//level*1000+(level − 1)2*450.
