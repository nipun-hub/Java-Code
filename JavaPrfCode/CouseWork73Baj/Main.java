import java.util.Scanner;

class Main {
    static Scanner scanner = new Scanner(System.in);
    final static String TODAY = "2025-01-05";
    final static int overdueFine = 50;
    static boolean isLogged = false;
    final static int WIDTH = 40;
    final static String HEADER = "+" + "-".repeat(WIDTH - 2) + "+";

    // Arrays implementation
    static String[][] users = { { "hemal", "1234" } };
    // static String[][] members = new String[0][4];
    // static String[][] books = new String[0][5];
    // static String[][] issuedBooks = new String[0][3];

    static String[][] members = {
            { "M001", "jhonan", "0773344555", "nHw5o@example.com" },
            { "M002", "jhona 2", "0773344445", "nHw6o@example.com" },
            { "M003", "jhona 3", "0773344647", "nHw7o@example.com" },
            { "M004", "jhona 4", "0443355223", "nHw8o@example.com" }
    };
    static String[][] books = {
            { "B001", "The Great Gatsby", "F. Scott Fitzgerald", "Fiction", "10" },
            { "B002", "To Kill a Mockingbird", "Harper Lee", "Fiction", "5" },
            { "B003", "Pride and Prejudice", "Jane Austen", "Fiction", "2" },
            { "B004", "The Catcher in the Rye", "J.D. Salinger", "Fiction", "1" }
    };
    static String[][] issuedBooks = {
            { "B001", "M001", "2025-01-05" }, { "B001", "M002", "2025-01-01" },
            { "B001", "M003", "2024-12-25" }, { "B002", "M001", "2025-01-07" },
            { "B002", "M002", "2025-01-010" }, { "B002", "M003", "2025-01-03" },
            { "B003", "M001", "2025-02-05" }, { "B003", "M002", "2025-03-05" },
            { "B003", "M003", "2025-01-10" }, { "B004", "M001", "2024-12-10" },
            { "B004", "M003", "2024-11-29" }, { "B003", "M004", "2025-01-05" },
    };

    // page helper method

    public static void printHeader(String title) {
        clearConsole();
        System.out.printf("%n--- %s ---\n", title);
    }

    // public static void printHeader(String title) {
    // int space = ((WIDTH - title.length()) / 2) - 1;
    // clearConsole();
    // System.out.println(HEADER);
    // System.out.printf("|%" + (title.length() % 2 != 0 ? space + 1 : space) +
    // "s%s%" + space + "s|%n", "", title,
    // "");
    // System.out.println(HEADER);
    // }

    public static String centerText(String text, int totalWidth) {
        int space = (totalWidth - text.length()) / 2;
        int extra = (totalWidth - text.length()) % 2;
        return " ".repeat(space) + text + " ".repeat(space + extra);
    }

