package TMtask;

public class SecondUser {
	private String name;
	private int age;
	private String phoneNumber;
	// constructor
	public SecondUser(String name,int age,String phoneNumber) {
		this.name=name;
		this.age=age;
		this.phoneNumber=phoneNumber;
	}
	// getters
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
}
