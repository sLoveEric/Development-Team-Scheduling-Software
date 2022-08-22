/**
 * 
 */
package team.view;

import team.domain.Employee;
import team.domain.Programmer;
import team.service.NameListService;
import team.service.TeamException;
import team.service.TeamService;

/**
 * @Description
 * @author SW
 * @version
 * @date Jun. 28, 2022 11:37:46 a.m.
 *
 */
public class TeamView {

	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();

	public void enterMainMenu() {

		boolean loopFlag = true;
		char menu = 0;
		while (loopFlag) {
			
			if (menu != '1') {
				listAllEmployees();
			}
			
			System.out.print("1-TeamList  2-AddMember  3-DeletMember 4-Exit   Select(1-4)：");
			menu = TSUtility.readMenuSelection();
			switch (menu) {
			case '1':
				getTeam();
				break;

			case '2':
				addMember();
				break;

			case '3':
				deleteMember();
				break;

			case '4':
				System.out.println("Are you sure to Exit (Y/N): ");
				char isExit = TSUtility.readConfirmSelection();
				if (isExit == 'Y') {
					loopFlag = false;
				}
				break;
			}
		}while (loopFlag);

	}

	/**
	 * Show info of all employees
	 * 
	 * @Description
	 * @author SW
	 * @date Jun. 28, 202211:43:04 a.m.
	 *
	 */
	private void listAllEmployees() {
		System.out.println("\n-----------------------------------Employees List------------------------------------\n");

		Employee[] employees = listSvc.getAllEmployees();

		if (employees == null || employees.length == 0) {
			System.out.println("No employee found!");
		} else {
			System.out.println("TID/ID\tName\tAge\tSalary\tTitle\tStatus\tBonus\tStock\tEqupment");

			for (int i = 0; i < employees.length; i++) {
				System.out.println(employees[i]);
			}
		}
		System.out.println("\n-------------------------------------------------------------------------------------\n");
	}

	private void getTeam() {
		System.out.println("\n------------------------Team Member List-------------------------\n");
		
		Programmer[] team = teamSvc.getTeam();
		if (team == null || team.length == 0) {
			System.out.println("No team member found");
		}else {
			System.out.println("TID/ID\tName\tAge\tSalary\tTitle\tBonus\tStock");
			for (int i = 0; i < team.length; i++) {
				System.out.println(team[i].getDetailsOfTeam());
			}
		}
		
		System.out.println("\n-----------------------------------------------------------------\n");
	}

	private void addMember() {
		System.out.println("\n-------------------------Add Team Member--------------------------\n");
		System.out.print("Please input ID of added TM: ");
		int id = TSUtility.readInt();
				
		try {
			Employee emp = listSvc.getEmployee(id);
			teamSvc.addMember(emp);
			System.out.println("Adding Success");
			TSUtility.readReturn();//press enter to continue
		} catch (Exception e) {
			System.out.println("Adding fail, reason: " + e.getMessage());
		}
		
	}

	private void deleteMember() {
		System.out.println("\n-----------------------Delete Team Member------------------------\n");
		System.out.print("Please input ID of deleted TM: ");
		int id = TSUtility.readInt();
		System.out.print("Are you sure to delete? (Y/N)");
		char isDelete = TSUtility.readConfirmSelection();
		if (isDelete == 'N') {
			return;
		}
		
		try {
			teamSvc.removeMember(id);
			System.out.println("Deleted!");
		} catch (TeamException e) {
			System.out.println("Delete fail, reason: " + e.getMessage());
		}
		//press enter to continue
		TSUtility.readReturn();
		
	}

	public static void main(String[] args) {
		TeamView view = new TeamView();
		view.enterMainMenu();
	}

}
