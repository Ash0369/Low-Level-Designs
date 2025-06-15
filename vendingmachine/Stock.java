import java.util.HashMap;


public class Stock {
    private HashMap<String,Product> stockList;

    public Stock() {
        stockList = new HashMap<String,Product>();
    }

    public void addProduct(String productId, String productName, int price, int quantity) {
        Product product;
        if (stockList.containsKey(productId)) {
            product = stockList.get(productId);
            product.changeQuantity(quantity);
        } else {
            product = new Product(productName, price, productId, quantity);
            stockList.put(productId, product);
        }
    }

    public void dispenseProduct(Product product) {
        product.changeQuantity(-1);
    }

    public HashMap<String,Product> getStock() {
        return stockList;
    }

    public void printStock() {
        for (String productId : stockList.keySet()) {
            System.out.println("ProductId : " + productId);
            System.out.println("ProductName : " + stockList.get(productId).getName());
            System.out.println("ProductPrice : " + stockList.get(productId).getPrice());
            System.out.println("ProductQuantity : " + stockList.get(productId).getQuantity());
        }
    }

}
