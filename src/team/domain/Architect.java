/**
 * 
 */
package team.domain;

import team.domain.Designer;
import team.domain.Equipment;

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

    public Architect(int id, String name, int age, double salary,
                      Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDetailsForTeam() {
        return getMemberDetails() + "\tArchitect\t" + 
               getBonus() + "\t" + getStock();
    }

    @Override
    public String toString() {
        return getDetails() + "\tArchitect\t" + getStatus() + "\t" +
               getBonus() + "\t" + getStock() + "\t" + getEquipment().getDescription();
    }
}