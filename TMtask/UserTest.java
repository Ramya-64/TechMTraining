package TMtask;

public class UserTest {
	public static void main(String[] args) {
		// objects for user class
		User user1 = new User("Ramya", 21, "6379295188");
		User user2 = new User("Ramya", 21, "6379295188");
		// objects for seconduser class
		SecondUser suser1 = new SecondUser("Ram", 18, "6779295188");
		SecondUser suser2 = new SecondUser("Ram", 18, "6779295188");
		// overridden tostring
		System.out.println(user1);
		// default tostring
		System.out.println(suser1);
		// overridden equals comapres values
		System.out.println(user1.equals(user2));
		// default equals compares references
		System.out.println(suser1.equals(suser2));
		// overridden hashcode
		System.out.println(user1.hashCode());
		System.out.println(suser1.hashCode());

	}
}
