package parkinglot.parking;

import parkinglot.vehicle.Vehicle;
import parkinglot.vehicle.VehicleType;

public class ParkingSpot {
    private final VehicleType vehicleType;
    boolean isOccupied;
    private final int spotNumber;
    private Vehicle vehicle;

    public ParkingSpot(VehicleType vehicleType, int spotNumber) {
        this.vehicleType = vehicleType;
        this.spotNumber = spotNumber;
        this.isOccupied = false;
    }

    public synchronized boolean isSpotAvailable(VehicleType vehicleType){
        if(this.vehicleType!= vehicleType){
            return false;
        }
        return !isOccupied;
    }

    public synchronized boolean park(Vehicle vehicle){
        if(!isOccupied && vehicle.getVehicleType()!= vehicleType){
            return false;
        }
        this.vehicle = vehicle;
        isOccupied = true;
        return true;
    }

    public synchronized void unPark(){
        vehicle = null;
        isOccupied = false;
    }

    public int getSpotNumber(){
        return spotNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public boolean getIsOcuppied(){
        return isOccupied;
    }
}
