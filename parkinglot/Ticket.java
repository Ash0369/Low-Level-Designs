package parkinglot;

import parkinglot.parking.ParkingSpot;
import parkinglot.vehicle.Vehicle;

import java.util.Date;

public class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final long entryTimeStamp;
    private long exitTimeStamp;
    private final ParkingSpot parkingSpot;

    public long getExitTimeStamp() {
        return exitTimeStamp;
    }

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.entryTimeStamp = new Date().getTime();
        this.parkingSpot = parkingSpot;
    }

    public void setExitTimeStamp(){
        this.exitTimeStamp = new Date().getTime();
    }

    public ParkingSpot getParkingSpot(){
        return parkingSpot;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public long getEntryTimeStamp() {
        return entryTimeStamp;
    }
}
