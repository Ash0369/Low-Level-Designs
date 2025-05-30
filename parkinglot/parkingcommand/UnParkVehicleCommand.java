package parkinglot.parkingcommand;

import parkinglot.parking.ParkingSpot;
import parkinglot.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UnParkVehicleCommand implements ParkingCommand {
    public Map<String, Ticket> activeTicket;
    public String ticketId;
    Ticket ticket;

    public UnParkVehicleCommand(Map<String,Ticket>activeTicket, String ticketId){
        this.activeTicket = activeTicket;
        this.ticketId = ticketId;
    }
    @Override
    public Optional<Ticket> execute(ParkingSpot parkingSpot) throws Exception {
        ticket = activeTicket.remove(ticketId);
        try {
            ticket.getParkingSpot().unPark();
            ticket.setExitTimeStamp();
            return Optional.of(ticket);
        } catch (Exception e){
            rollback(parkingSpot);
            throw new Exception();
        }
    }

    @Override
    public void rollback(ParkingSpot parkingSpot) {
        activeTicket.put(ticketId,ticket);
    }
}
