package endlesshorizon;

public class Level {
	protected int level = 0;
	protected int exp;

	Level(int exp) {
		int lvl = 0;
		this.exp = exp;
		while (exp >= (lvl * 1000 + Math.pow(lvl - 1, 2) * 450)) {
			lvl++;
		}
		setLevel(lvl);
	}

	private void setLevel(int lvl) {
		this.level = lvl;
	}

	public int getLevel() {
		return this.level;
	}

	public int getExp() {
		return this.exp;
	}

	public int getNextLevel() {
		this.level = this.level + 1;
		return this.level;
	}
}

//level*1000+(level − 1)2*450.
