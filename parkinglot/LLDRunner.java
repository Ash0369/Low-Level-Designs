package parkinglot;

import parkinglot.parking.ParkingFloor;
import parkinglot.parking.ParkingLot;
import parkinglot.parking.ParkingSpot;
import parkinglot.vehicle.*;

import java.util.ArrayList;
import java.util.Scanner;

public class LLDRunner {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Parking Lot Design");

        ParkingLot parkingLot = ParkingLot.getInstance();

        System.out.println("Please Enter Number of Floors");

        int floor = scanner.nextInt();

        System.out.println("For each floor provide number of parking spots and type of spot");

        for(int i=0;i<floor;i++){
            ArrayList<ParkingSpot> parkingFloorList = new ArrayList<>();
            System.out.println("Enter number of parking spot for "+(i+1));
            int number = scanner.nextInt();
            for(int j=1;j<=number;j++){
                System.out.println("Enter number of "+ j +" spot");
                int spotnumber = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Enter type of "+ j +" spot");
                String type = scanner.nextLine();
                if("bike".equalsIgnoreCase(type)){
                    parkingFloorList.add(new ParkingSpot(VehicleType.BIKE,spotnumber));
                }
                else if("car".equalsIgnoreCase(type)){
                    parkingFloorList.add(new ParkingSpot(VehicleType.CAR,spotnumber));
                }
                else if("truck".equalsIgnoreCase(type)){
                    parkingFloorList.add(new ParkingSpot(VehicleType.TRUCK,spotnumber));
                }
                else{
                    System.out.println("Not supported");
                    throw new RuntimeException();
                }
            }
            ParkingFloor parkingFloor = new ParkingFloor(i+1,parkingFloorList);
            parkingLot.addFloor(parkingFloor);
        }

        System.out.println("-----------------------------------");
        parkingLot.displayPakringLot();
        System.out.println("------------------------------------");


        while (true){
            System.out.println("If you want to park your vehicle enter 1 if unpark then 2 else 3");
            int val = scanner.nextInt();
            scanner.nextLine();

            if(val==3){
                throw new RuntimeException();
            }

            if(val==1){
                //Park the vehicle
                System.out.println("Please Enter vehicle number");
                String licence = scanner.nextLine();
                System.out.println("Please enter type");
                String vehicleType = scanner.nextLine();

                if("bike".equalsIgnoreCase(vehicleType)){
                    Vehicle v = new Bike(licence);
                    System.out.println(parkingLot.parkVehicle(v).getTicketId());

                }
                else if("car".equalsIgnoreCase(vehicleType)){
                    Vehicle v = new Car(licence);
                    System.out.println(parkingLot.parkVehicle(v).getTicketId());
                }
                else if("truck".equalsIgnoreCase(vehicleType)){
                    Vehicle v = new Truck(licence);
                    System.out.println(parkingLot.parkVehicle(v).getTicketId());
                }
                else{
                    System.out.println("Not supported this type");
                    throw new RuntimeException();
                }
                System.out.println("Successfully parked");
                System.out.println("-----------------------------------");
                parkingLot.displayPakringLot();
                System.out.println("-----------------------------------");
            }
            else{
                //un park
                System.out.println("Enter Ticket Id");
                String ticketId = scanner.nextLine();
                double cost = parkingLot.unPark(ticketId);
                System.out.println("Unparked the vehicle");
                System.out.println("Pay "+ cost+ " rupees");
                System.out.println("-----------------------------------");
                parkingLot.displayPakringLot();
                System.out.println("-----------------------------------");

            }
        }

    }
}
