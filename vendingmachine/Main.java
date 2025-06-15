public class Main {
    public static void main(String[] args) {
        System.out.println("Welocome to vending machine");
        VendingMachine vendingMachine = VendingMachine.getVendingMachineInstance();
        vendingMachine.setVendingMachineState(vendingMachine.getMaintenanceState());
        vendingMachine.getVendingMachineState().handleRequest();
        vendingMachine.setVendingMachineState(vendingMachine.getMaintenanceState());
        vendingMachine.getVendingMachineState().handleRequest();
        System.out.println("Finished Maintenance");
        vendingMachine.setVendingMachineState(vendingMachine.getReadyState());
        vendingMachine.getVendingMachineState().handleRequest();
        vendingMachine.getVendingMachineState().handleRequest();

        vendingMachine.getStock().printStock();
    }
}