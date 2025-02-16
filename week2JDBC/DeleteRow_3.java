package week2JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteRow_3 {
	private static final String URL = "jdbc:mysql://localhost:3306/student"; // Database changed to 'student'
    private static final String USER = "root";
    private static final String PASSWORD = "Prawin@0105";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner scanner = new Scanner(System.in)) {
            
            System.out.print("Enter Student ID to delete: ");
            int id = scanner.nextInt();

            String query = "DELETE FROM Students WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student record deleted successfully!");
            } else {
                System.out.println("No student found with the given ID.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
