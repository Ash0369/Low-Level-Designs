package parkinglot.parking;

import parkinglot.vehicle.VehicleType;

import java.util.List;
import java.util.Optional;

public class ParkingFloor {
    private final int floorNumber;
    private List<ParkingSpot> parkingSpot;

    public ParkingFloor(int floorNumber, List<ParkingSpot> parkingSpot) {
        this.floorNumber = floorNumber;
        this.parkingSpot = parkingSpot;
    }

    //Optional is better way of null handling
    public synchronized Optional<ParkingSpot> isSpotAvaialble(VehicleType vehicleType){
        for (ParkingSpot spot : parkingSpot) {
            if (spot.isSpotAvailable(vehicleType)) {
                return Optional.of(spot);
            }
        }
        return Optional.empty();
    }

    public void displayFloor(){
        System.out.println("Spot Number     Type   Ocuppied");
        for(ParkingSpot p : parkingSpot){
            System.out.print(p.getSpotNumber());
            System.out.print(" ");
            System.out.print(p.getVehicleType());
            System.out.print(" ");
            System.out.println(p.getIsOcuppied());
        }
    }


    public int getFloorNumber() {
        return floorNumber;
    }
}
