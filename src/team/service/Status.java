/**
 * 
 */
package team.service;

/**
 * @Description Employee status
 * @author SW
 * @version
 * @date Jun. 24, 2022 9:20:26 p.m.
 *
 */
public class Status {
	
	private final String NAME;
	private Status (String name) {
		this.NAME = name;
	}	
	
	public static final Status FREE = new Status("FREE");
	public static final Status BUSY = new Status("BUSY");
	public static final Status VOCATION = new Status("VACATION");
	
	public String getNAME() {
		return NAME;
	}
	
	@Override
	public String toString() {
		return NAME;
	}
}
