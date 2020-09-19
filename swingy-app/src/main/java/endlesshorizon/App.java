package endlesshorizon;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */

public class App 
{
	
	public static void main( String[] args ) throws IOException
    {
		Hero hero = new Hero();
		Scanner myObj = new Scanner(System.in);
		
		Validator.startUp(hero , myObj);
		GameEngine.gameStart(hero, myObj);
	}

}


//level*1000+(level − 1)2*450.
