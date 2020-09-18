package endlesshorizon;

import java.io.Serializable;

//import java.util.Objects;

public class Hero implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	protected String name;
	protected String Class; 
	protected int level = 0;
	protected int exp;
	protected int atk;
	protected int def;
	protected int hp;
	protected int maxhp;
	protected int armor;
	protected int weapon;
	protected int accessory;
	protected int mapLvl = 1;
	protected int x;
	protected int y;

		
	@Override
	public String toString() {
		return "\n\nHero:\nName: " + name + "\nClass: " + Class + "\n\nStats:\n" +"Level: " + getLevel() + 
		"\nExperience: " + getExp() + "\nAttack: " + getAtk() + "\nDefense: " + getDef() + "\nHit Points: " + hp + 
		"/" + getMaxHp() + "\n\nEquipments:" + "\nArmor: " + getArmor() + "\nWeapon: " + getWeapon() +
		"\nAccessory: " + getAccessory() + "\n\nCo-Ordinates:" + "\nMap Level: " + getMapLvl() + "\nX: " + x + "\nY: " + y;
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
		this.hp = Math.round(15 * (1 + (((float) level - 1) / 10)));
	}

	public void setFighter(int level) {
		this.atk = Math.round(7 * (1 + (((float) level - 1) / 10)));
		this.def = Math.round(5 * (1 + (((float) level - 1) / 10)));
		this.hp = Math.round(15 * (1 + (((float) level - 1) / 10)));
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
	}

	public void setLevel(int exp) {
		int lvl = 0;
		this.exp = exp;
		while (exp >= (lvl * 1000 + Math.pow(lvl - 1, 2) * 450)) {
			lvl++;
		}
		this.level = lvl;
		//statUpdate();
	}

	public int getLevel() {
		return this.level;
	}

	public int getExp() {
		return this.exp;
	}

	public void addExp(int exp) {
		this.exp += exp;
		setLevel(this.exp);
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
		return this.hp + this.accessory;
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

	public int getMapLvl() {
		return this.mapLvl;
	}

	public void goNorth() {
		this.y += 1;
	}

	public void goSouth() {
		this.y -= 1;
	}

	public void goWest() {
		this.x -= 1;
	}

	public void goEast() {
		this.x += 1;
	}

}
