public class Book1 {
    public String ISBN;
    protected String title;
    private String author;

    public Book1(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void displayBookInfo() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class EBook extends Book1 {
    private double fileSizeMB;

    public EBook(String ISBN, String title, String author, double fileSizeMB) {
        super(ISBN, title, author);
        this.fileSizeMB = fileSizeMB;
    }

    public void displayEBookInfo() {
        System.out.println("EBook ISBN: " + ISBN);
        System.out.println("EBook Title: " + title);
        System.out.println("File Size: " + fileSizeMB + " MB");
    }
}

class BookTest {
    public static void main(String[] args) {
        EBook ebook = new EBook("978-0134685991", "Effective Java", "Joshua Bloch", 5.2);

        ebook.displayBookInfo();
        System.out.println();
        ebook.displayEBookInfo();

        ebook.setAuthor("J. Bloch");
        System.out.println("\nUpdated Author: " + ebook.getAuthor());
    }

}
