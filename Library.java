public class Library {
    private Book[] books;
    private User[] users;
    private int bookCount;
    private int userCount;

    public Library(int maxBooks, int maxUsers) {
        books = new Book[maxBooks];
        users = new User[maxUsers];
        bookCount = 0;
        userCount = 0;
    }

    public void addBook(Book book) {
        books[bookCount++] = book;
    }

    public void addUser(User user) {
        users[userCount++] = user;
    }

    public void issueBook(int bookId) {
        for (Book b : books) {
            if (b != null && b.getBookId() == bookId && !b.isIssued()) {
                b.issue();
                System.out.println("Book issued: " + b.getTitle());
                return;
            }
        }
        System.out.println("Book not found or already issued.");
    }

    public void returnBook(int bookId) {
        for (Book b : books) {
            if (b != null && b.getBookId() == bookId && b.isIssued()) {
                b.returnBook();
                System.out.println("Book returned: " + b.getTitle());
                return;
            }
        }
        System.out.println("Book not found or not issued.");
    }

    public void showBooks() {
        System.out.println("\nBook List:");
        for (Book b : books) {
            if (b != null) b.displayBook();
        }
    }

    public void showUsers() {
        System.out.println("\nUser List:");
        for (User u : users) {
            if (u != null) u.displayUser();
        }
    }
}