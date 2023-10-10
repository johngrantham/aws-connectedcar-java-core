package org.johng.connectedcar.core.services.data.items;

import org.johng.connectedcar.core.shared.data.enums.EventCodeEnum;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@DynamoDbBean
public class EventItem extends BaseItem {
	
  private String vin = null;
  private Long timestamp = null;
  private EventCodeEnum eventCode = null;

  @DynamoDbAttribute("vin")
  @DynamoDbPartitionKey
  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }

  @DynamoDbAttribute("timestamp")
  @DynamoDbSortKey
  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  @DynamoDbAttribute("eventCode")
  public EventCodeEnum getEventCode() {
    return eventCode;
  }

  public void setEventCode(EventCodeEnum eventCode) {
    this.eventCode = eventCode;
  }
}
