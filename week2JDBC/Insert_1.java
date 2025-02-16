package week2JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Insert_1 {
	static String URL = "jdbc:mysql://localhost:3306/student"; 
	static String USER = "root";
	static String PASSWORD = "RAMYA";

	public static void insertRows(Scanner scanner, Connection conn) throws SQLException {
		String query = "INSERT INTO Students (id, name, age, department, gpa) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(query);

		System.out.print("Enter Student ID: ");
		int id = scanner.nextInt();
		
		System.out.print("Enter Student Name: ");
		String name = scanner.next();
		
		System.out.print("Enter Age: ");
		int age = scanner.nextInt();
		
		System.out.print("Enter Department: ");
		String department = scanner.next();
		
		System.out.print("Enter GPA: ");
		double gpa = scanner.nextDouble();

		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setInt(3, age);
		pstmt.setString(4, department);
		pstmt.setDouble(5, gpa);
		pstmt.executeUpdate();

		System.out.println("Student record inserted successfully!");

		System.out.print("Do you want to insert another record? (yes/no): ");
		String choice = scanner.next();
		if (choice.equalsIgnoreCase("yes")) {
			insertRows(scanner, conn);
		}
	}

	public static void main(String[] args) {
		try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			 Scanner scanner = new Scanner(System.in)) {
			insertRows(scanner, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
