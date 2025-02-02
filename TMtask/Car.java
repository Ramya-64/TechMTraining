package TMtask;

//base class
public class Car {

	// method to start engine
	public void startEngine() {
		System.out.println(util.ENGINE_STARTED + make + ", " + model);
	}

	// private variables
	private String make;
	private String model;
	private int Year;

	// constructor
	public Car(String make, String model, int Year) {
		this.make = make;
		this.model = model;
		this.Year = Year;
	}

	// getters and setters
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int Year) {
		this.Year = Year;
	}
}