    public static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.contains("Linux")) {
                System.out.print("\033\143");
            } else if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
        } catch (final Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // Arrays Helper method

    public static String[][] addItemToArray(String[][] array, String... data) {
        String[][] temp = new String[array.length + 1][];

        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }

        temp[array.length] = data;

        return temp;
    }

    public static String[][] deleteItemFromArray(String[][] source, int index) {
        String[][] temp = new String[source.length - 1][];
        for (int i = 0; i < temp.length; i++) {
            if (i < index)
                temp[i] = source[i];
            else
                temp[i] = source[i + 1];
        }
        return temp;
    }

    public static void updateArray(String[][] source, int index, String... data) {
        source[index] = data;
    }

    public static int checkItemFromArray(String[][] source, String target) {
        for (int i = 0; i < source.length; i++) {
            if (source[i][0].equals(target))
                return i;
        }
        return -1;
    }

    public static int checkItemFromArray(String[][] source, String target, int index) {
        for (int i = 0; i < source.length; i++) {
            if (source[i][index].equals(target))
                return i;
        }
        return -1;
    }

    public static String[] giveSybArray(String[][] source, int index) {
        return source[index];
    }

    public static int checkItemCountFromArray(String[][] array, String itemId, int column) {
        int itemCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i][column].equals(itemId)) {
                itemCount++;
            }
        }
        return itemCount;
    }

    public static boolean deleteIssuedBook(String bookId, String memberId) {
        for (int i = 0; i < issuedBooks.length; i++) {
            if (issuedBooks[i][0].equals(bookId) && issuedBooks[i][1].equals(memberId)) {
                issuedBooks = deleteItemFromArray(issuedBooks, i);
                return true;
            }
        }
        return false;
    }

    // auth method
    public static void login() throws InterruptedException {
        clearConsole();
        while (true) {
            System.out.print("Enter Username : ");
            String userName = scanner.nextLine().trim().toLowerCase();

            if (userName.isEmpty()) {
                System.out.println("Invalid username.Try again.\n");
                continue;
            }

            System.out.print("Enter Password : ");
            String password = scanner.nextLine().trim();

            if (password.isEmpty()) {
                System.out.println("Invalid password.Try again.\n");
                continue;
            }

            if (userName.equals(users[0][0].toLowerCase()) && password.equals(users[0][1])) {
                isLogged = true;
                System.out.println("Successfully logged in.");
                Thread.sleep(1000);
                return;
            } else {
                System.out.println("Invalid credentials.Try again.\n");
            }
        }
    }

    public static void logout() throws InterruptedException {
        isLogged = false;
        System.out.println("\nSuccessfully logged out.\n");
        Thread.sleep(1000);
        login();
    }

    // main Form
    public static int mainForm() {
        printHeader("Library Management System");
        System.out.println("1. Manage Books");
        System.out.println("2. Manage Members");
        System.out.println("3. Issue Books");
        System.out.println("4. Return Books");
        System.out.println("5. View Reports");
        System.out.println("6. Logout");
        System.out.println("7. Exit the System");
        System.out.print("Select an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    // Manage book section

    public static void manageBookshandler() {
        while (true) {
            switch (manageBooksForm()) {
                case 1:
                    addBookForm();
                    break;
                case 2:
                    updateBookForm();
                    break;
                case 3:
                    deleteBookForm();
                    break;
                case 4:
                    searchBookForm();
                    break;
                case 5:
                    viewAllBooksForm();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static int manageBooksForm() {
        printHeader("Management Books");
        System.out.println("1. Add Book");
        System.out.println("2. Update Book");
        System.out.println("3. Delete Book");
        System.out.println("4. Search Book");
        System.out.println("5. View All Books");
        System.out.println("6. Back to Home");
        System.out.print("Select an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public static void addBookForm() {
        clearConsole();
        while (true) {
            System.out.print("\nEnter Book Id : ");
            String bookId = scanner.nextLine().trim();
            if (bookId.isEmpty()) {
                System.out.println("Invalid Book Id. Please enter a valid Book Id.");
                continue;
            }
            if (checkItemFromArray(books, bookId) != -1) {
                System.out.println("The Book Already Exists.");
                continue;
            } else {
                System.out.print("Enter title : ");
                String title = scanner.nextLine().trim();

                System.out.print("Enter Author : ");
                String author = scanner.nextLine().trim();

                System.out.print("Enter Genre : ");
                String genre = scanner.nextLine().trim();

                if (title.isEmpty() || author.isEmpty() || genre.isEmpty()) {
                    System.out.println("Please enter valid title, author, and genre.");
                    continue;
                }

                System.out.print("Enter Quantity : ");
                if (scanner.hasNextInt()) {
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    if (quantity <= 0) {
                        System.out.println("Quantity must be a positive integer.");
                        continue;
                    } else {
                        books = addItemToArray(books, bookId, title, author, genre, String.valueOf(quantity));
                        System.out.println("Book added successfully.");
                    }

                } else {
                    System.out.println("Invalid Quantity. Please enter a valid Quantity.");
                    scanner.nextLine();
                    continue;
                }
            }
            System.out.print("\nYou want to add another book?\n(Y for yes, Any key for no) : ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("y"))
                return;
        }
    }

    public static void updateBookForm() {
        clearConsole();
        while (true) {
            System.out.print("\nEnter Book Id to Update : ");
            String bookId = scanner.nextLine().trim();

            if (bookId.isEmpty()) {
                System.out.println("Invalid Book Id. Please enter a valid Book Id.");
                continue;
            }
            int index = checkItemFromArray(books, bookId);
            if (index == -1) {
                System.out.println("Can't find the book. Enter a another book Id.");
                continue;
            } else {
                String[] bookDetails = giveSybArray(books, index);
                System.out.println("\nCurrent Book Details :- ");
                System.out.printf("%-10s : %s%n", "Book Id", bookDetails[0]);
                System.out.printf("%-10s : %s%n", "Title", bookDetails[1]);
                System.out.printf("%-10s : %s%n", "Author", bookDetails[2]);
                System.out.printf("%-10s : %s%n", "Genre", bookDetails[3]);
                System.out.printf("%-10s : %s%n", "Quantity", bookDetails[4]);

                System.out.println("\nEnter Updated Book Details\n");

                System.out.print("Enter title : ");
                String title = scanner.nextLine().trim();

                System.out.print("Enter Author : ");
                String author = scanner.nextLine().trim();

                System.out.print("Enter Genre : ");
                String genre = scanner.nextLine().trim();

                if (title.isEmpty() || author.isEmpty() || genre.isEmpty()) {
                    System.out.println("Please enter valid title, author, and genre.");
                    continue;
                }

                System.out.print("Enter Quantity : ");
                if (scanner.hasNextInt()) {
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    if (quantity <= 0) {
                        System.out.println("Quantity must be a positive integer.");
                        continue;
                    } else {
                        updateArray(books, index, bookId, title, author, genre, String.valueOf(quantity));
                        System.out.println("Book updated successfully.");
                    }
                } else {
                    System.out.println("Invalid Quantity. Please enter a valid Quantity.");
                    scanner.nextLine();
                    continue;
                }
            }

            System.out.print("\nYou want to update another book?\n(Y for yes, Any key for no) : ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("y"))
                return;

        }
    }

    public static void deleteBookForm() {
        clearConsole();
        while (true) {
            System.out.print("\nEnter Book Id to Delete : ");
            String bookId = scanner.nextLine().trim();

            if (bookId.isEmpty()) {
                System.out.println("Invalid Book Id. Please enter a valid Book Id.");
                continue;
            }

            int index = checkItemFromArray(books, bookId);
            if (index == -1) {
                System.out.println("Can't find the book. Enter a another book Id.");
                continue;
            } else {
                books = deleteItemFromArray(books, index);
                System.out.println("Book deleted successfully.");
            }
            System.out.print("\nYou want to delete another book?\n(Y for yes, Any key for no) : ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("y"))
                return;
        }
    }

    public static void searchBookForm() {
        clearConsole();
        while (true) {
            System.out.print("\nEnter Book Id to Search : ");
            String bookId = scanner.nextLine().trim();

            if (bookId.isEmpty()) {
                System.out.println("Invalid Book Id. Please enter a valid Book Id.");
                continue;
            }

            int index = checkItemFromArray(books, bookId);
            if (index == -1) {
                System.out.println("Can't find the book. Enter a another book Id.");
                continue;
            } else {
                String[] bookDetails = giveSybArray(books, index);
                System.out.println("\nBook Details : ");
                System.out.println("Book Id : " + bookDetails[0]);
                System.out.println("Title : " + bookDetails[1]);
                System.out.println("Author : " + bookDetails[2]);
                System.out.println("Genre : " + bookDetails[3]);
                System.out.println("Quantity : " + bookDetails[4]);
            }
            System.out.print("\nYou want to search another book?\n(Y for yes, Any key for no) : ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("y"))
                return;
        }
    }

    public static void viewAllBooksForm() {
        clearConsole();
        int widthForTable = 150;
        String headerForTable = "+" + "-".repeat(widthForTable - 2) + "+";
        if (books.length == 0)
            System.out.println("No books available.");
        else {
            printHeader("View All Books details");
            System.out.println(headerForTable);
            System.out.printf("|%s|%s|%s|%s|%s|%n",
                    centerText("Book Id", (widthForTable / 5) - 2),
                    centerText("Book Name", (widthForTable / 5) - 1),
                    centerText("Book Author", (widthForTable / 5) - 1),
                    centerText("Book Genre", (widthForTable / 5) - 1),
                    centerText("Book Quantity", (widthForTable / 5) - 1));
            System.out.println(headerForTable);

            for (int i = 0; i < books.length; i++) {
                System.out.printf("|%s|%s|%s|%s|%s|%n",
                        centerText(books[i][0], (widthForTable / 5) - 2),
                        centerText(books[i][1], (widthForTable / 5) - 1),
                        centerText(books[i][2], (widthForTable / 5) - 1),
                        centerText(books[i][3], (widthForTable / 5) - 1),
                        centerText(books[i][4], (widthForTable / 5) - 1));
            }
            System.out.println(headerForTable);

        }

        System.out.print("press any key to continue : ");
        scanner.nextLine();
    }

    // Manage Members Section

    public static void handelManageMembers() {
        while (true) {
            switch (manageMembersForm()) {
                case 1:
                    addMemberForm();
                    break;
                case 2:
                    updateMemberForm();
                    break;
                case 3:
                    deleteMemberForm();
                    break;
                case 4:
                    searchMemberForm();
                    break;
                case 5:
                    viewAllMembersForm();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid option. Please select a valid option.");
                    break;
            }
        }
    }

    public static int manageMembersForm() {
        printHeader("Manage Members");
        System.out.println("1. Add Member");
        System.out.println("2. Update Member");
        System.out.println("3. Delete Member");
        System.out.println("4. Search Member");
        System.out.println("5. View All Members");
        System.out.println("6. Back to Home");
        System.out.print("Select an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public static void addMemberForm() {
        clearConsole();
        while (true) {
            System.out.print("\nEnter Member Id : ");
            String memberId = scanner.nextLine().trim();

            if (memberId.isEmpty()) {
                System.out.println("Invalid Member Id. Please enter a valid Member Id.");
                continue;
            }

            if (checkItemFromArray(members, memberId) != -1) {
                System.out.println("Member Id already exists. Enter a another Member Id.");
                continue;
            } else {
                System.out.print("Enter Member Name : ");
                String memberName = scanner.nextLine().trim();
                System.out.print("Enter Member Mobile : ");
                String memberMobile = scanner.nextLine().trim();
                System.out.print("Enter Member Email : ");
                String memberEmail = scanner.nextLine().trim();

                if (memberName.isEmpty() || memberMobile.isEmpty() || memberEmail.isEmpty()) {
                    System.out.println("Please enter valid name, mobile, and email.");
                    continue;
                }

                if (memberMobile.length() != 10) {
                    System.out.println("Invalid mobile number. Please enter a valid mobile number.");
                    continue;
                } else if (!(memberEmail.contains("@") && memberEmail.contains("."))) {
                    System.out.println("Invalid email. Please enter a valid email.");
                    continue;
                } else {
                    members = addItemToArray(members, memberId, memberName, memberMobile, memberEmail);
                    System.out.println("Member added successfully.");
                }

            }
            System.out.print("\nYou want to add another member?\n(Y for yes, Any key for no) : ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("y"))
                return;
        }
    }

    public static void updateMemberForm() {
        clearConsole();
        while (true) {
            System.out.print("\nEnter Member Id to Update : ");
            String memberId = scanner.nextLine().trim();

            if (memberId.isEmpty()) {
                System.out.println("Invalid Member Id. Please enter a valid Member Id.");
                continue;
            }

            int index = checkItemFromArray(members, memberId);
            if (index == -1) {
                System.out.println("Can't find the member. Enter a another member Id.");
                continue;
            } else {
                String[] memberDetails = giveSybArray(members, index);
                System.out.println("\nCurrent Member Details :- ");
                System.out.printf("%-15s: %s%n" ,"Member Id", memberDetails[0]);
                System.out.printf("%-15s: %s%n" ,"Member Name", memberDetails[1]);
                System.out.printf("%-15s: %s%n" ,"Member Mobile", memberDetails[2]);
                System.out.printf("%-15s: %s%n" ,"Member Email", memberDetails[3]);
                System.out.println("\nEnter Updated Member Details : \n");

                System.out.print("Enter Member Name : ");
                String memberName = scanner.nextLine().trim();
                System.out.print("Enter Member Mobile : ");
                String memberMobile = scanner.nextLine().trim();
                System.out.print("Enter Member Email : ");
                String memberEmail = scanner.nextLine().trim();

                if (memberName.isEmpty() || memberMobile.isEmpty() || memberEmail.isEmpty()) {
                    System.out.println("Please enter valid name, mobile, and email.");
                    continue;
                }

                if (memberMobile.length() != 10) {
                    System.out.println("Invalid mobile number. Please enter a valid mobile number.");
                    continue;
                } else if (!(memberEmail.contains("@") && memberEmail.contains("."))) {
                    System.out.println("Invalid email. Please enter a valid email.");
                    continue;
                } else {
                    updateArray(members, index, memberId, memberName, memberMobile, memberEmail);
                    System.out.println("Member updated successfully.");
                }
            }
            System.out.print("\nYou want to update another member?\n(Y for yes, Any key for no) : ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("y"))
                return;
        }
    }

    public static void deleteMemberForm() {
        clearConsole();
        while (true) {
            System.out.print("\nEnter Member Id to Delete : ");
            String memberId = scanner.nextLine().trim();

            if (memberId.isEmpty()) {
                System.out.println("Invalid Member Id. Please enter a valid Member Id.");
                continue;
            }

            int index = checkItemFromArray(members, memberId);
            if (index == -1) {
                System.out.println("Can't find the member. Enter a another member Id.");
                continue;
            } else {
                members = deleteItemFromArray(members, index);
                System.out.println("Member deleted successfully.");
            }
            System.out.print("\nYou want to delete another member?\n(Y for yes, Any key for no) : ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("y"))
                return;
        }
    }

    public static void searchMemberForm() {
        clearConsole();
        while (true) {
            System.out.print("\nEnter Member Id to Search : ");
            String memberId = scanner.nextLine().trim();

            if (memberId.isEmpty()) {
                System.out.println("Invalid Member Id. Please enter a valid Member Id.");
                continue;
            }

            int index = checkItemFromArray(members, memberId);

            if (index == -1) {
                System.out.println("Can't find the member. Enter a another member Id.");
                continue;
            } else {
                String[] memberDetails = giveSybArray(members, index);
                printHeader("Member Details");
                System.out.println("ID : " + memberDetails[0]);
                System.out.println("Name : " + memberDetails[1]);
                System.out.println("Mobile : " + memberDetails[2]);
                System.out.println("Email : " + memberDetails[3]);
            }
            System.out.print("\nyou want to search another member?\n(Y for yes, Any key for no) : ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("y"))
                return;
        }
    }

    public static void viewAllMembersForm() {
        clearConsole();
        int widthForTable = 100;
        String headerForTable = "+" + "-".repeat(widthForTable - 2) + "+";
        if (members.length == 0)
            System.out.println("No members available.");
        else {

            System.out.println(headerForTable);
            System.out.printf("|%s|%s|%s|%s|%n",
                    centerText("Member Id", (widthForTable / 4) - 2),
                    centerText("Member Name", (widthForTable / 4) - 1),
                    centerText("Member Mobile", (widthForTable / 4) - 1),
                    centerText("Member Email", (widthForTable / 4) - 1));
            System.out.println(headerForTable);

            for (int i = 0; i < members.length; i++) {
                System.out.printf("|%s|%s|%s|%s|%n",
                        centerText(members[i][0], (widthForTable / 4) - 2),
                        centerText(members[i][1], (widthForTable / 4) - 1),
                        centerText(members[i][2], (widthForTable / 4) - 1),
                        centerText(members[i][3], (widthForTable / 4) - 1));
            }
            System.out.println(headerForTable);
        }
        System.out.print("press any key to continue : ");
        scanner.nextLine();
        return;
    }

    // Issue Book section

    public static void issueBookForm() {
        clearConsole();
        while (true) {
            System.out.print("\nEnter Book Id : ");
            String bookId = scanner.nextLine().trim();

            if (bookId.isEmpty()) {
                System.out.println("Invalid Book Id. Please enter a valid Book Id.");
                continue;
            }

            int bookIndex = checkItemFromArray(books, bookId);
            if (bookIndex == -1) {
                System.out.println("Can't find the book. Enter a another book Id.");
                continue;
            } else {
                String[] bookDetails = giveSybArray(books, bookIndex);
                if (Integer.parseInt(bookDetails[4]) <= 0) {
                    System.out.println("The Book is not available.");
                    continue;
                } else {
                    System.out.print("Enter Member Id : ");
                    String memberId = scanner.nextLine().trim();

                    if (memberId.isEmpty()) {
                        System.out.println("Invalid Member Id. Please enter a valid Member Id.");
                        continue;
                    }

                    if (checkItemFromArray(members, memberId) == -1) {
                        System.out.println("Can't find the member. Enter a another member Id.");
                        continue;
                    } else {
                        System.out.print("Enter Due Date (YYYY-MM-DD) : ");
                        String dueDate = scanner.nextLine().trim();
                        if (!dueDate.contains("-")) {
                            System.out.println("Invalid date. Please enter a valid date.");
                            continue;
                        } else {
                            String newBookQty = String.valueOf(Integer.parseInt(bookDetails[4]) - 1);
                            updateArray(books, bookIndex, bookDetails[0], bookDetails[1], bookDetails[2],
                                    bookDetails[3], newBookQty);
                            issuedBooks = addItemToArray(issuedBooks, bookId, memberId, dueDate);
                            System.out.println("Book issued successfully.");
                        }
                    }
                }
            }
            System.out.print("\nYou want to issue another book?\n(Y for yes, Any key for no) : ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("y"))
                return;
        }
    }

    // return book section

    public static int calculateOverdue(String dueDate) {
        int[] daysOfMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int[] daysCumulative = { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };

        int[] today = { Integer.parseInt(TODAY.split("-")[0]), Integer.parseInt(TODAY.split("-")[1]),
                Integer.parseInt(TODAY.split("-")[2]) };
        int[] due = { Integer.parseInt(dueDate.split("-")[0]), Integer.parseInt(dueDate.split("-")[1]),
                Integer.parseInt(dueDate.split("-")[2]) };

        daysOfMonth[1] = (today[0] % 4 == 0 && today[0] % 100 != 0 || today[0] % 400 == 0) ? 29 : 28;
        daysCumulative[2] = daysCumulative[1] + daysOfMonth[1];

        int totalDaysToday = today[0] * 365 + daysCumulative[today[1] - 1] + today[2];
        totalDaysToday += today[0] / 4 - today[0] / 100 + today[0] / 400;

        daysOfMonth[1] = (due[0] % 4 == 0 && due[0] % 100 != 0 || due[0] % 400 == 0) ? 29 : 28;
        daysCumulative[2] = daysCumulative[1] + daysOfMonth[1];

        int totalDaysDue = due[0] * 365 + daysCumulative[due[1] - 1] + due[2];
        totalDaysDue += due[0] / 4 - due[0] / 100 + due[0] / 400;

        int duration = totalDaysToday - totalDaysDue;
        return duration;

    }

    public static void returnBookForm() {
        clearConsole();
        while (true) {
            System.out.print("\nEnter Book Id : ");
            String bookId = scanner.nextLine().trim();

            if (bookId.isEmpty()) {
                System.out.println("Invalid Book Id. Please enter a valid Book Id.");
                continue;
            }
            int bookIndex = checkItemFromArray(books, bookId);
            if (bookIndex == -1) {
                System.out.println("Can't find the book. Enter a another book Id.");
                continue;
            } else {
                System.out.print("Enter Member Id : ");
                String memberId = scanner.nextLine().trim();

                if (memberId.isEmpty()) {
                    System.out.println("Invalid Member Id. Please enter a valid Member Id.");
                    continue;
                }

                if (checkItemFromArray(members, memberId) == -1) {
                    System.out.println("Can't find the member. Enter a another member Id.");
                    continue;
                } else {
                    if (checkItemFromArray(issuedBooks, bookId, 0) == -1
                            || checkItemFromArray(issuedBooks, memberId, 1) == -1) {
                        System.out.println("This Book not issued to this member.");
                        continue;
                    } else {
                        int duration = calculateOverdue(issuedBooks[checkItemFromArray(issuedBooks, memberId, 1)][2]);
                        int fine = duration * overdueFine;

                        if (deleteIssuedBook(bookId, memberId)) {

                            String[] bookDetails = books[bookIndex];
                            String newBookQty = String.valueOf(Integer.parseInt(bookDetails[4]) + 1);
                            updateArray(books, bookIndex, bookDetails[0], bookDetails[1], bookDetails[2],
                                    bookDetails[3], newBookQty);

                            System.out.println("Book returned successfully.");
                            if (duration > 0) {
                                System.out.println(
                                        "You have a fine of Rs. " + fine + " for being late by " + duration + " days.");
                            }
                        } else {
                            System.out.println("Something went wrong. Please try again.");
                        }
                    }
                }
            }
            System.out.print("\nYou want to return another book?\n(Y for yes, Any key for no) : ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("y"))
                return;
        }
    }

    // view report section

    public static void HandleViewReport() {
        while (true) {
            switch (viewReportForm()) {
                case 1:
                    viewReportOverdueBooks();
                    break;
                case 2:
                    viewReportBooksIssuedPerMember();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
            }
        }
    }

    public static int viewReportForm() {
        printHeader("View Reports");
        System.out.println("1. Overdue Books");
        System.out.println("2. Books Issued Per Member");
        System.out.println("3. go back to main menu");
        System.out.print("\nEnter your choice : ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public static void viewReportOverdueBooks() {
        printHeader("Overdue Books");
        int widthForTable = 100;
        String headerForTable = "+" + "-".repeat(widthForTable - 2) + "+";
        if (issuedBooks.length == 0) {
            System.out.println("There is no overdue book.");
            return;
        } else {
            System.out.println(headerForTable);
            System.out.printf("|%s|%s|%s|%s|%s|%n",
                    centerText("Book Id", (widthForTable / 5) - 2),
                    centerText("Member Id", (widthForTable / 5) - 1),
                    centerText("Due Date", (widthForTable / 5) - 1),
                    centerText("Days Overdue", (widthForTable / 5) - 1),
                    centerText("fine", (widthForTable / 5) - 1));
            System.out.println(headerForTable);

            for (int i = 0; i < issuedBooks.length; i++) {
                int daysOverdue = calculateOverdue(issuedBooks[i][2]);
                if (daysOverdue > 0) {
                    System.out.printf("|%s|%s|%s|%s|%s|%n",
                            centerText(issuedBooks[i][0], (widthForTable / 5) - 2),
                            centerText(issuedBooks[i][1], (widthForTable / 5) - 1),
                            centerText(issuedBooks[i][2], (widthForTable / 5) - 1),
                            centerText(String.valueOf(daysOverdue) + " days", (widthForTable / 5) - 1),
                            centerText("Rs. " + String.valueOf(daysOverdue * overdueFine), (widthForTable / 5) - 1));
                }
            }

            System.out.println(headerForTable);
        }
        System.out.print("press any key to continue : ");
        scanner.nextLine();
        return;
    }

    public static void viewReportBooksIssuedPerMember() {
        printHeader("Books Issued Per Member");
        int widthForTable = 50;
        String headerForTable = "+" + "-".repeat(widthForTable - 2) + "+";
        if (issuedBooks.length == 0) {
            System.out.println("There is no book issued per member.");
            return;
        } else {
            System.out.println(headerForTable);
            System.out.printf("|%s|%s|%n",
                    centerText("Member Id", (widthForTable / 2) - 2),
                    centerText("Total Books issued", (widthForTable / 2) - 1));
            System.out.println(headerForTable);

            for (int i = 0; i < members.length; i++) {
                int bookCount = checkItemCountFromArray(issuedBooks, members[i][0], 1);
                if (bookCount > 0) {
                    System.out.printf("|%s|%s|%n",
                            centerText(members[i][0], (widthForTable / 2) - 2),
                            centerText(String.valueOf(bookCount), (widthForTable / 2) - 1));
                }
            }
            System.out.println(headerForTable);
        }
        System.out.print("press any key to continue : ");
        scanner.nextLine();
        return;
    }

    public static void main(String[] args) throws InterruptedException {
        if (!isLogged)
            login();

        while (isLogged) {
            switch (mainForm()) {
                case 1:
                    manageBookshandler();
                    break;
                case 2:
                    handelManageMembers();
                    break;
                case 3:
                    issueBookForm();
                    break;
                case 4:
                    returnBookForm();
                    break;
                case 5:
                    HandleViewReport();
                    break;
                case 6:
                    logout();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. please try again.");
                    break;
            }
        }
    }
}
