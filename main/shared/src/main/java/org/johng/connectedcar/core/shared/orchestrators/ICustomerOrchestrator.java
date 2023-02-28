package org.johng.connectedcar.core.shared.orchestrators;

import java.util.List;

import org.johng.connectedcar.core.shared.data.entities.Appointment;
import org.johng.connectedcar.core.shared.data.entities.Event;
import org.johng.connectedcar.core.shared.data.entities.Vehicle;

public interface ICustomerOrchestrator {

  public String createAppointment(String username, Appointment appointment);

  public Vehicle getVehicle(String username, String vin);

  public List<Event> getEvents(String username, String vin);

}