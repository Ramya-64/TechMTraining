package TMtask;

public class User {
	private String name;
	private int age;
	private String phoneNumber;

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// constructor
	public User(String name, int age, String phoneNumber) {

		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User:" + name + ", " + "Age:" + age + ", " + "Phone Number:" + phoneNumber;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		User user = (User) obj;
		return age == user.age && name.equals(user.name);
	}

	@Override
	public int hashCode() {
		return name.hashCode() + Integer.hashCode(age);
	}

}
