import java.util.Arrays;
import java.util.Scanner;

public class CourseWork {
    final static Scanner scanner = new Scanner(System.in);
    final static int width = 70;
    final static String HEADER = "+" + "-".repeat(width - 2) + "+";
    static boolean isLogin = false;

    // login credential
    static String userName = "Hemal";
    static String password = "1234";

    // Arrays
//    static String[][] supplier = new String[0][2];
//    static String[] categories = new String[0];
    //    static String[][] items = new String[0][6];
    static String[][] supplier = {{"1", "ABC Traders"}, {"2", "Global Supplies"}, {"3", "Prime Distributors"}, {"4", "Elite Wholesalers"}, {"5", "Speedy Logistics"}, {"6", "Quality Goods Co."}, {"7", "Green Valley Ltd."}, {"8", "Urban Supplies Inc."}, {"9", "Top Notch Supplies"}, {"10", "Reliable Partners"}};

    static String[] categories = {"Electronics", "Furniture", "Clothing", "Food & Beverages", "Stationery", "Toys", "Sports Equipment", "Beauty Products", "Automotive", "Books"};

    static String[][] items = {{"1", "1001", "3", "secroerghoe", "23334", "34423"}, {"2", "1002", "1", "hfkslqwdie", "45322", "12345"}, {"1", "1003", "2", "poiuytreza", "67890", "98765"}, {"4", "1004", "4", "qwertylops", "11223", "44556"}, {"5", "1005", "5", "asdfghjklz", "66789", "99887"}, {"6", "1006", "3", "zxcvbnmqwe", "33445", "55667"}, {"1", "1007", "2", "lkjhgfdsap", "55678", "77889"}, {"8", "1008", "1", "mnbvcxzpoi", "44556", "12398"}, {"9", "1009", "4", "qazwsxedcr", "55667", "66554"}, {"10", "1010", "5", "plmoknijbq", "99876", "11234"}};

    // array functions
    public static String[][] addItemFromArray(String[][] array, String... data) {
        String[][] temp = new String[array.length + 1][];

        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }

        temp[array.length] = data;

