package org.johng.connectedcar.core.shared.services;

import java.util.List;

import org.johng.connectedcar.core.shared.data.entities.Timeslot;

public interface ITimeslotService {
  
  public void createTimeslot(Timeslot timeslot);
  
  public void deleteTimeslot(String dealerId, String serviceDateHour);
  
  public Timeslot getTimeslot(String dealerId, String serviceDateHour);
  
  public List<Timeslot> getTimeslots(String dealerId, String startDate, String endDate);

  public void batchUpdate(List<Timeslot> timeslots);
  
}
