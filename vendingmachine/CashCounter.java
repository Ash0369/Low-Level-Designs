import java.util.HashMap;

public class CashCounter {

    private CashCounter cashCounterInstance;

    HashMap<RuppeeType,Ruppee> cashCounter = new HashMap<RuppeeType,Ruppee>();


    public synchronized void changeCash(RuppeeType ruppeeType, int piece) {
        if(cashCounter.containsKey(ruppeeType)) {
            cashCounter.get(ruppeeType).changeQuantity(piece);
        } else {
            cashCounter.put(ruppeeType, new Ruppee(ruppeeType, piece));
        }
    }

    public synchronized boolean isAvailable(RuppeeType ruppeeType, int piece) {
        if(cashCounter.containsKey(ruppeeType)) {
            return cashCounter.get(ruppeeType).isAvailable(piece);
        }
        return false;
    }

    public void printCashCounter() {
        for (RuppeeType ruppeeType : cashCounter.keySet()) {
            System.out.println("RuppeeType : " + ruppeeType);
            System.out.println("Pieces : " + cashCounter.get(ruppeeType).getPieces());
        }
    }


}
