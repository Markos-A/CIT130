
package Assignments;

import java.util.List;

/**
 *
 * @author markose aycheh
 */
public interface TransportSimulatable {
    
  public void runTransportSimulation(List<TransportVehicle> vList);
  
  public String getSimulationResults();
    
}
