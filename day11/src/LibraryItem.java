// Reservable interface
interface Reservable {
    void reserveItem(String borrower);
    boolean checkAvailability();
}

// Abstract LibraryItem class
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    boolean isReserved;
    String reservedBy;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    // Abstract method
    public abstract int getLoanDuration();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Loan Duration: " + getLoanDuration() + " days");
        System.out.println("Status: " + (isReserved ? "Reserved by " + reservedBy : "Available"));
    }

    // Encapsulated getters and setters
    public String getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isReserved() { return isReserved; }
}

// Book class
class Book extends LibraryItem implements Reservable {
    private String isbn;

    public Book(String itemId, String title, String author, String isbn) {
        super(itemId, title, author);
        this.isbn = isbn;
    }

    @Override
    public int getLoanDuration() {
        return 21; // 3 weeks
    }

    // Reservable interface implementation
    @Override
    public void reserveItem(String borrower) {
        if (!isReserved()) {
            boolean isReserved = true;
            reservedBy = borrower;
            System.out.println(getTitle() + " has been reserved by " + borrower);
        } else {
            boolean title = false;
            System.out.println(title + " is already reserved");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved();
    }
}

// Magazine class
class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String itemId, String title, String author, int issueNumber) {
        super(itemId, title, author);
        this.issueNumber = issueNumber;
    }

    @Override
    public int getLoanDuration() {
        return 7; // 1 week
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {
    private int runTime;

    public DVD(String itemId, String title, String author, int runTime) {
        super(itemId, title, author);
        this.runTime = runTime;
    }

    @Override
    public int getLoanDuration() {
        return 14; // 2 weeks
    }

    // Reservable interface implementation
    @Override
    public void reserveItem(String borrower) {
        boolean title = false;
        if (!isReserved()) {
            isReserved = true;
            reservedBy = borrower;
            System.out.println(title + " has been reserved by " + borrower);
        } else {
            System.out.println(title + " is already reserved");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved();
    }
}

class LibraryManagementSystem {
    public static void main(String[] args) {
        // Create library items
        Book book = new Book("L1001", "Clean Code", "Robert Martin", "9780132350884");
        Magazine magazine = new Magazine("L1002", "National Geographic", "Various", 256);
        DVD dvd = new DVD("L1003", "The Shawshank Redemption", "Frank Darabont", 142);

        // Demonstrate polymorphism
        LibraryItem[] items = {book, magazine, dvd};

        // Reserve some items
        book.reserveItem("Alice Johnson");
        dvd.reserveItem("Bob Smith");

        for (LibraryItem item : items) {
            item.getItemDetails();
            if (item instanceof Reservable) {
                System.out.println("Available: " + ((Reservable)item).checkAvailability());
            }
            System.out.println();
        }
    }
}