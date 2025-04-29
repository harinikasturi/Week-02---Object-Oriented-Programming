public class Book {
    String title;
    String author;
    double price;

    public Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }

    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book("The Alchemist", "Paulo Coelho", 299.99);

        System.out.println("Book 1 details:");
        book1.display();

        System.out.println("\nBook 2 details:");
        book2.display();
    }

}
