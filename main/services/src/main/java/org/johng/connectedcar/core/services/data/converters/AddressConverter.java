package org.johng.connectedcar.core.services.data.converters;

import org.johng.connectedcar.core.shared.data.attributes.Address;

import com.fasterxml.jackson.databind.ObjectMapper;

import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class AddressConverter implements AttributeConverter<Address> {

  @Override
  public AttributeValue transformFrom(Address input) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      return AttributeValue.builder().s(mapper.writeValueAsString(input)).build();
    } 
    catch (Exception e) {
      e.printStackTrace();
    }
    
    return null;
  }

  @Override
  public Address transformTo(AttributeValue input) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.readValue(input.s(), Address.class);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    
    return null;
  }

  @Override
  public EnhancedType<Address> type() {
    return EnhancedType.of(Address.class);
  }

  @Override
  public AttributeValueType attributeValueType() {
    return AttributeValueType.S;
  }
}
