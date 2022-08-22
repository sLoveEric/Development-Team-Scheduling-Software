/**
 * 
 */
package team.domain;

import team.domain.Employee;
import team.domain.Equipment;

import team.service.Status;

/**
 * @Description
 * @author SW
 * @version
 * @date Jun. 24, 2022 6:03:56 p.m.
 *
 */
public class Programmer extends Employee {
    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer() {
    }

    public Programmer(int id, String name, int age, 
                       double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    protected String getMemberDetails() {
        return getMemberId() + "/" + getDetails();
    }

    public String getDetailsForTeam() {
        return getMemberDetails() + "\tProgrammer";
    }

    @Override
    public String toString() {
        return getDetails() + "\tProgrammer\t" + status + "\t\t\t" + equipment.getDescription() ;
    }
}
