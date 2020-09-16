package endlesshorizon;

import java.io.Serializable;

//import java.util.Objects;

public class Hero implements Serializable {
	protected String name;
	protected String Class; 
	protected Level level;
	protected Stats stats = new Stats();
	protected Equipments equipments = new Equipments();

	//public Hero(String name) {
	//	this.name = name;
	//}
	
	@Override
	public String toString() {
		return "Hero [name= " + name + "]";
	}

	public void classSet(String Class) {
		String type = Class.toLowerCase();
		switch (type) {
			case "paladin":
				this.Class = type;
				stats.setPaladin(this.level);
				break;
			case "rogue" :
				this.Class = type;
				stats.setRogue(this.level);
				break;
			case "warrior":
				this.Class = type;
				stats.setWarrior(this.level);
				break;
			case "fighter":
				this.Class = type;
				stats.setFighter(this.level);
				break;
		}

	}
}
