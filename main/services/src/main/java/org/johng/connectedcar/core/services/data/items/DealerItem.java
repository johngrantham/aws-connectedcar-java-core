package org.johng.connectedcar.core.services.data.items;

import org.johng.connectedcar.core.services.data.converters.AddressConverter;
import org.johng.connectedcar.core.shared.data.attributes.Address;
import org.johng.connectedcar.core.shared.data.enums.StateCodeEnum;

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbConvertedBy;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@DynamoDbBean
public class DealerItem extends BaseItem {
	
  private String dealerId = null;
  private String name = null;
  private Address address = null;
  private StateCodeEnum stateCode = null;
  
  @DynamoDbAttribute("dealerId")
  @DynamoDbPartitionKey
  public String getDealerId() {
    return dealerId;
  }
  
  public void setDealerId(String dealerId) {
    this.dealerId = dealerId;
  }
  
  @DynamoDbAttribute("name")
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  @DynamoDbAttribute("address")
  @DynamoDbConvertedBy(AddressConverter.class)
  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }
  
  @DynamoDbAttribute("stateCode")
  public StateCodeEnum getStateCode() {
    return stateCode;
  }

  public void setStateCode(StateCodeEnum stateCode) {
    this.stateCode = stateCode;
  }
}
