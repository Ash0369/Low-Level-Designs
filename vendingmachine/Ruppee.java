public class Ruppee {
    private RuppeeType ruppeeType;
    int pieces;

    public Ruppee(RuppeeType ruppeeType, int pieces) {
        this.ruppeeType = ruppeeType;
        this.pieces = pieces;
    }

    public RuppeeType getRuppeeType() {
        return ruppeeType;
    }

    public int getPieces() {
        return pieces;
    }

    boolean isAvailable(int quantity) {
        return quantity <= this.pieces;
    }

    public synchronized boolean changeQuantity(int quantity) {
        if (quantity>=0 || isAvailable(quantity)) {
            this.pieces += quantity;
            return true;
        }
        return false;
    }
}
