/**
 * 
 */
package team.domain;

/**
 * @Description
 * @author SW
 * @version
 * @date Jun. 24, 2022 5:55:08 p.m.
 *
 */
public class NoteBook implements Equipment {

	private String model;
	private double price;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public NoteBook() {
		super();
	}

	public NoteBook(String model, double price) {
		super();
		this.model = model;
		this.price = price;
	}

	@Override
	public String getDescription() {

		return model + "(" + price + ")";
	}

}
