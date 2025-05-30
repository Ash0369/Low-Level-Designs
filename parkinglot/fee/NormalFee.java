package parkinglot.fee;

import parkinglot.Ticket;
import parkinglot.vehicle.VehicleType;

public class NormalFee implements FeeStrategy {
    @Override
    public double calculateFees(Ticket ticket) {
        VehicleType type = ticket.getVehicle().getVehicleType();
        long timeSpent  = ticket.getExitTimeStamp() - ticket.getEntryTimeStamp();
        FeeMap feeMap = new FeeMap();
        return timeSpent*feeMap.getCost(type);
    }
}
