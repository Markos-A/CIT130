/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignments;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author markose aycheh
 */
public class TransportSaftySimulator {
    
   public static void main(String[] args) {
        // Source location with X number
        // of humans who want to get to 
        // destination: use modeling
        // and random generation to simulate
        // moving folks from source to dest
        // on a variety of modes of transport
        // and compute metrics for cost and
        // time and injury rates based on
        // member variable values on our 
        // transportation objects
        
        // DEMO of the principle that
        // a variable typed to the superclass
        // can hold ANY Subtyped object!!
        
        TransportVehicle vehicle1 = new TransportVehicle();
        vehicle1.setAverageSpeed(80);
        
        Bus amtrak1 = new Bus();                
        // calling a setter method on the superclass (TransportVehicle)
        amtrak1.setAverageSpeed(65.0);     
        amtrak1.setPassengerCount(70);
        
        double BusTime = computeTravelTime(amtrak1, 60.30);
        System.out.println("Travel time of Bus from Pittsburgh to Philadelphia: " + BusTime + " hours");
        
        
        
        
        // test our subclasses of Automobile
        RaceCar ferrari250GTCoupe = new RaceCar();
        ferrari250GTCoupe.setAverageSpeed(142.9);
        ferrari250GTCoupe.setCallSign("Ferrari250");
        ferrari250GTCoupe.setPassengerCount(2);
        double raceCarTime = computeTravelTime(ferrari250GTCoupe, 808);
        
        
        ferrari250GTCoupe.setWheelBaseInches(60.3);
        System.out.println("Travel time in race car from PGH to Rochster, MN: " + raceCarTime);   
        
        // ************* STORE OUR OBJECTS IN A LIST<> *******************
        // vehicleList is typed as List and can hold objects of type TransportVehicle
        // but more importantly, it can also hold ANY subtype. 
        // DESIGN PRINCIPLE: CODE TO SUPERCLASS WHEN POSSIBLE
        // vehicleList is typed to the List interface, and I store inside it
        // a concrete implemenation of List called LinkedLiset
        List<TransportVehicle> vehicleList = new LinkedList<>();
        
        //  load up our custom objects into our list
        // ANY SUBCLASS can be added to a list typed to hold 
        // the parent
        
        vehicleList.add(ferrari250GTCoupe);
        
        // send list down to our passenger tabulator and print returned result
        int pTotal = computeTotalPassengerCount(vehicleList);
        System.out.println("Total Passengers: " + pTotal);
        
        // A more specific storage container, that could be used
        // to queue vehicles for road transport
//        List<Automobile> autoList = new ArrayList<>();
//        autoList.add(ferrari250GTCoupe);
    } 
    
    
    /**
     * Tabulates total passenger count of each Object in our list
     * @param vList preferably with a non-zero pasenger count. If you
     * give me null, I return zero passegers
     * @return total passengers in all passed in TransportVehicles
     */
    public static int computeTotalPassengerCount(List<TransportVehicle> vList){
        
        int passTotal = 0;
        // Only examine elements if we actually have a list and that list
        // is NOT empty (!)
        if(vList != null && !vList.isEmpty()){
            // Use Enhanced for Loop to visit each item individually
            // This says, serve me once TransportVehicle at a time, 
            // and do so by sticking it in the variable called v
            // which I can look at more closely inside the for loop
            for(TransportVehicle v: vList){
                System.out.println("***************************************");
                System.out.println("Examining Vehicle: " + v.getCallSign());
                System.out.println("Passenger Count: " + v.getPassengerCount());
                passTotal = passTotal + v.getPassengerCount();
            } // enhanced for loop
        }
        
        return passTotal;
    }
    
    
    
    
    /**
     * 
     * method to compute time required for a given TransportationVehicle
     * to travel X miles
     * This method's signature uses the principle of polymorphism in that
     * we accept any class which has TransportVehicle in its ancestry
     * i.e. is a subclass of TransportVehicle
     * @param vehicle ANY subclass of TransportVehicle
     * @param distance
     * @return 
     */
    public static double computeTravelTime(TransportVehicle vehicle, double distance){
        // distance = rate * time
        // time = distance / rate
        
        
        // Demo the use of the instanceof operator and type casting
        // to resurrect our subclass object
        // attempt to type cast our inputted vehicle to the subclass Van
 
        
        // Step 1 is determine which subclass we actually have using instanceof
        if(vehicle instanceof RaceCar){
            System.out.println("Ooh, I was passed a RaceCar subclass!");
            // store a reference to our RaceCar in an appropriately typed
            // variable that gives us access to the subclass's public utilities
            // (RaceCar) is type casting, forcing the object to its right
            // to become typed as the value in the ()
            RaceCar racer = (RaceCar) vehicle;
            System.out.println("WheelBase measurement: " + racer.getWheelBaseInches());
        } else if(vehicle instanceof Bus){
            System.out.println("Riding a Bus is awesome!");            
        }
        
        
        return distance / vehicle.getAvergageSpeed();
        
        
    }
    
}  

