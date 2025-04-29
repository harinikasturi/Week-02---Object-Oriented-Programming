// Taxable interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract Product class
abstract class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Abstract method
    public abstract double calculateDiscount();

    // Concrete method
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: $" + price);
        System.out.println("Discount: $" + calculateDiscount());
    }

    // Encapsulated getters and setters
    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public void setPrice(double price) {
        if (price >= 0) this.price = price;
    }
}

// Electronics class
class Electronics extends Product implements Taxable {
    private String brand;

    public Electronics(String productId, String name, double price, String brand) {
        super(productId, name, price);
        this.brand = brand;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    // Taxable interface implementation
    @Override
    public double calculateTax() {
        return getPrice() * 0.15; // 15% tax
    }

    @Override
    public String getTaxDetails() {
        return "Electronics tax rate: 15%";
    }

    // Method to calculate final price
    public double calculateFinalPrice() {
        return getPrice() + calculateTax() - calculateDiscount();
    }
}

// Clothing class
class Clothing extends Product implements Taxable {
    private String size;

    public Clothing(String productId, String name, double price, String size) {
        super(productId, name, price);
        this.size = size;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }

    // Taxable interface implementation
    @Override
    public double calculateTax() {
        return getPrice() * 0.10; // 10% tax
    }

    @Override
    public String getTaxDetails() {
        return "Clothing tax rate: 10%";
    }

    // Method to calculate final price
    public double calculateFinalPrice() {
        return getPrice() + calculateTax() - calculateDiscount();
    }
}

// Groceries class
class Groceries extends Product {
    private String expiryDate;

    public Groceries(String productId, String name, double price, String expiryDate) {
        super(productId, name, price);
        this.expiryDate = expiryDate;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }

    // Method to calculate final price (no tax for groceries)
    public double calculateFinalPrice() {
        return getPrice() - calculateDiscount();
    }
}

class ECommercePlatform {
    public static void printFinalPrices(Product[] products) {
        System.out.println("Final Prices:");
        for (Product product : products) {
            double finalPrice;
            if (product instanceof Electronics) {
                finalPrice = ((Electronics)product).calculateFinalPrice();
            } else if (product instanceof Clothing) {
                finalPrice = ((Clothing)product).calculateFinalPrice();
            } else if (product instanceof Groceries) {
                finalPrice = ((Groceries)product).calculateFinalPrice();
            } else {
                finalPrice = product.getPrice();
            }

            System.out.printf("%s: $%.2f%n", product.getName(), finalPrice);
        }
    }

    public static void main(String[] args) {
        // Create products
        Electronics laptop = new Electronics("P1001", "Laptop", 999.99, "Dell");
        Clothing shirt = new Clothing("P1002", "T-Shirt", 29.99, "M");
        Groceries apple = new Groceries("P1003", "Apple", 1.99, "2023-12-31");

        // Demonstrate polymorphism
        Product[] products = {laptop, shirt, apple};

        for (Product product : products) {
            product.displayDetails();
            if (product instanceof Taxable) {
                System.out.println(((Taxable)product).getTaxDetails());
                System.out.println("Tax: $" + ((Taxable)product).calculateTax());
            }
            System.out.println();
        }

        // Show final prices
        printFinalPrices(products);
    }
}