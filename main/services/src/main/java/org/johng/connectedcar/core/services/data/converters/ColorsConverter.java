package org.johng.connectedcar.core.services.data.converters;

import org.johng.connectedcar.core.shared.data.attributes.Colors;

import com.fasterxml.jackson.databind.ObjectMapper;

import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class ColorsConverter implements AttributeConverter<Colors> {

  @Override
  public AttributeValue transformFrom(Colors input) {
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
  public Colors transformTo(AttributeValue input) {
    try {
      ObjectMapper mapper = new ObjectMapper();
      return mapper.readValue(input.s(), Colors.class);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    
    return null;
  }

  @Override
  public EnhancedType<Colors> type() {
    return EnhancedType.of(Colors.class);
  }

  @Override
  public AttributeValueType attributeValueType() {
    return AttributeValueType.S;
  }
}
