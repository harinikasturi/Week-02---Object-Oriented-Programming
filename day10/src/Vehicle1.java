class Vehicle1 {
    protected int maxSpeed;
    protected String model;

    public Vehicle1(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
}

interface Refuelable {
    void refuel();
}

class PetrolVehicle extends Vehicle1 implements Refuelable {
    public PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    @Override
    public void refuel() {
        System.out.println(model + " is refueling with petrol.");
    }
}

class ElectricVehicle extends Vehicle1 {
    public ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }

    public void charge() {
        System.out.println(model + " is charging its battery.");
    }
}

class VehicleManagementDemo {
    public static void main(String[] args) {
        PetrolVehicle petrolCar = new PetrolVehicle(180, "Toyota Camry");
        ElectricVehicle electricCar = new ElectricVehicle(200, "Tesla Model S");

        petrolCar.refuel();
        electricCar.charge();
    }
}