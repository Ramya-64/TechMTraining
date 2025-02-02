package TMtask;

public class HolidayOrNot {
	public static void main(String[] args) {
		DaysOfWeek today = DaysOfWeek.MONDAY;
		// switch case for checking various days
		switch (today) {
		case SATURDAY:
			System.out.println(today + util.WEEK_END);
			break;

		case SUNDAY:
			System.out.println(today + util.WEEK_END);
			break;

		default:
			System.out.println(today + util.WEEK_DAYS);
		}
	}

}
