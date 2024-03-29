package org.johng.connectedcar.core.services.data.items;

import org.johng.connectedcar.core.services.data.converters.RegistrationKeyConverter;
import org.johng.connectedcar.core.services.data.converters.TimeslotKeyConverter;
import org.johng.connectedcar.core.shared.data.attributes.RegistrationKey;
import org.johng.connectedcar.core.shared.data.attributes.TimeslotKey;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbConvertedBy;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSecondaryPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSecondarySortKey;

@DynamoDbBean
public class AppointmentItem extends BaseItem {
	
  private String appointmentId = null;
  private TimeslotKey timeslotKey = null;
  private RegistrationKey registrationKey = null;
  
  @DynamoDbAttribute("appointmentId")
  @DynamoDbPartitionKey
  @DynamoDbSecondarySortKey(indexNames = {REGISTRATION_APPOINTMENT_INDEX, TIMESLOT_APPOINTMENT_INDEX})
  public String getAppointmentId() {
    return appointmentId;
  }
  
  public void setAppointmentId(String appointmentId) {
    this.appointmentId = appointmentId;
  }
  
  @DynamoDbAttribute("timeslotKey")
  @DynamoDbSecondaryPartitionKey(indexNames = TIMESLOT_APPOINTMENT_INDEX)
  @DynamoDbConvertedBy(TimeslotKeyConverter.class)
  public TimeslotKey getTimeslotKey() {
    return timeslotKey;
  }

  public void setTimeslotKey(TimeslotKey timeslotKey) {
    this.timeslotKey = timeslotKey;
  }

  @DynamoDbAttribute("registrationKey")
  @DynamoDbSecondaryPartitionKey(indexNames = REGISTRATION_APPOINTMENT_INDEX)
  @DynamoDbConvertedBy(RegistrationKeyConverter.class)
  public RegistrationKey getRegistrationKey() {
    return registrationKey;
  }

  public void setRegistrationKey(RegistrationKey registrationKey) {
    this.registrationKey = registrationKey;
  }
}
