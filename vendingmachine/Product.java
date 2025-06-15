public class Product {
    private final String name;
    private int price;
    private final String productCode;
    private int quantity;

    public Product(String name, int price, String productCode, int quantity) {
        this.name = name;
        this.price = price;
        this.productCode = productCode;
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public synchronized void updatePrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public synchronized boolean isAvailable(int quantity) {
        return quantity <= this.quantity;
    }

    public synchronized boolean changeQuantity(int quantity) {
        if (quantity>=0 || isAvailable(quantity)) {
            this.quantity += quantity;
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
