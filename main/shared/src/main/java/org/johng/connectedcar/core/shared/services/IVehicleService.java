package org.johng.connectedcar.core.shared.services;

import java.util.List;

import org.johng.connectedcar.core.shared.data.entities.Vehicle;

public interface IVehicleService {
  
  public void createVehicle(Vehicle vehicle);
  
  public void deleteVehicle(String vin);
  
  public Vehicle getVehicle(String vin);
  
  public boolean validatePin(String vin, String vehiclePin);

  public void batchUpdate(List<Vehicle> timeslots);

}
