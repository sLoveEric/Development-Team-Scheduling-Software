/**
 * 
 */
package team.service;

import java.util.Iterator;

import team.domain.Architect;
import team.domain.Designer;
import team.domain.Employee;
import team.domain.Programmer;

/**
 * @Description Team member add delet
 * @author SW
 * @version
 * @date Jun. 27, 2022 5:07:47 p.m.
 *
 */
public class TeamService {

	private static int counter = 1; // to value memberId
	private final int MAX_MEMBER = 5; // max team member
	private Programmer[] team = new Programmer[MAX_MEMBER];// team members list
	private int total = 0;// team members number

	public TeamService() {
		super();
	}

	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for (int i = 0; i < team.length; i++) {
			team[i] = this.team[i];

		}
		return team;
	}

	// add certain employee into a team
	public void addMember(Employee e) throws TeamException {
//	Team full
		if (total >= MAX_MEMBER) {
			throw new TeamException("Team is full");
		}
//	Employee is not an programmer
		if (!(e instanceof Programmer)) {
			throw new TeamException("Employee is not an programmer");
		}
//	Already a team member
		if (isExist(e)) {
			throw new TeamException("Already a team member");
		}
//	Already in another team
//  On vaccation
		Programmer p = (Programmer) e;
		if ("BUSY".equals(p.getStatus().getNAME())) {
			throw new TeamException("Already in another team");
		} else if ("VACATION".equals(p.getStatus().getNAME())) {
			throw new TeamException("Already in another team");
		}

//	No more than ONE architect
//	No more than TWO designer
//	No more than Three programmer

		// exist team member of architect designer and programmer
		int numOfArch = 0, numOfDes = 0, numOfPro = 0;
		for (int i = 0; i < total; i++) {
			if (team[i] instanceof Architect) {
				numOfArch++;
			} else if (team[i] instanceof Designer) {
				numOfDes++;
			} else {
				numOfPro++;
			}
		}
		if (p instanceof Architect) {
			if (numOfArch >= 1) {
				throw new TeamException("No more than ONE architect");
			}
		} else if (p instanceof Designer) {
			if (numOfDes >= 2) {
				throw new TeamException("No more than TWO designer");
			} else {
				if (numOfPro >= 3) {
					throw new TeamException("No more than Three programmer");
				}
			}
		}
		//Put p(or e) into team
		team[total++] = p;
		//change status of 'p'
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);
	}

	/**
	 * 
	 * @Description Determine if it already exists in the team
	 * @author SW
	 * @date Jun. 28, 20229:54:31 a.m.
	 *
	 */
	private boolean isExist(Employee e) {
		for (int i = 0; i < total; i++) {
			if (team[i].getId() == e.getId()) {
				return true;
			}
		}
		return false;
	}

	public void removeMember(int memberId) throws TeamException {
		int i = 0;
		for (; i < total; i++) {
			if (team[i].getMemberId() == memberId) {
				team[i].setStatus(Status.FREE);
				break;
			}
		}	
		
		if (i == total) {
			throw new TeamException("Did not find this MemberID");
		}
		//The latter element overwrites the previous element 
		//to implement the delete operation
		for (int j = i + 1; j < total; j++) {
			team[j - 1] = team[j];					
		}
		team[--total] = null;
	
	}

}
