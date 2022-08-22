package team.junit;

import org.junit.Test;

import team.domain.Employee;
import team.service.NameListService;
import team.service.TeamException;

/**
 * 
 * @Description Test for NameListService class
 * @author SW
 * @version
 * @date Jun. 27, 2022 3:46:46 p.m.
 *
 */
public class NameListServiceTest {

	@Test
	public void testGetAllEmployees() {
		NameListService service = new NameListService();
		Employee[] employees = service.getAllEmployees();

		for (int i = 0; i < employees.length; i++) {
			System.out.println(employees[i]);
		}
	}

	@Test
	public void testGetEmployee() {
		NameListService service = new NameListService();
		int id = 100;
		
		try {
			Employee employees = service.getEmployee(id);
			System.out.println(employees);
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
	}
}
