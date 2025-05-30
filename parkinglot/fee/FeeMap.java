package parkinglot.fee;

import parkinglot.vehicle.VehicleType;

public class FeeMap {

    double getCost(VehicleType vehicleType) {
        if(vehicleType.equals(VehicleType.BIKE)){
            return 1000;
        }
        else if(vehicleType.equals(VehicleType.CAR)){
            return 5000;
        }
        else{
            return 10000;
        }
    }
}
