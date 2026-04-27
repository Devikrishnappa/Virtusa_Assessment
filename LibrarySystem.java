import java.util.*;
class Book {
    int id;
    String title;
    String author;
    boolean isIssued;
    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    void display() {
        System.out.println(id + " - " + title + " by " + author + 
        (isIssued ? " (Issued)" : " (Available)"));
    }
}

class User {
    int id;
    String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class LibrarySystem {

    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<User> users = new ArrayList<>();
    static HashMap<Integer, Integer> issuedBooks = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    // Add Book
    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    // View Books
    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book b : books) {
            b.display();
        }
    }

    // Add User
    static void addUser() {
        System.out.print("Enter User ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        users.add(new User(id, name));
        System.out.println("User registered successfully!");
    }

    // Issue Book
    static void issueBook() {
        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();

        System.out.print("Enter User ID: ");
        int userId = sc.nextInt();

        for (Book b : books) {
            if (b.id == bookId && !b.isIssued) {
                b.isIssued = true;
                issuedBooks.put(bookId, userId);
                System.out.println("Book issued!");
                return;
            }
        }

        System.out.println("Book not available or invalid ID.");
    }

    // Return Book + Fine
    static void returnBook() {
        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();

        for (Book b : books) {
            if (b.id == bookId && b.isIssued) {

                System.out.print("Enter days late: ");
                int days = sc.nextInt();

                if (days > 0) {
                    int fine = days * 5;
                    System.out.println("Fine: Rs." + fine);
                } else {
                    System.out.println("No fine.");
                }

                b.isIssued = false;
                issuedBooks.remove(bookId);
                System.out.println("Book returned successfully!");
                return;
            }
        }

        System.out.println("Invalid Book ID.");
    }

    // Search Book
    static void searchBook() {
        sc.nextLine();
        System.out.print("Enter title: ");
        String keyword = sc.nextLine();

        boolean found = false;

        for (Book b : books) {
            if (b.title.toLowerCase().contains(keyword.toLowerCase())) {
                b.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching books found.");
        }
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n Library Menu ");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Register User");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Search Book");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addBook(); break;
                case 2: viewBooks(); break;
                case 3: addUser(); break;
                case 4: issueBook(); break;
                case 5: returnBook(); break;
                case 6: searchBook(); break;
                case 0: System.out.println("Thank you"); break;
                default: System.out.println("Invalid choice");
            }

        } while (choice != 0);
    }
}
