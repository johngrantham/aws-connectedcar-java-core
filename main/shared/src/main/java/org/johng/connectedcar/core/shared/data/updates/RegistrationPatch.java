package org.johng.connectedcar.core.shared.data.updates;

import org.apache.commons.lang3.StringUtils;
import org.johng.connectedcar.core.shared.data.Validatable;
import org.johng.connectedcar.core.shared.data.enums.StatusCodeEnum;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RegistrationPatch extends Validatable {

  private String username = null;
  private String vin = null;
  private StatusCodeEnum statusCode = null;

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

  @JsonProperty("statusCode")
  public StatusCodeEnum getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(StatusCodeEnum statusCode) {
    this.statusCode = statusCode;
  }

  @Override
  public boolean validate() {
    return StringUtils.isNotBlank(username) &&
           StringUtils.isNotBlank(vin);
  }
}
