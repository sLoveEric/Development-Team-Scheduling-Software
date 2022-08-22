/**
 * 
 */
package team.service;

import team.domain.Architect;
import team.domain.Designer;
import team.domain.Employee;
import team.domain.Equipment;
import team.domain.NoteBook;
import team.domain.PC;
import team.domain.Printer;
import team.domain.Programmer;
import static team.service.Data.*;

import java.awt.geom.Area;

/**
 * @Description
 * @author SW
 * @version
 * @date Jun. 24, 2022 11:22:25 p.m.
 *
 */
public class NameListService {

	private Employee[] employees;

	public NameListService() {
		employees = new Employee[EMPLOYEES.length];
		
		for (int i = 0; i < employees.length; i++) {
			//
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			// 4 Common info
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);
			
			Equipment equipment;
			double bonus;
			int stock;
			
			switch(type) {
			case EMPLOYEE:
				employees[i] = new Employee(id, name, age, salary);
				break;
			case PROGRAMMER:
				equipment = createEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			case DESIGNER:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equipment, bonus);
				break;
			case ARCHITECT:
				equipment = createEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				stock = Integer.parseInt(EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
			}
		}
	}

	/**
	 * @Description Equipment for certain employee
	 * @author SW
	 * @date Jun. 27, 2022 10:43:32 a.m.
	 *
	 */
	private Equipment createEquipment(int index) {
		int key = Integer.parseInt(EQUIPMENTS[index][0]);
		String model = EQUIPMENTS[index][1];
		switch (key) {
		case PC://21
			String display = EQUIPMENTS[index][2];
			return new PC(model, display);
		case NOTEBOOK://22
			double price = Double.parseDouble(EQUIPMENTS[index][2]);
			return new NoteBook(model, price);
		case PRINTER://23
			String type = EQUIPMENTS[index][2];
			return new Printer(model, type);

		}
		return null;
	}

	public Employee[] getAllEmployees() {
		return employees;
	}
/**
 * 
 * @Description get certain ID employee
 * @author SW
 * @throws TeamException 
 * @date Jun. 27, 2022 12:02:14 p.m.
 *
 */
	public Employee getEmployee(int id) throws TeamException {
		for (int i = 0; i < EMPLOYEES.length; i++) {
			if (employees[i].getId() == id) {
				return employees[i];
			}
		}
		throw new TeamException("Did not found");

	}

}
