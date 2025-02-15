package week2Task1;

import java.util.*;

class StudentsRecord_2{
    String name;
    int[] marks;
    int total;
    double average;

    public StudentsRecord_2(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        totalAndAvg();
    }

    
    private void totalAndAvg() {
        total = 0;
        for (int mark : marks) {
            total += mark;
        }
        average = (double) total / marks.length;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<StudentsRecord_2> students = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter number of subjects: ");
            int subjects = sc.nextInt();
            int[] marks = new int[subjects];

            System.out.println("Enter marks for " + subjects + " subjects:");
            for (int j = 0; j < subjects; j++) {
                marks[j] = sc.nextInt();
            }
            sc.nextLine(); 

            students.add(new StudentsRecord_2(name, marks));
        }
       
        students.sort((s1, s2) -> s2.total - s1.total);

        System.out.println("Consolidate");
        for (StudentsRecord_2 student : students) {
            System.out.println("Name: " + student.name + ", Total Marks: " + student.total + ", Average: " + student.average);
        }
    }
}
