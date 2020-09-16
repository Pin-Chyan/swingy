package endlesshorizon;

public class Equipments {
	protected String armor;
	protected String weapon;
	protected String accessories;

	Equipments() {
		setArmor("none");
		setWeapon("none");
		setAccessories("none");
	}

	public void setArmor(String armor) {
		this.armor = armor;
	}
	
	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public void setAccessories(String accessories) {
		this.accessories = accessories;
	}

	public String getArmor() {
		return this.armor;
	}
	
	public String getWeapon() {
		return this.weapon;
	}

	public String getAccessories() {
		return this.accessories;
	}
}
