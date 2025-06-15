import java.util.Scanner;

public class MaintaienceState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public MaintaienceState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void handleRequest() {
        System.out.println("Vending Machine is in maintaience state");
        System.out.println("Enter the product Id ");
        Scanner sc = new Scanner(System.in);
        String productId = sc.nextLine();
        System.out.println("Enter the quantity");
        int quantity = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the product name");
        String productName = sc.nextLine();
        System.out.println("Enter the product price");
        int price = sc.nextInt();
        sc.nextLine();
        vendingMachine.getStock().addProduct(productId, productName, price, quantity);
        vendingMachine.setVendingMachineState(vendingMachine.getReadyState());

    }
}
