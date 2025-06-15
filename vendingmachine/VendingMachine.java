public class VendingMachine {

    private static VendingMachine vendingMachineInstance;
    private VendingMachineState vendingMachineState;
    private CashCounter cashCounter;
    private Stock stock;
    private Product selectedProduct;
    private VendingMachineState readyState;
    private VendingMachineState selectedState;
    private VendingMachineState maintenanceState;
    private VendingMachineState productDispenserState;
    private int amountPaid;

    public int getAmountToBePaid() {
        return amountToBePaid;
    }

    public void setAmountToBePaid(int amountToBePaid) {
        this.amountToBePaid = amountToBePaid;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    private int amountToBePaid;

    public VendingMachineState getSelectedState() {
        return selectedState;
    }

    public VendingMachineState getReadyState() {
        return readyState;
    }

    public CashCounter getCashCounter() {
        return cashCounter;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public VendingMachineState getMaintenanceState() {
        return maintenanceState;
    }

    public VendingMachineState getProductDispenserState() {
        return productDispenserState;
    }

    private VendingMachine() {
        cashCounter = new CashCounter();
        stock = new Stock();
        readyState = new ReadyState(this);
        selectedState = new SelectedProductState(this);
        vendingMachineState = readyState;
        maintenanceState = new MaintaienceState(this);
        productDispenserState = new ProductDispenserState(this);
    }

    public static synchronized VendingMachine getVendingMachineInstance(){
        if(vendingMachineInstance == null) {
            vendingMachineInstance = new VendingMachine();
        }
        return vendingMachineInstance;
    }

    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }

    public synchronized void setVendingMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }


}
