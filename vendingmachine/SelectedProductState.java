import java.util.Arrays;
import java.util.Scanner;

public class SelectedProductState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public SelectedProductState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    boolean returnPossible(int value) {
        //Currently handling only direct amount return
        if(vendingMachine.getAmountToBePaid() >= value){
            return true;
        } else {
            int amountToReturn = vendingMachine.getAmountToBePaid() - value;
            System.out.println("Checking for return " + -1*amountToReturn);
            if (vendingMachine.getCashCounter().isAvailable(RuppeeType.fromValue(-1*amountToReturn),1)){
                return true;
            }
        }
        return false;
    }
    boolean isAvailable(int value) {
        return RuppeeType.isAvailable(value) && returnPossible(value);
    }

    @Override
    public synchronized void handleRequest() {
        int cost  = vendingMachine.getSelectedProduct().getPrice();
        System.out.println("Cost of the Product : " + cost);
        System.out.println("Please insert the cash");
        vendingMachine.setAmountToBePaid(cost);

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Cash counter");
            vendingMachine.getCashCounter().printCashCounter();
            System.out.println();
            System.out.println("For inserting the cash press 1 for exiting press 2");
            int option = sc.nextInt();
            if(option == 1){
                System.out.println("Please insert the cash");
            } else if(option == 2){
                vendingMachine.setSelectedProduct(null);
                vendingMachine.setAmountPaid(0);
                vendingMachine.setVendingMachineState(vendingMachine.getReadyState());
                break;
            }
            int insertedCash = sc.nextInt();
            if(isAvailable(insertedCash)) {
                vendingMachine.getCashCounter().changeCash(RuppeeType.fromValue(insertedCash), 1);
                vendingMachine.setAmountToBePaid(vendingMachine.getAmountToBePaid() - insertedCash);
                if(vendingMachine.getAmountToBePaid() == 0){
                    vendingMachine.setVendingMachineState(vendingMachine.getProductDispenserState());
                    break;
                } else if(vendingMachine.getAmountToBePaid()<0) {
                    vendingMachine.getCashCounter().changeCash(RuppeeType.fromValue(-1*vendingMachine.getAmountToBePaid()), -1);
                    System.out.println("Collect the remaining cash "+ -1*vendingMachine.getAmountToBePaid());
                    vendingMachine.setAmountToBePaid(0);
                    vendingMachine.setVendingMachineState(vendingMachine.getProductDispenserState());
                    break;
                } else {
                    System.out.println("Please insert remaining cash "+ vendingMachine.getAmountToBePaid());
                }
            }else{
                System.out.println("We not accept this cash");
            }
        }

    }
}
