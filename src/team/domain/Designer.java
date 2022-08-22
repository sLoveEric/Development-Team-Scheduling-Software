/**
 * 
 */
package team.domain;

/**
 * @Description
 * @author SW
 * @version
 * @date Jun. 24, 2022 11:18:04 p.m.
 *
 */
public class Designer extends Programmer {
	private double bonus;

	public Designer() {
		super();
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
		super(id, name, age, salary, equipment);
		this.bonus = bonus;
	}

	@Override
	public String toString() {

		return getDetails() + "\tDesigner\t" + getStatus() + "\t" + bonus + "\t\t" + getEquipment().getDescription();
	}
	
	public String getDetailsOfTeam() {
		return getTeamBasicInfo() + "\tDesigner\t" + getBonus();
	}

}
