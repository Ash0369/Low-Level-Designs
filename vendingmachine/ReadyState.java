import java.util.HashMap;
import java.util.Scanner;

public class ReadyState implements VendingMachineState {

    private final VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void handleRequest() {
        System.out.println("Select the ProductId from the stock");
        HashMap<String,Product> stock = vendingMachine.getStock().getStock();
        for (String productId : stock.keySet()) {
            System.out.println("ProductId : " + productId);
            System.out.println("ProductName : " + stock.get(productId).getName());
            System.out.println("ProductPrice : " + stock.get(productId).getPrice());
        }
        Scanner sc = new Scanner(System.in);
        String productId = sc.nextLine();

        if (stock.containsKey(productId)) {
            vendingMachine.setSelectedProduct(stock.get(productId));
            vendingMachine.setVendingMachineState(vendingMachine.getSelectedState());
            vendingMachine.getSelectedState().handleRequest();
        }
        else{
            System.out.println("We not have this Product");
        }


    }
}
