package endlesshorizon;

public class Creature {
	protected String name;
	protected int atk;
	protected int def;
	protected int hp;
	protected int gold;
	protected int exp;

	public void randomCreature() {
		int creature = generateCreatureRandom();
		switch (creature) {
			case 1:
				setSlime();
				break;
			case 2:
				setGoblin();
				break;
			case 3:
				setWolf();
				break;
			case 4:
				setFlan();
				break;
			case 5:
				setHarpy();
				break;
		}
	}

	public void getStatus() {
		System.out.println("Creature Status:");
		System.out.println("Name: " + this.name);
		System.out.println("Attack: " + this.atk);
		System.out.println("Defense: " + this.def);
		System.out.println("Hit Points: " + this.hp);
	}

	public static int generateCreatureRandom() {
		int Min = 1;
		int Max = 5;
		int creature = Min + (int)(Math.random() * ((Max - Min) + 1));
		return creature;
	}

	public static int generateGoldRandom() {
		int Min = 0;
		int Max = 3;
		int creature = Min + (int)(Math.random() * ((Max - Min) + 1));
		return creature;
	}

	public static int generateExpDrop() {
		//int Min = 100;
		int Min = 600;
		//int Max = 250;
		int Max = 700;
		int exp = Min + (int)(Math.random() * ((Max - Min) + 1));
		return exp;
	}

	public void creatureHit(int dmg) {
		if (this.def > dmg) {
			System.out.println("Failed attack against the " + this.name);
		} else {
			int dmgDealt = (dmg - this.def);
			System.out.println("Damage Inflicted: " + dmgDealt);
			this.hp -= dmgDealt;
		}
	}

	public void setSlime() {
		this.name = "Slime";
		this.atk = 1;
		this.def = 7;
		this.hp = 15;
		this.exp = generateExpDrop();
		this.gold = generateGoldRandom();
	}

	public void setGoblin() {
		this.name = "Goblin";
		this.atk = 3;
		this.def = 4;
		this.hp = 12;
		this.exp = generateExpDrop();
		this.gold = generateGoldRandom();
	}

	public void setWolf() {
		this.name = "Wolf";
		this.atk = 5;
		this.def = 1;
		this.hp = 14;
		this.exp = generateExpDrop();
		this.gold = generateGoldRandom();
	}

	public void setFlan() {
		this.name = "Flan";
		this.atk = 2;
		this.def = 4;
		this.hp = 20;
		this.exp = generateExpDrop();
		this.gold = generateGoldRandom();
	}

	public void setHarpy() {
		this.name = "Harpy";
		this.atk = 4;
		this.def = 3;
		this.hp = 8;
		this.exp = generateExpDrop();
		this.gold = generateGoldRandom();
	}
}
