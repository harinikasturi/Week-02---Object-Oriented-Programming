public class Library {
    String title;
    String author;
    double price;
    boolean isAvailable;

    public Library(String title, String author, double price, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public void borrowLibrary() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("You have successfully borrowed the book: " + title);
        } else {
            System.out.println("Sorry, the book \"" + title + "\" is currently not available.");
        }
    }

    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
    }

    public static void main(String[] args) {
        Library book1 = new Library("1984", "George Orwell", 399.50, true);

        System.out.println("Book Details:");
        book1.display();

        System.out.println("\nBorrowing book...");
        book1.borrowLibrary();

        System.out.println("\nAfter borrowing:");
        book1.display();
    }
}
