package parkinglot.parkingcommand;

import parkinglot.Ticket;
import parkinglot.parking.ParkingSpot;

import java.util.Optional;

public interface ParkingCommand {
    Optional<Ticket> execute(ParkingSpot parkingSpot) throws Exception;
    void rollback(ParkingSpot parkingSpot);
}
