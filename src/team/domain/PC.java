/**
 * 
 */
package team.domain;

/**
 * @Description
 * @author SW
 * @version
 * @date Jun. 23, 2022 9:15:35 p.m.
 *
 */
public class PC implements Equipment {

	private String model;// Model name
	private String display;// Screen name

	public PC(String model, String display) {
		super();
		this.model = model;
		this.display = display;
	}

	public PC() {
		super();
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	@Override
	public String getDescription() {

		return model + "(" + display + ")";
	}

}
