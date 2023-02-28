package org.johng.connectedcar.core.shared.services;

import java.util.List;

import org.johng.connectedcar.core.shared.data.entities.Event;

public interface IEventService {
  
  public void createEvent(Event event);
  
  public void deleteEvent(String vin, long timestamp);

  public Event getEvent(String vin, long timestamp);

  public List<Event> getEvents(String vin);

}
