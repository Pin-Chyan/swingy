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
		System.out.println(hero.name);
		Level lvl = new Level(450);
		hero.level = lvl;
		System.out.println(hero.level.getLevel());
		//System.out.println(hero.level.getNextLevel());
		System.out.println(hero.level.getExp());
		hero.classSet("paladin");
		System.out.println(hero.Class);
		System.out.println("atk = " + hero.stats.atk);
		System.out.println("def = " + hero.stats.def);
		System.out.println("hp = " + hero.stats.hp);
		hero.Class.getClass();
		//System.out.println("armor = " + hero.equipments.getArmor());
		//System.out.println("weapon = " + hero.equipments.getWeapon());
		//System.out.println("accessories = " + hero.equipments.getAccessories());
		try {
			Write.writeToFile(hero);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println((e.getMessage()));
		}
	}
}


//level*1000+(level − 1)2*450.
