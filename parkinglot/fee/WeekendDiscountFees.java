package parkinglot.fee;

import parkinglot.Ticket;
import parkinglot.vehicle.VehicleType;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class WeekendDiscountFees implements FeeStrategy {
    @Override
    public double calculateFees(Ticket ticket) {
        VehicleType type = ticket.getVehicle().getVehicleType();
        long timeSpent  = ticket.getExitTimeStamp() - ticket.getEntryTimeStamp();
        FeeMap feeMap = new FeeMap();
        double amount =  timeSpent*feeMap.getCost(type)*0.2;
        ZonedDateTime dateTime = Instant.ofEpochMilli(ticket.getEntryTimeStamp())
                .atZone(ZoneId.systemDefault());

        DayOfWeek dayOfWeek = dateTime.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            return amount * 0.8; // 20% discount
        }
        return amount;
    }
}
