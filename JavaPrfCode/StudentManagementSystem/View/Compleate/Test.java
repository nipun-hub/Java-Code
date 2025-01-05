import java.util.Scanner;

class Student {
    String sid;
    String name;
    int marks1 = 0;
    int marks2 = 0;
    int marks3 = 0;

    Student() {
    }

    Student(String sid, String name) {
        this.sid = sid;
        this.name = name;
    }

    Student(String sid, String name, int marks1, int marks2, int marks3) {
        this.sid = sid;
        this.name = name;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    void addMarks(int marks1, int marks2, int marks3) {
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    void updateStudent(String sid, String name, int marks1, int marks2, int marks3) {
        this.sid = sid;
        this.name = name;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    void printStudent() {
        System.out.println("ID: " + sid);
        System.out.println("Name: " + name);
        System.out.println("Marks1: " + marks1);
        System.out.println("Marks2: " + marks2);
        System.out.println("Marks3: " + marks3);
        System.out.println();
    }
}

class Test {
    static String HEADER = "=".repeat(40);
    static Scanner scanner = new Scanner(System.in);

    //    clear terminal
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //    main form
    public static int mainForm(int... name) {
        clear();
        System.out.println(HEADER);
        System.out.printf("| %25s\n", "Welcome to sms");
        System.out.println(HEADER);
        System.out.println(" [1] Add new student");
        System.out.println(" [2] Add student marks");
        System.out.println(" [3] View student");
        System.out.println(" [4] Display student");
        System.out.println(" [5] Delete student");
        System.out.println(" [6] Exit");
        System.out.print("Input Your Input : ");
        int number = scanner.nextInt();
        return number;
    }

    // add student
    public static Student[] studentDetails(Student[] students) {
        Student[] temp = students;
        loop1:
        while (true) {
            clear();
            System.out.println(HEADER);
            System.out.printf("| %25s\n", "Add Student");
            System.out.println(HEADER);

            System.out.print("\nEnter Id : ");
            String id = scanner.next();

            System.out.print("Enter student name : ");
            scanner.nextLine();
            String name = scanner.nextLine();

            temp = addStudent(temp, id, name);

            System.out.println("\nStudent added successfully");

            System.out.print("\nYou wont to back Y/N : ");
            String response = scanner.next();
            System.out.println();
            if (response.equals("y")) break loop1;
        }
        return temp;
    }

    public static Student[] addStudent(Student[] students, String sid, String name) {
        Student[] temp = new Student[students.length + 1];

        for (int i = 0; i < students.length; i++) {
            temp[i] = students[i];
        }

        temp[temp.length - 1] = new Student(sid, name);

        return temp;
    }

    // add student marks
    public static void addStudentMarks(Student[] students) {
        loop1:
        while (true) {
            clear();
            System.out.println(HEADER);
            System.out.printf("| %25s\n", "Add Student Marks");
            System.out.println(HEADER);

            System.out.print("\nEnter Id : ");
            String id = scanner.next();

            int index = findStudentById(students, id);

            if (index != -1) {

                System.out.print("Enter student Marks 1 : ");
                scanner.nextLine();
                int marks1 = scanner.nextInt();

                System.out.print("Enter student Marks 2 : ");
                scanner.nextLine();
                int marks2 = scanner.nextInt();

                System.out.print("Enter student Markss 3 : ");
                scanner.nextLine();
                int marks3 = scanner.nextInt();

                students[index].addMarks(marks1, marks2, marks3);

                System.out.println("\nStudent marks added successfully");
            } else {
                System.out.println("This is is not valid");
            }


            System.out.print("\nYou wont to back Y/N : ");
            scanner.nextLine();
            String response = scanner.nextLine();
            System.out.println();
            if (response.equals("y")) return;
        }
    }

    // find student by is and return index , not a user return -1
    public static int findStudentById(Student[] students, String target) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].sid.equals(target)) return i;
        }
        return -1;
    }

    // print all student
    public static void printAll(Student[] students) {
        System.out.println("-".repeat(76));
        System.out.printf("| %-5s| %-30s| %-10s| %-10s| %-10s|\n", "Id", "Name", "Marks1", "Marks2", "Marks3");
        System.out.println("-".repeat(76));
        for (int i = 0; i < students.length; i++) {
            System.out.printf("| %-5s| %-30s| %-10d| %-10d| %-10d|\n", students[i].sid, students[i].name, students[i].marks1, students[i].marks2, students[i].marks3);
        }
        System.out.println("-".repeat(76));
    }

    // delete student
    public static Student[] deleteStudent(Student[] students) {
        Student[] temp = new Student[students.length - 1];

        loop1:
        while (true) {
            clear();
            System.out.println(HEADER);
            System.out.printf("| %25s\n", "Delete Student");
            System.out.println(HEADER);

            System.out.print("\nEnter Id : ");
            String id = scanner.next();

            int index = findStudentById(students, id);

            if (index != -1) {
                if (students.length < index) System.out.println("Invalid Student");

                for (int st = 0; st < temp.length; st++) {
                    if (st >= index) {
                        temp[st] = students[st + 1];
                    } else {
                        temp[st] = students[st];
                    }
                }
                System.out.println("Successfully deleted user");
            } else {
                System.out.println("Student not found!");
            }

            System.out.print("\nYou wont to back Y/N : ");
            scanner.nextLine();
            String response = scanner.nextLine();
            System.out.println();
            if (response.equals("y")) break loop1;
        }
        return temp;
    }

    // display student by id
    public static void displayStudent(Student[] students) {
        loop1:
        while (true) {
            clear();
            System.out.println(HEADER);
            System.out.printf("| %25s\n", "Display Student");
            System.out.println(HEADER);

            System.out.print("\nEnter Id : ");
            String id = scanner.next();

            int index = findStudentById(students, id);

            if (index != -1) {
                System.out.println("-".repeat(76));
                System.out.printf("| %-5s| %-30s| %-10s| %-10s| %-10s|\n", "Id", "Name", "Marks1", "Marks2", "Marks3");
                System.out.println("-".repeat(76));
                System.out.printf("| %-5s| %-30s| %-10d| %-10d| %-10d|\n", students[index].sid, students[index].name, students[index].marks1, students[index].marks2, students[index].marks3);
                System.out.println("-".repeat(76));
            } else {
                System.out.println("Student not found!");
            }

            System.out.print("\nYou wont to back Y/N : ");
            scanner.nextLine();
            String response = scanner.nextLine();
            System.out.println();
            if (response.equals("y")) break loop1;
        }
    }

    // main method
    public static void main(String[] args) {
        Student[] students = new Student[0];

        while (true) {
            clear();
            int response = mainForm();
            switch (response) {
                case 1:
                    students = studentDetails(students);
                    break;
                case 2:
                    addStudentMarks(students);
                    break;
                case 3:
                    printAll(students);
                    break;
                case 4:
                    displayStudent(students);
                    break;
                case 5:
                    students = deleteStudent(students);
                    break;
                case 6:
                    clear();
                    System.out.println("Thanks for using sms");
                    return;
                default:
                    System.out.println("Invalid Number");
            }
        }

    }

}
