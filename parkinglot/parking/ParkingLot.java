package parkinglot.parking;

import jdk.jshell.execution.Util;
import parkinglot.Ticket;
import parkinglot.fee.FeeStrategy;
import parkinglot.fee.WeekendDiscountFees;
import parkinglot.parkingcommand.ParkVehicleCommand;
import parkinglot.parkingcommand.UnParkVehicleCommand;
import parkinglot.vehicle.Vehicle;
import parkinglot.vehicle.VehicleType;

import javax.swing.text.Utilities;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

//We need to have only single instance of parking lot so we will use singleton design pattern
public class ParkingLot {
    private static ParkingLot parkingLotinstance;
    private final List<ParkingFloor> floor;
    private final Map<String, Ticket> activeTickets = new ConcurrentHashMap<>();
    private FeeStrategy feeStrategy;

    private ParkingLot(){
        floor = new ArrayList<>();
        feeStrategy = new WeekendDiscountFees();
    }

    public static synchronized ParkingLot getInstance(){
        if(parkingLotinstance == null){
            parkingLotinstance = new ParkingLot();
        }
        return parkingLotinstance;
    }

    public void addFloor(ParkingFloor parkingFloor){
        floor.add(parkingFloor);
    }

    public List<ParkingFloor> getParkingFloors(){
        return floor;
    }

    public synchronized Ticket parkVehicle(Vehicle vehicle) throws Exception {
        Optional<ParkingSpot> parkingSpot = getAvailableSpot(vehicle.getVehicleType());
        if(parkingSpot.isEmpty()){
            System.out.println("No Parking Spots Available at the Moment");
            throw new Exception("No parking spots");
        } else {
            //Park the Vehicle
            ParkVehicleCommand command = new ParkVehicleCommand(vehicle, activeTickets);
            Optional<Ticket> ticket = command.execute(parkingSpot.get());
            if(ticket.isPresent()){
                return ticket.get();
            }
            else{
                throw new Exception("No parking spots");
            }
        }
    }

    public synchronized double unPark(String ticketId) throws Exception {
        if(activeTickets.get(ticketId) == null){
            System.out.println("Invalid ticket id");
            throw new Exception();
        }
        UnParkVehicleCommand command = new UnParkVehicleCommand(activeTickets, ticketId);
        Optional<Ticket> ticket = command.execute(activeTickets.get(ticketId).getParkingSpot());

        if(ticket.isPresent()) {
            return feeStrategy.calculateFees(ticket.get());
        } else{
            throw new Exception();
        }


    }

    public synchronized Optional<ParkingSpot> getAvailableSpot(VehicleType vehicleType) {
        for(ParkingFloor parkingFloor : floor){
            Optional<ParkingSpot> parkingSpot = parkingFloor.isSpotAvaialble(vehicleType);
            if(parkingSpot.isPresent()){
                return parkingSpot;
            }
        }
        return Optional.empty();
    }

    public void displayPakringLot() {
        int floors = floor.size();
        System.out.println("There are "+ floors + " floors");
        for(ParkingFloor p : floor){
            System.out.println("Displaying " + p.getFloorNumber()+ " floor");
            p.displayFloor();
        }
    }

    public void setFeeStrategy (FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }
}
