package org.johng.connectedcar.core.shared.data.entities;

import org.johng.connectedcar.core.shared.data.attributes.RegistrationKey;
import org.johng.connectedcar.core.shared.data.attributes.TimeslotKey;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Appointment extends BaseEntity {
	
  private String appointmentId = null;
  private TimeslotKey timeslotKey = null;
  private RegistrationKey registrationKey = null;
  
  @JsonProperty("appointmentId")
  public String getAppointmentId() {
    return appointmentId;
  }
  
  public void setAppointmentId(String appointmentId) {
    this.appointmentId = appointmentId;
  }
  
  @JsonProperty("timeslotKey")
  public TimeslotKey getTimeslotKey() {
    return timeslotKey;
  }

  public void setTimeslotKey(TimeslotKey timeslotKey) {
    this.timeslotKey = timeslotKey;
  }

  @JsonProperty("registrationKey")
  public RegistrationKey getRegistrationKey() {
    return registrationKey;
  }

  public void setRegistrationKey(RegistrationKey registrationKey) {
    this.registrationKey = registrationKey;
  }

  public boolean validate() {
    return timeslotKey != null && timeslotKey.validate() &&
           registrationKey != null && registrationKey.validate();	
  }
}
