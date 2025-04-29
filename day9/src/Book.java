import java.util.ArrayList;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return title + " by " + author;
    }
}

class Library {
    private String name;
    private ArrayList<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        System.out.println("Books in " + name + " library:");
        for (Book book : books) {
            System.out.println("- " + book);
        }
    }
}
class LibraryDemo {
    public static void main(String[] args) {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book3 = new Book("1984", "George Orwell");

        Library library1 = new Library("Central Library");
        library1.addBook(book1);
        library1.addBook(book2);

        Library library2 = new Library("Community Library");
        library2.addBook(book3);
        library2.addBook(book1); // Same book can be in multiple libraries

        library1.displayBooks();
        library2.displayBooks();
    }
}