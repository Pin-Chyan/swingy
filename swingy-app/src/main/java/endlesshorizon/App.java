package endlesshorizon;

import java.io.IOException;

/**
 * Hello world!
 *
 */

public class App 
{
	
	public static void main( String[] args ) throws IOException
    {
		newHero();
	}

	public static void newHero() throws IOException {
		Hero hero = new Hero();
		hero.name = "jacks";
		//System.out.println(hero.name);
		hero.setLevel(450);
		//System.out.println(hero.getLevel());
		//System.out.println(hero.getNextLevel());
		//System.out.println(hero.getExp());
		hero.classSet("paladin");
		//System.out.println(hero.Class);
		//System.out.println("atk = " + hero.atk);
		//System.out.println("def = " + hero.def);
		//System.out.println("hp = " + hero.hp);
		//hero.Class.getClass();
		//System.out.println("armor = " + hero.equipments.getArmor());
		//System.out.println("weapon = " + hero.equipments.getWeapon());
		//System.out.println("accessories = " + hero.equipments.getAccessories());
		hero.addExp(11000);
		hero.statUpdate();
		//hero.goNorth();
		try {
			Write.writeToFile(hero);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		try {
			Write.readFile();
		} catch (ClassNotFoundException | IOException e) {
			System.out.println(e.getMessage());
		}
		//System.out.println("atk = " + hero.atk);
		//System.out.println("def = " + hero.def);
		//System.out.println("hp = " + hero.hp);
		
	}
}


//level*1000+(level − 1)2*450.
