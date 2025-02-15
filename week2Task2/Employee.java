package week2Task2;

import java.util.Scanner;

//main class
public class Employee {
	//variables
	private int empId;
	private String empName;
	private double salary;
	private int experience;

	//set the user entered employee details
	public void setEmployeeDetails(int empId, String empName, double salary, int yearsOfExperience) {
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.experience = yearsOfExperience;
	}

	//get the details from user
	public void getEmpDettails() {
		System.out.println("Employee ID: " + empId);
		System.out.println("Employee Name: " + empName);
		System.out.println("Monthly Salary: " + salary);
		System.out.println("Annual Salary: " + (salary * 12));
		System.out.println("Years of Experience: " + experience);
	}

	//check the loan eligibility
	public void getLoanEligibility() {
		double annualSal = salary * 12;
		if (experience > 5) {
			if (annualSal == 600000)
				System.out.println("The loan is granted for 2 lakhs");
			else if (annualSal >= 1000000 && annualSal < 1500000)
				System.out.println("The loan is granted for 5 lakhs");
			else if (annualSal >= 1500000)
				System.out.println("The loan is granted for 7 lakhs");
			else
				System.out.println("As your annual salary is less than 6 lakhs, the loan is not granted.");
		} else
			System.out.println("As your years of experience is less than 5 years, the loan is not granted.");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee emp = new Employee();
		System.out.println("Enter Employee ID: ");
		int empId = sc.nextInt();
		System.out.println("Enter Employee Name: ");
		String empName = sc.next();
		System.out.println("Enter Monthly Salary: ");
		double salary = sc.nextDouble();
		System.out.println("Enter Years of Experience: ");
		int experience = sc.nextInt();
		emp.setEmployeeDetails(empId, empName, salary, experience);
		emp.getEmpDettails();
		emp.getLoanEligibility();
	}

}
