
package Assignments;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author markosea ycheh
 */
public class DemoLargeObjectList {
    public static void main(String[] args) {
        
        TransportationSimulator simulator = new TransportationSimulator();
        // our simulator needs a list of TransportationVehicles
        // so let's make a bunch!!
        
        List<TransportVehicle> bigXportList = new LinkedList<>();
        
        for(int c = 0; c < 100;c++){
            TransportVehicle tv = new TransportVehicle();
            Random r = new Random();
            // randomly set passenger count
            tv.setPassengerCount(r.nextInt(201));
            // set a call sign
            tv.setCallSign("Veh no." + String.valueOf(c));
            // throw it into our list
            bigXportList.add(tv);
            
        } // close for
        
        // send in big list to our simulator
        simulator.runTransportSimulation(bigXportList);
        System.out.println(simulator.getSimulationResults());
        
        
    } // close main
    
}
