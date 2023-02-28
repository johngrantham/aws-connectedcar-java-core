package org.johng.connectedcar.core.shared.orchestrators;

import java.util.ArrayList;
import java.util.List;

import org.johng.connectedcar.core.shared.data.entities.Appointment;
import org.johng.connectedcar.core.shared.data.entities.Event;
import org.johng.connectedcar.core.shared.data.entities.Registration;
import org.johng.connectedcar.core.shared.data.entities.Vehicle;
import org.johng.connectedcar.core.shared.services.IAppointmentService;
import org.johng.connectedcar.core.shared.services.IEventService;
import org.johng.connectedcar.core.shared.services.IRegistrationService;
import org.johng.connectedcar.core.shared.services.IVehicleService;

import com.google.inject.Inject;

public class CustomerOrchestrator implements ICustomerOrchestrator {

  private IRegistrationService registrationService;
  private IAppointmentService appointmentService;
  private IVehicleService vehicleService;
  private IEventService eventService;

  @Inject
  public CustomerOrchestrator(
      IRegistrationService registrationService,
      IAppointmentService appointmentService,
      IVehicleService vehicleService,
      IEventService eventService) {

    this.registrationService = registrationService;
    this.appointmentService = appointmentService;
    this.vehicleService = vehicleService;
    this.eventService = eventService;
  }

  public String createAppointment(String username, Appointment appointment) {
    Registration registration = registrationService.getRegistration(username, appointment.getRegistrationKey().getVin());

    if (registration != null) {
        appointment.getRegistrationKey().setUsername(username);
        return appointmentService.createAppointment(appointment);
    }

    return null;
  }

  public Vehicle getVehicle(String username, String vin) {
    Registration registration = registrationService.getRegistration(username, vin);

    if (registration != null) {
      return vehicleService.getVehicle(registration.getVin());
    }

    return null;
  }

  public List<Event> getEvents(String username, String vin) {
    Registration registration = registrationService.getRegistration(username, vin);
    List<Event> events = new ArrayList<Event>();

    if (registration != null) {
      events.addAll(eventService.getEvents(registration.getVin()));
    }

    return events;
  }
}
