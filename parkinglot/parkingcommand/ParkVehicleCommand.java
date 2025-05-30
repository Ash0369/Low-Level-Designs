package parkinglot.parkingcommand;

import parkinglot.parking.ParkingSpot;
import parkinglot.Ticket;
import parkinglot.vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

//Command pattern to rollback if ny failures occur

public class ParkVehicleCommand implements ParkingCommand {
    Vehicle vehicle;
    Map<String, Ticket> activeTickets;
    Ticket ticket;
    public ParkVehicleCommand(Vehicle vehicle, Map<String,Ticket> activeTickets) {
        this.vehicle = vehicle;
        this.activeTickets = activeTickets;
    }
    @Override
    public Optional<Ticket> execute(ParkingSpot parkingSpot) throws Exception {
        try {
            if(!parkingSpot.park(vehicle)){
                return Optional.empty();
            }

            String ticketId = UUID.randomUUID().toString();
            ticket = new Ticket(ticketId, vehicle, parkingSpot);
            activeTickets.put(ticketId,ticket);
            return Optional.of(ticket);
        } catch (Exception e){
            rollback(parkingSpot);
            throw new Exception("Failed to park",e);
        }
    }

    @Override
    public void rollback(ParkingSpot parkingSpot) {
        parkingSpot.unPark();
    }

    public Ticket getTicket(){
        return ticket;
    }
}