        return temp;
    }

    public static String[] addItemFromArray(String[] array, String data) {
        String[] temp = new String[array.length + 1];

        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }

        temp[array.length] = data;
        return temp;
    }

    public static String[][] deleteItemFromArray(String[][] source, int index) {
        String[][] temp = new String[source.length - 1][];
        for (int i = 0; i < temp.length; i++) {
            if (i < index) temp[i] = source[i];
            else temp[i] = source[i + 1];
        }
        return temp;
    }

    public static String[] deleteItemFromArray(String[] source, int index) {
        String[] temp = new String[source.length - 1];
        for (int i = 0; i < temp.length; i++) {
            if (i < index) temp[i] = source[i];
            else temp[i] = source[i + 1];
        }
        return temp;
    }

    public static void updateArray(String[][] source, int index, String... data) {
        source[index] = data;
    }

    public static void updateArray(String[] source, int index, String data) {
        source[index] = data;
    }

    public static int checkItemFromArray(String[][] source, String target) {
        for (int i = 0; i < source.length; i++) {
            if (source[i][0].equals(target)) return i;
        }
        return -1;
    }

    public static int checkItemFromArray(String[][] source, String target, int index) {
        for (int i = 0; i < source.length; i++) {
            if (source[i][index].equals(target)) return i;
        }
        return -1;
    }

    public static int checkItemFromArray(String[] source, String target) {
        for (int i = 0; i < source.length; i++) {
            if (source[i].equals(target)) return i;
        }
        return -1;
    }

    //    clear terminal
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int getIntInput() {
        while (true) {
            System.out.print("\n\nEnter an option to continue > ");
            if (scanner.hasNextInt()) {
                int option = scanner.nextInt();
                scanner.nextLine();
                return option;
            } else {
                System.out.print("Invalid input! Please enter a valid option: ");
                scanner.next();
            }
        }
    }

    public static String getIntInput(String text1, String error) {
        while (true) {
            System.out.print(text1);
            if (scanner.hasNextInt()) {
                int option = scanner.nextInt();
                scanner.nextLine();
                return Integer.toString(option);
            } else {
                System.out.println(error);
                scanner.next();
            }
        }
    }

    public static void printHeader(String text) {
        System.out.println(HEADER);
        int space = (width - text.length() - 2) / 2;
        System.out.printf("|%" + space + "s%s%" + space + "s|%n", "", text, "");
        System.out.println(HEADER);
    }

    public static String centerText(String text, int totalWidth) {
        int space = (totalWidth - text.length()) / 2;
        int extra = (totalWidth - text.length()) % 2; // Handles odd widths for symmetry
        return " ".repeat(space) + text + " ".repeat(space + extra);
    }

    // pages

    // auth
    public static void login() throws InterruptedException {
        printHeader("Login Page");
        while (true) {
            System.out.printf("%n%-12s: ", "User Name");
            String name = scanner.nextLine();
            if (!name.equals(userName)) {
                System.out.println("User name is invalid. please try again!");
                continue;
            }
            break;
        }
        while (true) {
            System.out.printf("%n%-12s: ", "Password");
            String pass = scanner.next();
            if (!pass.equals(password)) {
                System.out.println("Password is incorrect. please try again!");
                continue;
            }
            break;
        }

        System.out.println("\nLogin Successful!");
        isLogin = true;
        Thread.sleep(2000);
    }

    public static void credentialsForm() {
        printHeader("Credentials Management");
        while (true) {
            System.out.print("\nPlease enter the user name to verify it's you : ");
            String name = scanner.nextLine();
            if (!name.equals(userName)) {
                System.out.println("invalid user name. try again!");
                continue;
            }
            break;
        }
        while (true) {
            System.out.print("\nEnter your correct password : ");
            String name = scanner.nextLine();
            if (!name.equals(password)) {
                System.out.println("incorrect password. try again!");
                continue;
            }
            System.out.print("Enter your new password : ");
            password = scanner.nextLine();

            System.out.print("\nPassword changed successfully! Do you want go home page (press any key) : ");
            scanner.nextLine();
            return;
        }
    }

    //welcome
    public static int welcomeForm() {
        printHeader("Welcome To IJSE Stock Management System ");
        System.out.printf("%-" + (width / 2) + "s%-" + (width / 2) + "s%n", "[1] Change the Credentials", "[2] Supplier Manage");
        System.out.printf("%-" + (width / 2) + "s%-" + (width / 2) + "s%n", "[3] Stock Manage", "[4] Log Out");
        System.out.printf("%-" + (width / 2) + "s", "[5] Exit the system");
        return getIntInput();
    }

    // supplier management section
    public static int supplierManageForm() {
        printHeader("SUPPLIER MANAGEMENT ");
        System.out.printf("%n%-" + (width / 2) + "s%-" + (width / 2) + "s%n", "[1] Add Supplier", "[2] Update Supplier");
        System.out.printf("%-" + (width / 2) + "s%-" + (width / 2) + "s%n", "[3] Delete Supplier", "[4] View Supplier");
        System.out.printf("%-" + (width / 2) + "s%-" + (width / 2) + "s", "[5] Search Supplier", "[6] Home Page");
        return getIntInput();
    }

    public static void handelSupplier() {
        while (true) {
            switch (supplierManageForm()) {
                case 1:
                    addSupplier();
                    break;
                case 2:
                    updateSupplier();
                    break;
                case 3:
                    deleteSupplier();
                    break;
                case 4:
                    viewSuppliers();
                    break;
                case 5:
                    searchSupplier();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("invalid input. try again!");
            }
        }
    }

    public static void addSupplier() {
        printHeader("Add Supplier  ");
        while (true) {
            System.out.printf("%n%-15s : ", "Supplier ID");
            String supplierId = scanner.nextLine();
            // check already exists
            if (checkItemFromArray(supplier, supplierId) != -1) {
                System.out.println("already exists. try another supplier id!");
                continue;
            }

            System.out.printf("%-15s : ", "Supplier Name");
            String supplierName = scanner.nextLine();

            supplier = addItemFromArray(supplier, supplierId, supplierName);

            System.out.print("added successfully! Do you want to add another supplier (Y/N) : ");
            String choose = scanner.nextLine().toLowerCase();
            if (choose.equals("n")) break;
        }
    }

    public static void updateSupplier() {
        printHeader("Update Supplier ");
        while (true) {
            System.out.printf("%n%-15s : ", "Supplier ID");
            String supplierId = scanner.nextLine();
            // check already exists
            int findSuppler = checkItemFromArray(supplier, supplierId);
            if (findSuppler == -1) {
                System.out.println("can't find supplier id. try again!");
                continue;
            }

            System.out.printf("%-15s : ", "Supplier Name");
            String supplierName = scanner.nextLine();
            // check supplier name is correct ?
            if (checkItemFromArray(supplier, supplierName, 1) != -1) {
                System.out.println("invalid supplier name. try again!");
                continue;
            }

            updateArray(supplier, findSuppler, supplierId, supplierName);

            System.out.print("update successfully! Do you want to update another supplier (Y/N) : ");
            String choose = scanner.nextLine().toLowerCase();
            if (choose.equals("n")) break;
        }
    }

    public static void deleteSupplier() {
        printHeader("Delete Supplier ");
        while (true) {
            System.out.printf("%n%-15s : ", "Supplier ID");
            String supplierId = scanner.nextLine();
            // find supplier
            int findSupplier = checkItemFromArray(supplier, supplierId);
            if (findSupplier == -1) {
                System.out.println("can't find supplier id. try again!");
                continue;
            }

            supplier = deleteItemFromArray(supplier, findSupplier);

            System.out.print("deleted successfully! Do you want to delete another supplier (Y/N) : ");
            String choose = scanner.nextLine().toLowerCase();
            if (choose.equals("n")) break;
        }
    }

    public static void viewSuppliers() {
        printHeader("View Supplier ");

        System.out.println(HEADER);
        System.out.printf("|%s|%s|%n", centerText("SUPPLIER ID", (width / 2) - 2), centerText(" SUPPLIER NAME", (width / 2) - 1));
        System.out.println(HEADER);

        for (String[] supplier : supplier) {
            System.out.printf("|%s|%s|%n", centerText(supplier[0], (width / 2) - 2), centerText(supplier[1], (width / 2) - 1));
        }
        if (supplier.length == 0) {
            System.out.printf("|%s|%n", centerText("Supplier not found!", (width - 2)));
        }
        System.out.println(HEADER);

        System.out.print("Do you want to go supplier manage page(Y/N)? ");
        String choose = scanner.nextLine().toLowerCase();
        if (choose.equals("y")) return;
    }

    public static void searchSupplier() {
        printHeader("Search Supplier ");

        while (true) {
            System.out.printf("%n%-15s : ", "Supplier ID");
            String supplierId = scanner.nextLine();
            // find supplier
            int findSupplier = checkItemFromArray(supplier, supplierId);
            if (findSupplier == -1) {
                System.out.println("can't find supplier id. try again!");
                continue;
            }

            System.out.println(HEADER);
            System.out.printf("|%s|%s|%n", centerText("SUPPLIER ID", (width / 2) - 2), centerText(" SUPPLIER NAME", (width / 2) - 1));
            System.out.println(HEADER);

            System.out.printf("|%s|%s|%n", centerText(supplier[findSupplier][0], (width / 2) - 2), centerText(supplier[findSupplier][1], (width / 2) - 1));
            System.out.println(HEADER);

            System.out.print("Do you want to search another supplier (Y/N)? ");
            String choose = scanner.nextLine().toLowerCase();
            if (choose.equals("n")) break;
        }
    }


    // stock manage section
    public static int stockManageForm() {
        printHeader("STOCK MANAGEMENT ");
        System.out.printf("%n%-" + (width / 2) + "s%-" + (width / 2) + "s%n", "[1] Manage Item Categories", "[2] Add Item");
        System.out.printf("%-" + (width / 2) + "s%-" + (width / 2) + "s%n", "[3] Get Items Supplier Wise", "[4] View Items");
        System.out.printf("%-" + (width / 2) + "s%-" + (width / 2) + "s", "[5] Rank Items Per Unit Price", "[6] Home Page");
        return getIntInput();
    }

    public static void handelStock() {
        while (true) {
            switch (stockManageForm()) {
                case 1:
                    handelManageItemCategory();
                    break;
                case 2:
                    addItemCategory();
                    break;
                case 3:
                    getItemForSupplier();
                    break;
                case 4:
                    viewItems();
                    break;
                case 5:
                    rankUnitPrice();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("invalid input. try again!");
            }
        }
    }

    // category
    public static int manageItemCategoryForm() {
        printHeader("MANAGE ITEM CATEGORY");
        System.out.printf("%n%-" + (width / 2) + "s%-" + (width / 2) + "s%n", "[1] Add New Item Category", "[2] Delete Item Category");
        System.out.printf("%-" + (width / 2) + "s%-" + (width / 2) + "s", "[3] Update Item Category", "[4] Stock Management");
        return getIntInput();
    }

    public static void handelManageItemCategory() {
        while (true) {
            switch (manageItemCategoryForm()) {
                case 1:
                    addItemCategory();
                    break;
                case 2:
                    deleteItemCategory();
                    break;
                case 3:
                    updateItemCategory();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("invalid input. try again!");
            }
        }
    }

    public static void addItemCategory() {
        printHeader("ADD ITEM CATEGORY");
        while (true) {
            System.out.printf("%n%-15s : ", "Enter the new item category");
            String category = scanner.nextLine();
            // check already exists
            if (checkItemFromArray(categories, category) != -1) {
                System.out.println("already exists. try another category");
                continue;
            }

            categories = addItemFromArray(categories, category);

            System.out.print("added successfully! Do you want to add another category (Y/N) : ");
            String choose = scanner.nextLine().toLowerCase();
            if (choose.equals("n")) break;
        }
    }

    public static void updateItemCategory() {
        printHeader("UPDATE ITEM CATEGORY");
        while (true) {
            System.out.printf("%n%-15s : ", "Category");
            String category = scanner.nextLine();
            // check already exists
            int findIndex = checkItemFromArray(categories, category);
            if (findIndex == -1) {
                System.out.println("can't find category. try again!");
                continue;
            }

            System.out.printf("%-15s : ", "new category");
            String newCategory = scanner.nextLine();

            updateArray(categories, findIndex, newCategory);

            System.out.print("update successfully! Do you want to update another category (Y/N) : ");
            String choose = scanner.nextLine().toLowerCase();
            if (choose.equals("n")) break;
        }
    }

    public static void deleteItemCategory() {
        printHeader("DELETE ITEM CATEGORY");
        while (true) {
            System.out.printf("%n%-15s : ", "Category");
            String category = scanner.nextLine();
            // find supplier
            int findIndex = checkItemFromArray(categories, category);
            if (findIndex == -1) {
                System.out.println("can't find category. try again!");
                continue;
            }

            System.out.println(findIndex);

            categories = deleteItemFromArray(categories, findIndex);

            System.out.print("deleted successfully! Do you want to delete another category (Y/N) : ");
            String choose = scanner.nextLine().toLowerCase();
            if (choose.equals("n")) break;
        }
    }
    // category

    public static void addItem() {
        printHeader("ADD ITEM");

        // check it category
        if (categories.length == 0) {
            System.out.println("\nOOPS! It seems that you don't have any item categories in the system.");
            System.out.print("Do you want to add a new item category?(Y/N) ");
            String choose = scanner.nextLine().toLowerCase();
            if (choose.equals("y")) addItemCategory();
            else return;
        }

        if (supplier.length == 0) {
            System.out.println("\nOOPS! It seems that you don't have any supplier in the system.");
            System.out.print("Do you want to add a new item supplier?(Y/N) ");
            String choose = scanner.nextLine().toLowerCase();
            if (choose.equals("y")) addSupplier();
            else return;
        }

        while (true) {
            System.out.printf("%n%-15s : ", "Item Code");
            String itemCode = scanner.nextLine();

            if (checkItemFromArray(items, itemCode) != -1) {
                System.out.println("already exists. try another item code!");
                continue;
            }
            int supplierIndex;
            while (true) {
                System.out.println("\nSupplier List : ");
                System.out.println(HEADER);
                System.out.printf("|%s|%s|%s|%n", centerText("#", (width / 3) - 1), centerText("SUPPLIER ID", (width / 3) - 1), centerText(" SUPPLIER NAME", (width / 3) - 1));
                System.out.println(HEADER);
                for (int i = 0; i < supplier.length; i++) {
                    System.out.printf("|%s|%s|%s|%n", centerText(Integer.toString(i), (width / 3) - 1), centerText(supplier[i][0], (width / 3) - 1), centerText(supplier[i][1], (width / 3) - 1));
                }
                System.out.println(HEADER);
                System.out.print("\nEnter the supplier number > ");
                supplierIndex = scanner.nextInt();
                if (supplierIndex < supplier.length) break;
                System.out.println("invalid input. please try again");
            }

            int categoryIndex;
            while (true) {
                System.out.println("\nCategory List : ");
                System.out.println(HEADER);
                System.out.printf("|%s|%s|%n", centerText("#", (width / 2) - 2), centerText("Category Name", (width / 2) - 1));
                System.out.println(HEADER);
                for (int i = 0; i < categories.length; i++) {
                    System.out.printf("|%s|%s|%n", centerText(Integer.toString(i), (width / 2) - 2), centerText(categories[i], (width / 2) - 1));
                }
                System.out.println(HEADER);
                System.out.print("Enter the category number  > ");
                categoryIndex = scanner.nextInt();
                if (categoryIndex < categories.length) break;
                System.out.println("invalid input. please try again");
            }

            scanner.nextLine();
            System.out.printf("%-15s : ", "Description");
            String description = scanner.nextLine();
            String unitPrice = getIntInput("Unit Price : ", "Invalid input! Please enter a valid integer for Unit Price.");
            String qty = getIntInput("Qtu on hand : ", "Invalid input! Please enter a valid integer for Qtu on hand.");

            items = addItemFromArray(items, Integer.toString(supplierIndex), itemCode, Integer.toString(categoryIndex), description, unitPrice, qty);

            System.out.print("added successfully! Do you want to add another item (Y/N)? : ");
            String choose = scanner.nextLine().toLowerCase();
            if (choose.equals("n")) return;
        }

    }

    public static void getItemForSupplier() {
        printHeader("SEARCH SUPPLIER");
        while (true) {
            System.out.printf("%n%-15s : ", "Supplier ID");
            String supplierId = scanner.nextLine();
            // find supplier
            int findIndex = checkItemFromArray(supplier, supplierId);
            if (findIndex == -1) {
                System.out.println("can't find supplier id. try again!");
                continue;
            }

            System.out.printf("%-15s : ", "Supplier Name");
            String supplierName = scanner.nextLine();
            // find supplier
            if (checkItemFromArray(supplier, supplierName, 1) == -1) {
                System.out.println("can't find supplier name. try again!");
                continue;
            }


            System.out.print("\n");
            System.out.println("+" + "-".repeat(104) + "+");
            System.out.printf("|%s|%s|%s|%s|%s|%n", centerText("ITEM CODE", 20), centerText("DESCRIPTION", 20), centerText("UNIT PRICE", 20), centerText("QTY ON HAND", 20), centerText("CATEGORY", 20));
            System.out.println("+" + "-".repeat(104) + "+");
            for (int i = 0; i < items.length; i++) {
                if (!items[i][0].equals(supplierId)) continue;
                System.out.printf("|%s|%s|%s|%s|%s|%n", centerText(items[i][1], 20), centerText(items[i][3], 20), centerText(items[i][4], 20), centerText(items[i][5], 20), centerText(categories[Integer.parseInt(items[i][2])], 20));
            }
            System.out.println("+" + "-".repeat(104) + "+");
            System.out.print("search successfully!  Do you want to another search? (Y/N) : ");
            String choose = scanner.nextLine().toLowerCase();
            if (choose.equals("n")) return;
        }
    }

    public static void viewItems() {
        printHeader("VIEW ITEMS");

        for (int x = 0; x < categories.length; x++) {
            System.out.println("\n" + categories[x]);
            System.out.println("+" + "-".repeat(104) + "+");
            System.out.printf("|%s|%s|%s|%s|%s|%n", centerText("SID", 20), centerText("CODE", 20), centerText("DESC", 20), centerText("PRICE", 20), centerText("QTY", 20));
            System.out.println("+" + "-".repeat(104) + "+");
            for (int i = 0; i < items.length; i++) {
                if (Integer.parseInt(items[i][2]) != x) continue;
                System.out.printf("|%s|%s|%s|%s|%s|%n", centerText(items[i][0], 20), centerText(items[i][1], 20), centerText(items[i][3], 20), centerText(items[i][4], 20), centerText(items[i][5], 20));
            }
            if (checkItemFromArray(items, Integer.toString(x), 2) == -1) {
                System.out.printf("|%s|%n", centerText("Item Not Found!", 104));
            }
            System.out.println("+" + "-".repeat(104) + "+");
        }
        System.out.print("Do you want to go home (Y/N) : ");
        String choose = scanner.nextLine().toLowerCase();
        if (choose.equals("n")) return;
        return;

    }

    public static void rankUnitPrice() {
        printHeader("RANKED UNIT PRICE ");

        System.out.println("+" + "-".repeat(125) + "+");
        System.out.printf("|%s|%s|%s|%s|%s|%s|%n", centerText("SID", 20), centerText("CODE", 20), centerText("DESC", 20), centerText("PRICE", 20), centerText("QTY", 20), centerText("CAT", 20));
        System.out.println("+" + "-".repeat(125) + "+");
        for (int i = 0; i < 5; i++) {
            System.out.printf("|%s|%s|%s|%s|%s|%s|%n", centerText("s001", 20), centerText("I002", 20), centerText("TOFEE", 20), centerText("50.0", 20), centerText("120", 20), centerText("Food", 20));
        }
        System.out.println("+" + "-".repeat(125) + "+");
    }


    public static void main(String[] args) throws InterruptedException {
        while (true) {
            if (!isLogin) login();
            switch (welcomeForm()) {
                case 1:
                    credentialsForm();  // done
                    break;
                case 2:
                    handelSupplier(); // done
                    break;
                case 3:
                    handelStock();  // done only route not logically working
                    break;
                case 4:
                    isLogin = false;
                    break;
                case 5:
                    return;
                default:
                    System.out.println("invalid input. try again!");
            }
        }
    }
}
