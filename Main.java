import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Library library = new Library(100, 50);

    public static void main(String[] args) {
        System.out.println("📚 Welcome to the Library Management System 📚");

        while (true) {
            showMenu();
            int choice = getChoice();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> addUser();
                case 3 -> library.showBooks();
                case 4 -> library.showUsers();
                case 5 -> issueBook();
                case 6 -> returnBook();
                case 7 -> exitApp();
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1. Add Book");
        System.out.println("2. Add User");
        System.out.println("3. Show Books");
        System.out.println("4. Show Users");
        System.out.println("5. Issue Book");
        System.out.println("6. Return Book");
        System.out.println("7. Exit");
    }

    private static int getChoice() {
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // consume newline
        return choice;
    }

    private static void addBook() {
        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        Book book = new Book(bookId, title);
        library.addBook(book);
        System.out.println("Book added successfully.");
    }

    private static void addUser() {
        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter User Name: ");
        String name = sc.nextLine();
        User user = new User(userId, name);
        library.addUser(user);
        System.out.println("User added successfully.");
    }

    private static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int bookId = sc.nextInt();
        library.issueBook(bookId);
    }

    private static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int bookId = sc.nextInt();
        library.returnBook(bookId);
    }

    private static void exitApp() {
        System.out.println("Exiting... Thank you!");
        sc.close();
        System.exit(0);
    }
}