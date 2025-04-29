// GPS interface
interface GPS {
    void updateLocation(double latitude, double longitude);
    String getCurrentLocation();
}

// Abstract Vehicle class
abstract class Vehicle1 {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private double latitude;
    private double longitude;

    public Vehicle1(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Abstract method
    public abstract double calculateFare(double distance);

    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver: " + driverName);
        System.out.println("Rate per km: $" + ratePerKm);
    }

    // Encapsulated getters and setters
    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }
    protected double getLatitude() { return latitude; }
    protected double getLongitude() { return longitude; }
    protected void setLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

// Car class
class Car extends Vehicle1 implements GPS {
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    // GPS interface implementation
    @Override
    public void updateLocation(double latitude, double longitude) {
        setLocation(latitude, longitude);
        System.out.println(getDriverName() + "'s car location updated");
    }

    @Override
    public String getCurrentLocation() {
        return "Car location: " + getLatitude() + ", " + getLongitude();
    }
}

// Bike class
class Bike extends Vehicle1 implements GPS {
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() * 0.7; // 30% discount for bikes
    }

    // GPS interface implementation
    @Override
    public void updateLocation(double latitude, double longitude) {
        setLocation(latitude, longitude);
        System.out.println(getDriverName() + "'s bike location updated");
    }

    @Override
    public String getCurrentLocation() {
        return "Bike location: " + getLatitude() + ", " + getLongitude();
    }
}

// Auto class
class Auto extends Vehicle1 implements GPS {
    private static final double BASE_FARE = 20.0;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return BASE_FARE + (distance * getRatePerKm());
    }

    // GPS interface implementation
    @Override
    public void updateLocation(double latitude, double longitude) {
        setLocation(latitude, longitude);
        System.out.println(getDriverName() + "'s auto location updated");
    }

    @Override
    public String getCurrentLocation() {
        return "Auto location: " + getLatitude() + ", " + getLongitude();
    }
}

class RideHailingApp {
    public static void calculateRides(Vehicle[] vehicles, double distance) {
        System.out.println("\nRide Estimates for " + distance + " km:");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getDriverName() + "'s " +
                    vehicle.getClass().getSimpleName() +
                    ": $" + vehicle.calculateFare(distance));
        }
    }

    public static void main(String[] args) {
        // Create vehicles
        Car car = new Car("V1001", "John Doe", 1.5);
        Bike bike = new Bike("V1002", "Jane Smith", 0.8);
        Auto auto = new Auto("V1003", "Mike Johnson", 1.2);

        // Update locations
        car.updateLocation(12.9716, 77.5946);
        bike.updateLocation(12.9726, 77.5956);
        auto.updateLocation(12.9736, 77.5966);

        // Demonstrate polymorphism
        Vehicle[] vehicles = {car, bike, auto};

        for (Vehicle vehicle : vehicles) {
            vehicle.getVehicleDetails();
            if (vehicle instanceof GPS) {
                System.out.println(((GPS)vehicle).getCurrentLocation());
            }
            System.out.println();
        }

        // Calculate rides for 10 km
        calculateRides(vehicles, 10);
    }
}