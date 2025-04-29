import java.util.ArrayList;

class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

class OrderItem {
    private Product product;
    private int quantity;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return quantity + " x " + product.getName() + " = $" + getTotalPrice();
    }
}

class Order {
    private String orderId;
    private Customers customer;
    private ArrayList<OrderItem> items;

    public Order(String orderId, Customers customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        items.add(new OrderItem(product, quantity));
    }

    public double getTotalAmount() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getTotalPrice();
        }
        return total;
    }

    public void displayOrder() {
        System.out.println("Order #" + orderId + " for " + customer.getName());
        System.out.println("Items:");
        for (OrderItem item : items) {
            System.out.println("- " + item);
        }
        System.out.println("Total: $" + getTotalAmount());
    }
}

class Customers {
    private String id;
    private String name;
    private ArrayList<Order> orderHistory;

    public Customers(String id, String name) {
        this.id = id;
        this.name = name;
        this.orderHistory = new ArrayList<>();
    }

    public Order placeOrder(String orderId) {
        Order newOrder = new Order(orderId, this);
        orderHistory.add(newOrder);
        return newOrder;
    }

    public void viewOrderHistory() {
        System.out.println("Order history for " + name + ":");
        for (Order order : orderHistory) {
            order.displayOrder();
            System.out.println();
        }
    }

    public String getName() {
        return name;
    }
}

class ECommerceDemo {
    public static void main(String[] args) {
        // Create products
        Product laptop = new Product("P100", "Laptop", 999.99);
        Product phone = new Product("P101", "Smartphone", 699.99);
        Product headphones = new Product("P102", "Wireless Headphones", 149.99);

        // Create customer
        Customers customer = new Customers("C100", "Alice Johnson");

        // Place orders
        Order order1 = customer.placeOrder("ORD1001");
        order1.addItem(laptop, 1);
        order1.addItem(headphones, 2);

        Order order2 = customer.placeOrder("ORD1002");
        order2.addItem(phone, 1);
        order2.addItem(headphones, 1);

        // Display order history
        customer.viewOrderHistory();
    }
}