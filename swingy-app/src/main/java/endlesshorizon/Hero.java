package endlesshorizon;

import java.io.Serializable;
import javax.validation.constraints.*;

//import java.util.Objects;

public class Hero implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected String name;
	protected String Class; 
	protected String look;
	protected int level = 0;
	protected int exp;
	protected int atk;
	protected int def;
	protected int hp;
	protected int maxhp;
	protected int gold;
	protected int armor;
	protected int weapon;
	protected int accessory;
	protected int x;
	protected int y;

	Hero(){
		level = 1;
		exp = 1020;
		gold = 100;
		armor = 0;
		weapon = 0;
		accessory = 0;
		x = 0;
		y = 0;
		look = "                            __\r\n                         ,''  ``.\r\n                       .' ,'. `. `.\r\n                     .',':,-|,_ \\ .`,\r\n                      `. |-  - ; ).'\r\n                        \\|`'-.',\\)\r\n                       _..`   x<._\r\n                     ,'       x   `.\r\n                    |   _ -   x     |\r\n                    ; -'      _x  `.|\r\n                   :      _.-'/|`.  (\r\n                   |__..-'    `|  `-.\\\r\n                   /  |              |\r\n                   :  |              |\r\n                   |  |              :\r\n                   |  :    \\          :\r\n                   ;   \\    `         |\r\n                  :     \\         \\   |\r\n                  |      \\         :  |\r\n                  |  /   /\\        |  |\r\n                  | :   /__\\       |  |\r\n                  |    /   :: \\       :\r\n                  |   :|   |:          :\r\n                  |   ||.-.| \\     |   |\r\n                  ;   |)   (  ).   |   |\r\n                 :    ;\\___/  \\_\\  ;   |\r\n                 |   / |__[)  (]_\\     |\r\n                 |  :  |  :-  |  :)    |\r\n                 |  |  |  |-  |  |`.   |\r\n                 |  ;  |  |-  |  |  \\  |\r\n                 | /   |  ;\\  |  |   `.|\r\n                 |/    ;._\\'`-;  (._   \\\r\n                 |   ,/`-,(  / `,',_`._/\r\n                 |/`'(__.'   `-'.:__)";
	};

	//public void Hero() {
	//	level = 1;
	//	exp = 450;
	//	gold = 0;
	//	armor = 0;
	//	weapon = 0;
	//	accessory = 0;
	//	x = 0;
	//	y = 0;
	//}
		
	@Override
	public String toString() {
		return "\n\nHero:\nName: " + this.name + "\nClass: " + this.Class + "\n\nStats:\n" +"Level: " + getLevel() + 
		"\nExperience: " + getExp() + "\nAttack: " + getAtk() + "\nDefense: " + getDef() + "\nHit Points: " + hp + 
		"/" + this.maxhp + "\n\nEquipments:" + "\nArmor: " + getArmor() + "\nWeapon: " + getWeapon() +
		"\nAccessory: " + getAccessory() + "\n\nCo-Ordinates:" + "\nX: " + x + "\nY: " + y;
	}

	public void setPaladin(int level) {
		this.atk = Math.round(5 * (1 + (((float) level - 1) / 10)));
		this.def = Math.round(5 * (1 + (((float) level - 1) / 10)));
		this.hp = Math.round(20 * (1 + (((float) level - 1) / 10)));
	}

	public void setRogue(int level) {
		this.atk = Math.round(10 * (1 + (((float) level - 1) / 10)));
		this.def = Math.round(2 * (1 + (((float) level - 1) / 10)));
		this.hp = Math.round(10 * (1 + (((float) level - 1) / 10)));
	}

	public void setWarrior(int level) {
		this.atk = Math.round(8 * (1 + (((float) level - 1) / 10)));
		this.def = Math.round(4 * (1 + (((float) level - 1) / 10)));
		this.hp = Math.round(12 * (1 + (((float) level - 1) / 10)));
	}

	public void setFighter(int level) {
		this.atk = Math.round(7 * (1 + (((float) level - 1) / 10)));
		this.def = Math.round(5 * (1 + (((float) level - 1) / 10)));
		this.hp = Math.round(15 * (1 + (((float) level - 1) / 10)));
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void classSet(String Class) {
		String type = Class.toLowerCase();
		switch (type) {
			case "paladin":
				this.Class = type;
				setPaladin(this.level);
				break;
			case "rogue" :
				this.Class = type;
				setRogue(this.level);
				break;
			case "warrior":
				this.Class = type;
				setWarrior(this.level);
				break;
			case "fighter":
				this.Class = type;
				setFighter(this.level);
				break;
		}
		this.getMaxHp();
	}

	public void statUpdate() {
		String type = this.Class.toLowerCase();
		switch (type) {
			case "paladin":
				this.Class = type;
				setPaladin(this.level);
				break;
			case "rogue" :
				this.Class = type;
				setRogue(this.level);
				break;
			case "warrior":
				this.Class = type;
				setWarrior(this.level);
				break;
			case "fighter":
				this.Class = type;
				setFighter(this.level);
				break;
		}
		this.getMaxHp();
	}

	public void setLevel(int exp) {
		int lvl = 0;
		this.exp = exp;
		while (exp >= (lvl * 1000 + Math.pow(lvl - 1, 2) * 450)) {
			lvl++;
			//System.out.println((lvl * 1000 + Math.pow(lvl - 1, 2) * 450));
		}
		//System.out.println(this.name + " has leveled up to " + (lvl - 1));
		this.level = lvl -1;
	}

	public int getLevel() {
		return this.level;
	}

	public int getExp() {
		return this.exp;
	}

	public void addExp(int exp) {
		int currentlvl = this.level;
		this.exp += exp;
		setLevel(this.exp);
		if (currentlvl < this.level) {
			this.statUpdate();
		}
	}

	public int getAtk() {
		return this.atk + this.weapon;
	}

	public int getDef() {
		return this.def + this.armor;
	}

	public int getHp() {
		return this.hp;
	}

	public int getMaxHp() {
		this.maxhp = this.hp + this.accessory;
		return this.maxhp;
	}

	public int updateNewMaxHp() { // after equipment update
		if (maxhp == hp) {
			return this.maxhp;
		} else {
			this.maxhp = this.maxhp + this.accessory;
		}
		return this.maxhp;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getGold() {
		return this.gold;
	}

	public void setAtk(int value) {
		this.atk = value;
	}

	public void setDef(int value) {
		this.def = value;
	}

	public void setHp(int value) {
		this.hp = value;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public void setWeapon(int weapon) {
		this.weapon = weapon;
	}

	public void setAccessory(int acc) {
		this.accessory = acc;
	}

	public String getArmor() {
		String armor = "";
		switch(this.armor) {
			case 0:
				armor = "None | +" + this.armor + " Defense.";
				break ;
			case 1:
				armor = "Leather | +" + this.armor + " Defense.";
				break ;
			case 2:
				armor = "Chainmail | +" + this.armor + " Defense.";
				break ;
		}
		return armor;
	}

	public String getWeapon() {
		String weapon = "";
		switch(this.weapon) {
			case 0:
				weapon = "None | +" + this.weapon + " Attack.";
				break ;
			case 1:
				weapon = "Short Sword | +" + this.weapon + " Attack.";
				break ;
			case 2:
				weapon = "Long Sword | +" + this.weapon + " Attack.";
				break ;
		}
		return weapon;
	}

	public String getAccessory() {
		String acc = "";
		switch(this.accessory) {
			case 0:
				acc = "None | +" + this.accessory + " Hit Points";
				break ;
			case 1:
				acc = "Bronze Necklace | +" + this.accessory + " Hit Points";
				break ;
			case 2:
				acc = "Silver Necklace | +" + this.accessory + " Hit Points";
				break ;
		}
		return acc;
	}

	public void goNorth() {
		System.out.println("You Have Gone North");
		this.y += 1;
	}

	public void goSouth() {
		System.out.println("You Have Gone South");
		this.y -= 1;
	}

	public void goWest() {
		System.out.println("You Have Gone West");
		this.x -= 1;
	}

	public void goEast() {
		System.out.println("You Have Gone East");
		this.x += 1;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void heroHit(int dmg, Creature creature) {
		if (getDef() > dmg) {
			System.out.println(creature.name +" failed attack against the " + this.name);
		} else {
			int dmgDealt = (dmg - getDef());
			System.out.println(creature.name + " Damage Inflicted: " + dmgDealt);
			this.hp -= dmgDealt;
		}
	}

	public void regainHp() {
		int Min = this.maxhp / 4;
		int Max = this.maxhp;
		int hpRegen = Min + (int)(Math.random() * ((Max - Min) + 1));
		int hpRes = this.hp + hpRegen;
		if (hpRes > this.maxhp) {
			this.hp = this.maxhp;
		} else {
			this.hp = hpRes;
		}
	}
}
