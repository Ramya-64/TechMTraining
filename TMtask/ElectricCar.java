package TMtask;

//subclass
public class ElectricCar extends Car {
	// private variable
	private int batteryRange;

	// constructor
	public ElectricCar(String make, String model, int year, int batteryRange) {
		super(make, model, year);
		this.batteryRange = batteryRange;
	}

	// getter and setter
	public int getBatteryRange() {
		return batteryRange;
	}

	public void setBatteryRange(int batteryRange) {
		this.batteryRange = batteryRange;
	}

	@Override
	public void startEngine() {
		System.out.println("Silent start - " + getMake() + ", " + getModel());
	}

	// Method to charge the battery
	public void chargeBattery() {
		System.out.println(util.BATTERY_CHANGE + getMake() + " " + getModel());
	}

}
