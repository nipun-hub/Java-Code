import java.util.Arrays;
import java.util.Scanner;

class Example {
    static String HEADER = "=".repeat(40);
    static Scanner scanner = new Scanner(System.in);

    //    clear terminal
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public static int mainForm(int ...name) {
        clear();
        System.out.println(HEADER);
        System.out.printf("| %25s\n", "Welcome to sms");
        System.out.println(HEADER);
        System.out.println(" [1] Add new student");
        System.out.println(" [2] Add student marks");
        System.out.println(" [3] View student");
        System.out.println(" [4] Exit");
        System.out.print("Input Your Input : ");
        int number = scanner.nextInt();
        return number;
    }

    public static void studentDetails() {
        loop1:
        while (true) {
            clear();
            System.out.println(HEADER);
            System.out.printf("| %25s\n", "Add Student");
            System.out.println(HEADER);

            System.out.print("\nEnter Id : ");
            int id = scanner.nextInt();

            System.out.print("Enter student name : ");
            scanner.nextLine();
            String name = scanner.nextLine();

            System.out.print("Enter student address : ");
            String address = scanner.nextLine();

            System.out.print("Enter student baj : ");
            int baj = scanner.nextInt();

            System.out.println("\nStudent added successfully");

            System.out.print("\nYou wont to back Y/N : ");
            scanner.nextLine();
            String response = scanner.nextLine();
            System.out.println();
            if (response.equals("y")) return;
        }
    }

    public static void addStudentMarks() {
        loop1:
        while (true) {
            clear();
            System.out.println(HEADER);
            System.out.printf("| %25s\n", "Add Student Marks");
            System.out.println(HEADER);

            System.out.print("\nEnter Id : ");
            int id = scanner.nextInt();

            System.out.print("Enter student Marks : ");
            scanner.nextLine();
            int marks = scanner.nextInt();

            System.out.println("\nStudent marks added successfully");

            System.out.print("\nYou wont to back Y/N : ");
            scanner.nextLine();
            String response = scanner.nextLine();
            System.out.println();
            if (response.equals("y")) return;
        }
    }

    public static void viewStudent() {
        loop1:
        while (true) {
            clear();
            System.out.println(HEADER);
            System.out.printf("| %25s\n", "View Student");
            System.out.println(HEADER);

            System.out.println("-".repeat(65));
            System.out.printf("|%-10s|%-10s|%-20s|%-20s|\n", "baj", "Id", "name", "Address");
            System.out.println("-".repeat(65));
            System.out.printf("|%-10d|%-10d|%-20s|%-20s|\n", 001, 73, "hemal", "kegalle");
            System.out.printf("|%-10d|%-10d|%-20s|%-20s|\n", 001, 73, "hemal", "kegalle");
            System.out.printf("|%-10d|%-10d|%-20s|%-20s|\n", 001, 73, "hemal", "kegalle");
            System.out.printf("|%-10d|%-10d|%-20s|%-20s|\n", 001, 73, "hemal", "kegalle");
            System.out.printf("|%-10d|%-10d|%-20s|%-20s|\n", 001, 73, "hemal", "kegalle");
            System.out.printf("|%-10d|%-10d|%-20s|%-20s|\n", 001, 73, "hemal", "kegalle");
            System.out.printf("|%-10d|%-10d|%-20s|%-20s|\n", 001, 73, "hemal", "kegalle");
            System.out.printf("|%-10d|%-10d|%-20s|%-20s|\n", 001, 73, "hemal", "kegalle");
            System.out.println("-".repeat(65));


            System.out.print("\nYou wont to back Y/N : ");
            scanner.nextLine();
            String response = scanner.nextLine();
            System.out.println();
            if (response.equals("y")) return;
        }
    }

    public static void main(String[] args) {
        while (true) {
            clear();
            int response = mainForm();
            switch (response) {
                case 1:
                    studentDetails();
                    break;
                case 2:
                    addStudentMarks();
                    break;
                case 3:
                    viewStudent();
                    break;
                case 4:
                clear();
                    return;
                default:
                    System.out.println("Invalid Number");
            }
        }
    }
}
