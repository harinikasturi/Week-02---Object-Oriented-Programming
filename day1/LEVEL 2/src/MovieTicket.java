public class MovieTicket {
    private String movieName;
    private String seatNumber;
    private double price;

    public MovieTicket(String movieName, double basePrice) {
        this.movieName = movieName;
        this.price = basePrice;
        this.seatNumber = "Not assigned";
    }

    public void bookTicket(String seatNumber) {
        this.seatNumber = seatNumber;
        // Premium seats cost 20% more
        if (seatNumber.startsWith("P")) {
            price *= 1.2;
        }
        System.out.println("Ticket booked successfully!");
    }

    public void displayTicketDetails() {
        System.out.println("Movie: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: $" + price);
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket("Avengers", 12.99);
        ticket.bookTicket("P12");
        ticket.displayTicketDetails();
    }
}