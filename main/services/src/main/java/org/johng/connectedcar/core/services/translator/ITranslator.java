package org.johng.connectedcar.core.services.translator;

import org.johng.connectedcar.core.services.data.items.AppointmentItem;
import org.johng.connectedcar.core.services.data.items.CustomerItem;
import org.johng.connectedcar.core.services.data.items.DealerItem;
import org.johng.connectedcar.core.services.data.items.EventItem;
import org.johng.connectedcar.core.services.data.items.RegistrationItem;
import org.johng.connectedcar.core.services.data.items.TimeslotItem;
import org.johng.connectedcar.core.services.data.items.VehicleItem;
import org.johng.connectedcar.core.shared.data.entities.Appointment;
import org.johng.connectedcar.core.shared.data.entities.Customer;
import org.johng.connectedcar.core.shared.data.entities.Dealer;
import org.johng.connectedcar.core.shared.data.entities.Event;
import org.johng.connectedcar.core.shared.data.entities.Registration;
import org.johng.connectedcar.core.shared.data.entities.Timeslot;
import org.johng.connectedcar.core.shared.data.entities.Vehicle;

public interface ITranslator {
  
  public Appointment translate(AppointmentItem item);
  public AppointmentItem translate(Appointment appointment);

  public Customer translate(CustomerItem item);
  public CustomerItem translate(Customer customer);

  public Dealer translate(DealerItem item);
  public DealerItem translate(Dealer dealer);

  public Event translate(EventItem item);
  public EventItem translate(Event event);

  public Registration translate(RegistrationItem item);
  public RegistrationItem translate(Registration registration);

  public Timeslot translate(TimeslotItem item);
  public TimeslotItem translate(Timeslot timeslot);

  public Vehicle translate(VehicleItem item);
  public VehicleItem translate(Vehicle vehicle);

}
