package managementSystem;
import java.util.Scanner;

public class StudentManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static int[] ids = new int[100];
    static String[] names = new String[100];
    static double[] marks = new double[100];

    static int count = 0;

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n==============================");
            System.out.println(" STUDENT MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Marks");
            System.out.println("5. Delete Student");
            System.out.println("6. Average Marks");
            System.out.println("7. Highest Scorer");
            System.out.println("8. Exit");

            System.out.print("\nEnter Choice : ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateMarks();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    averageMarks();
                    break;

                case 7:
                    highestScorer();
                    break;

                case 8:
                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    // Add Student
    static void addStudent() {

        if (count == ids.length) {
            System.out.println("Database Full!");
            return;
        }

        System.out.print("Enter Student ID : ");
        ids[count] = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Student Name : ");
        names[count] = sc.nextLine();

        System.out.print("Enter Student Marks : ");
        marks[count] = sc.nextDouble();

        count++;

        System.out.println("Student Added Successfully.");
    }

    // View Students
    static void viewStudents() {

        if (count == 0) {
            System.out.println("No Student Records Found.");
            return;
        }

        System.out.println("\n----------------------------------------------");
        System.out.printf("%-10s %-20s %-10s\n", "ID", "NAME", "MARKS");
        System.out.println("----------------------------------------------");

        for (int i = 0; i < count; i++) {
            System.out.printf("%-10d %-20s %-10.2f\n",
                    ids[i], names[i], marks[i]);
        }
    }

    // Search Student
    static void searchStudent() {

        if (count == 0) {
            System.out.println("No Student Records Found.");
            return;
        }

        System.out.print("Enter Student ID : ");
        int searchId = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (ids[i] == searchId) {

                System.out.println("\nStudent Found");
                System.out.println("ID : " + ids[i]);
                System.out.println("Name : " + names[i]);
                System.out.println("Marks : " + marks[i]);
                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    // Update Marks
    static void updateMarks() {

        if (count == 0) {
            System.out.println("No Student Records Found.");
            return;
        }

        System.out.print("Enter Student ID : ");
        int searchId = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (ids[i] == searchId) {

                System.out.print("Enter New Marks : ");
                marks[i] = sc.nextDouble();

                System.out.println("Marks Updated Successfully.");
                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    // Delete Student
    static void deleteStudent() {

        if (count == 0) {
            System.out.println("No Student Records Found.");
            return;
        }

        System.out.print("Enter Student ID : ");
        int searchId = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (ids[i] == searchId) {

                for (int j = i; j < count - 1; j++) {

                    ids[j] = ids[j + 1];
                    names[j] = names[j + 1];
                    marks[j] = marks[j + 1];
                }

                count--;

                System.out.println("Student Deleted Successfully.");
                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    // Average Marks
    static void averageMarks() {

        if (count == 0) {
            System.out.println("No Student Records Found.");
            return;
        }

        double sum = 0;

        for (int i = 0; i < count; i++) {
            sum += marks[i];
        }

        double average = sum / count;

        System.out.printf("Average Marks : %.2f\n", average);
    }

    // Highest Scorer
    static void highestScorer() {

        if (count == 0) {
            System.out.println("No Student Records Found.");
            return;
        }

        int highestIndex = 0;

        for (int i = 1; i < count; i++) {

            if (marks[i] > marks[highestIndex]) {
                highestIndex = i;
            }
        }

        System.out.println("\nHighest Scorer");
        System.out.println("ID : " + ids[highestIndex]);
        System.out.println("Name : " + names[highestIndex]);
        System.out.println("Marks : " + marks[highestIndex]);
    }
}
