package week2JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateRow_2 {
	static String URL = "jdbc:mysql://localhost:3306/student"; // Database changed to 'student'
	static String USER = "root";
	static String PASSWORD = "RAMYA";

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Scanner sc = new Scanner(System.in);

			System.out.print("Enter Student ID to update: ");
			int id = sc.nextInt();

			System.out.print("Enter new Age: ");
			int age = sc.nextInt();

			System.out.print("Enter new GPA: ");
			double gpa = sc.nextDouble();

			String query = "UPDATE Students SET age = ?, gpa = ? WHERE id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, age);
			pstmt.setDouble(2, gpa);
			pstmt.setInt(3, id);

			int rowsUpdated = pstmt.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("Student record updated successfully!");
			} else {
				System.out.println("No student found with the given ID.");
			}

			sc.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
