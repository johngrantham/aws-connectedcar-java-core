package org.johng.connectedcar.core.shared.data.attributes;

import org.apache.commons.lang3.StringUtils;
import org.johng.connectedcar.core.shared.data.Validatable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegistrationKey extends Validatable {

  private String username = null;
  private String vin = null;
  
  
  @JsonProperty("username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @JsonProperty("vin")
  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }

	@Override
  public boolean validate() {
    return StringUtils.isNotBlank(username) && 
           StringUtils.isNotBlank(vin);
  }
}
