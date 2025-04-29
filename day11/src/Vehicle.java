// Insurable interface
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract Vehicle class
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    // Concrete method
    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Daily Rental Rate: $" + rentalRate);
    }

    // Encapsulated getters and setters
    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }
    public void setRentalRate(double rentalRate) {
        if (rentalRate > 0) this.rentalRate = rentalRate;
    }

    public void getVehicleDetails() {
    }

    public boolean getDriverName() {
        return false;
    }
}

// Car class
class Cars extends Vehicle implements Insurable {
    private int seats;
    private String insurancePolicyNumber;

    public Cars(String vehicleNumber, double rentalRate, int seats) {
        super(vehicleNumber, "Car", rentalRate);
        this.seats = seats;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    // Insurable interface implementation
    @Override
    public double calculateInsurance() {
        return calculateRentalCost(1) * 0.1; // 10% of daily rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Car insurance policy: " + (insurancePolicyNumber != null ? insurancePolicyNumber : "Not set");
    }

    // Specific methods for Car
    public void setInsurancePolicyNumber(String policyNumber) {
        this.insurancePolicyNumber = policyNumber;
    }
}

// Bike class
class Bikes extends Vehicle implements Insurable {
    private String bikeType;

    public Bikes(String vehicleNumber, double rentalRate, String bikeType) {
        super(vehicleNumber, "Bike", rentalRate);
        this.bikeType = bikeType;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.8; // 20% discount for bikes
    }

    // Insurable interface implementation
    @Override
    public double calculateInsurance() {
        return calculateRentalCost(1) * 0.05; // 5% of daily rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike insurance covers basic damage";
    }
}

// Truck class
class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(String vehicleNumber, double rentalRate, double loadCapacity) {
        super(vehicleNumber, "Truck", rentalRate);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.5; // 50% premium for trucks
    }
}

class VehicleRentalSystem {
    public static void processRentals(Vehicle[] vehicles, int days) {
        System.out.println("\nRental Costs for " + days + " days:");
        for (Vehicle vehicle : vehicles) {
            double rentalCost = vehicle.calculateRentalCost(days);
            double insuranceCost = 0;

            if (vehicle instanceof Insurable) {
                insuranceCost = ((Insurable)vehicle).calculateInsurance() * days;
            }

            System.out.printf("%s (%s): Rental $%.2f + Insurance $%.2f = Total $%.2f%n",
                    vehicle.getVehicleNumber(),
                    vehicle.getType(),
                    rentalCost,
                    insuranceCost,
                    rentalCost + insuranceCost);
        }
    }

    public static void main(String[] args) {
        // Create vehicles
        Cars car = new Cars("C1001", 50.0, 5);
        car.setInsurancePolicyNumber("INS12345");

        Bikes bike = new Bikes("B1001", 20.0, "Mountain");

        Truck truck = new Truck("T1001", 100.0, 5000);

        // Demonstrate polymorphism
        Vehicle[] vehicles = {car, bike, truck};

        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails();
            if (vehicle instanceof Insurable) {
                System.out.println(((Insurable)vehicle).getInsuranceDetails());
                System.out.println("Daily Insurance: $" + ((Insurable)vehicle).calculateInsurance());
            }
            System.out.println();
        }

        // Process rentals for 3 days
        processRentals(vehicles, 3);
    }
}