/**
 * 
 */
package team.domain;

/**
 * @Description
 * @author SW
 * @version
 * @date Jun. 24, 2022 11:19:44 p.m.
 *
 */
public class Architect extends Designer {
    private int stock;

    public Architect() {
    	
    }

	public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
		super(id, name, age, salary, equipment, bonus);
		this.stock = stock;
	}


	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {

		return getDetails() + "\tDesigner\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment().getDescription();
	
	}
	
	public String getDetailsOfTeam() {
		return getTeamBasicInfo() + "\tArchitect\t" + getBonus() +"\t" + getStock();
	}


}
