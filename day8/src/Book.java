public class Book {
    private static String libraryName = "Central Library";
    private final String isbn;
    private String title;
    private String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }

    public static void main(String[] args) {
        Book book1 = new Book("978-3-16-148410-0", "Java Programming", "James Gosling");
        Book.displayLibraryName();
        book1.displayDetails();

        System.out.println(book1 instanceof Book); // true
    }
}