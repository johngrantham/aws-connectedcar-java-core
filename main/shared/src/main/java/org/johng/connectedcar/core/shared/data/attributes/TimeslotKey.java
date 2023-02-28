package org.johng.connectedcar.core.shared.data.attributes;

import org.apache.commons.lang3.StringUtils;
import org.johng.connectedcar.core.shared.data.Validatable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeslotKey extends Validatable {

  private String dealerId = null;
  private String serviceDateHour = null;
  
  
  @JsonProperty("dealerId")
  public String getDealerId() {
    return dealerId;
  }

  public void setDealerId(String dealerId) {
    this.dealerId = dealerId;
  }

  @JsonProperty("serviceDateHour")
  public String getServiceDateHour() {
    return serviceDateHour;
  }
  
  public void setServiceDateHour(String serviceDateHour) {
    this.serviceDateHour = serviceDateHour;
  }
  
	@Override
  public boolean validate() {
    return StringUtils.isNotBlank(dealerId) && 
           StringUtils.isNotBlank(serviceDateHour);
  }
}
