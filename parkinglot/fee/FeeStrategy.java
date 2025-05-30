package parkinglot.fee;

import parkinglot.Ticket;

//Strategy pattern for calculating fees
public interface FeeStrategy {
    double calculateFees(Ticket ticket);
}
