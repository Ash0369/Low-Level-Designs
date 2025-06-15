public class ProductDispenserState implements VendingMachineState {

    private VendingMachine vendingMachine;

    public ProductDispenserState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void handleRequest() {
        vendingMachine.getStock().dispenseProduct(vendingMachine.getSelectedProduct());
        System.out.println("Product dispensed "+ vendingMachine.getSelectedProduct().getName());
        vendingMachine.setVendingMachineState(vendingMachine.getReadyState());
    }
}
