package org.johng.connectedcar.core.shared.data.updates;

import org.apache.commons.lang3.StringUtils;
import org.johng.connectedcar.core.shared.data.Validatable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerPatch extends Validatable {

  private String username = null;
  private String phoneNumber = null;

  @JsonProperty("username")
  public String getUsername() {
    return username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  @JsonProperty("phoneNumber")
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public boolean validate() {
    return StringUtils.isNotBlank(username) &&
           StringUtils.isNotBlank(phoneNumber);
  }
}
