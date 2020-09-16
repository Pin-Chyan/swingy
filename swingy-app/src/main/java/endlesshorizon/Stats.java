package endlesshorizon;

public class Stats {
	protected int atk;
	protected int def;
	protected int hp;

	Stats() {
		this.atk = 0;
		this.def = 0;
		this.hp = 0;
	}

	public void setPaladin(Level level) {
		this.atk = Math.round(5 * (1 + (((float) level.getLevel() - 1) / 10)));
		this.def = Math.round(5 * (1 + (((float) level.getLevel() - 1) / 10)));
		this.hp = Math.round(20 * (1 + (((float) level.getLevel() - 1) / 10)));
	}

	public void setRogue(Level level) {
		this.atk = Math.round(10 * (1 + (((float) level.getLevel() - 1) / 10)));
		this.def = Math.round(2 * (1 + (((float) level.getLevel() - 1) / 10)));
		this.hp = Math.round(10 * (1 + (((float) level.getLevel() - 1) / 10)));
	}

	public void setWarrior(Level level) {
		this.atk = Math.round(8 * (1 + (((float) level.getLevel() - 1) / 10)));
		this.def = Math.round(4 * (1 + (((float) level.getLevel() - 1) / 10)));
		this.hp = Math.round(15 * (1 + (((float) level.getLevel() - 1) / 10)));
	}

	public void setFighter(Level level) {
		this.atk = Math.round(7 * (1 + (((float) level.getLevel() - 1) / 10)));
		this.def = Math.round(5 * (1 + (((float) level.getLevel() - 1) / 10)));
		this.hp = Math.round(15 * (1 + (((float) level.getLevel() - 1) / 10)));
	}

	
}
