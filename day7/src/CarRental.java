public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double dailyRate;

    public CarRental() {
        this("Unknown", "Standard", 1, 1000.0);
    }

    public CarRental(String customerName, String carModel, int rentalDays, double dailyRate) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = dailyRate;
    }

    public double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    public void display() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Daily Rate: ₹" + dailyRate);
        System.out.println("Total Cost: ₹" + calculateTotalCost());
    }

    public static void main(String[] args) {
        CarRental rental1 = new CarRental();
        CarRental rental2 = new CarRental("Alice", "Hyundai Creta", 5, 1500.0);

        System.out.println("Rental 1:");
        rental1.display();

        System.out.println("\nRental 2:");
        rental2.display();
    }

}
