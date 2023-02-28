package org.johng.connectedcar.core.shared.data.entities;

import org.apache.commons.lang3.StringUtils;
import org.johng.connectedcar.core.shared.data.attributes.Colors;
import org.johng.connectedcar.core.shared.data.enums.VehicleCodeEnum;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vehicle extends BaseEntity {

  private String vin = null;
  private Colors colors = null;
  private String vehiclePin = null;
  private VehicleCodeEnum vehicleCode = null;

  @JsonProperty("vin")
  public String getVin() {
    return vin;
  }

  public void setVin(String vin) {
    this.vin = vin;
  }
  
  @JsonProperty("colors")
  public Colors getColors() {
    return colors;
  }

  public void setColors(Colors colors) {
    this.colors = colors;
  }

  @JsonProperty("vehiclePin")
  public String getVehiclePin() {
    return vehiclePin;
  }

  public void setVehiclePin(String vehiclePin) {
    this.vehiclePin = vehiclePin;
  }
    
  @JsonProperty("vehicleCode")
  public VehicleCodeEnum getVehicleCode() {
    return vehicleCode;
  }

  public void setVehicleCode(VehicleCodeEnum vehicleCode) {
    this.vehicleCode = vehicleCode;
  }

  @Override
  public boolean validate() {
    return StringUtils.isNotBlank(vin) &&
           StringUtils.isNotBlank(vehiclePin) &&
           colors != null && colors.validate() &&
           vehicleCode != null;
  }
}
