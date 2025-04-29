public class CartItem {
    private String itemName;
    private double price;
    private int quantity;

    public CartItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = 0;
    }

    public void addItem(int quantity) {
        this.quantity += quantity;
        System.out.println(quantity + " " + itemName + "(s) added to cart");
    }

    public void removeItem(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
            System.out.println(quantity + " " + itemName + "(s) removed from cart");
        } else {
            System.out.println("Cannot remove more items than are in the cart");
        }
    }

    public double calculateTotalCost() {
        return price * quantity;
    }

    public void displayCart() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per item: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total cost: $" + calculateTotalCost());
    }

    public static void main(String[] args) {
        CartItem item = new CartItem("Smartphone", 599.99);
        item.addItem(2);
        item.removeItem(1);
        item.displayCart();
    }
}