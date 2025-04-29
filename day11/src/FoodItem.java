// Discountable interface
interface Discountable {
    void applyDiscount(double percentage);
    String getDiscountDetails();
}

// Abstract FoodItem class
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    private double discount;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total: $" + calculateTotalPrice());
        if (discount > 0) {
            System.out.println("Discount applied: " + (discount * 100) + "%");
        }
    }

    // Encapsulated getters and setters
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public double getDiscount() { return discount; }
    protected void setDiscount(double discount) { this.discount = discount; }
}

// VegItem class
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() * (1 - getDiscount());
    }

    // Discountable interface implementation
    @Override
    public void applyDiscount(double percentage) {
        if (percentage >= 0 && percentage <= 0.5) { // Max 50% discount
            setDiscount(percentage);
        }
    }

    @Override
    public String getDiscountDetails() {
        return "Vegetarian item - " + (getDiscount() * 100) + "% discount";
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    private static final double SERVICE_CHARGE = 0.1; // 10%

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        double basePrice = getPrice() * getQuantity();
        double serviceCharge = basePrice * SERVICE_CHARGE;
        return (basePrice + serviceCharge) * (1 - getDiscount());
    }

    // Discountable interface implementation
    @Override
    public void applyDiscount(double percentage) {
        if (percentage >= 0 && percentage <= 0.3) { // Max 30% discount
            setDiscount(percentage);
        }
    }

    @Override
    public String getDiscountDetails() {
        return "Non-vegetarian item - " + (getDiscount() * 100) + "% discount (includes 10% service charge)";
    }
}

class FoodDeliverySystem {
    public static void processOrder(FoodItem[] items) {
        System.out.println("\nOrder Summary:");
        double total = 0;
        for (FoodItem item : items) {
            item.getItemDetails();
            total += item.calculateTotalPrice();
            System.out.println();
        }
        System.out.printf("Total Order Amount: $%.2f%n", total);
    }

    public static void main(String[] args) {
        // Create food items
        VegItem vegPizza = new VegItem("Vegetable Pizza", 12.99, 2);
        NonVegItem chickenBurger = new NonVegItem("Chicken Burger", 9.99, 3);

        // Apply discounts
        vegPizza.applyDiscount(0.15); // 15% discount
        chickenBurger.applyDiscount(0.1); // 10% discount

        // Demonstrate polymorphism
        FoodItem[] items = {vegPizza, chickenBurger};
        processOrder(items);

        // Show discount details
        System.out.println("Discount Details:");
        for (FoodItem item : items) {
            if (item instanceof Discountable) {
                System.out.println(((Discountable)item).getDiscountDetails());
            }
        }
    }
}