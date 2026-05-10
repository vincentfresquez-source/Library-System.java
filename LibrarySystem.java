import java.util.Scanner;

public class LibrarySystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        int choice = 0;

        System.out.println("📖 Welcome to Vince's Library System");

        while (choice != 6) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Add Book");
                System.out.println("2. Borrow Book");
                System.out.println("3. Return Book");
                System.out.println("4. Search by Title");
                System.out.println("5. Print All Books");
                System.out.println("6. Exit");

                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter Title: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();

                        System.out.print("Enter ISBN: ");
                        String isbn = scanner.nextLine();

                        System.out.print("Enter Pages: ");
                        int pages = scanner.nextInt();

                        Book book = new Book(id, title, author, isbn, pages);
                        inventory.addBook(book);
                        break;

                    case 2:
                        System.out.print("Enter Book ID to borrow: ");
                        int borrowId = scanner.nextInt();
                        inventory.borrowBook(borrowId);
                        break;

                    case 3:
                        System.out.print("Enter Book ID to return: ");
                        int returnId = scanner.nextInt();
                        inventory.returnBook(returnId);
                        break;

                    case 4:
                        System.out.print("Enter title to search: ");
                        scanner.nextLine(); // FIX subtle bug here
                        String searchTitle = scanner.nextLine();
                        inventory.searchByTitle(searchTitle);
                        break;

                    case 5:
                        inventory.printAll();
                        break;

                    case 6:
                        System.out.println("Exiting the program. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option. Try again.");
                }

            } catch (Exception e) {
                System.out.println("⚠ Invalid input. Please try again.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}