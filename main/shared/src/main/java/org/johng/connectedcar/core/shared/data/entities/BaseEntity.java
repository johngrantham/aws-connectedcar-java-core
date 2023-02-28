package org.johng.connectedcar.core.shared.data.entities;

import java.time.LocalDateTime;

import org.johng.connectedcar.core.shared.data.Validatable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class BaseEntity extends Validatable {

  public final static String DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

  protected LocalDateTime createDateTime = null;
  protected LocalDateTime updateDateTime = null;

  @JsonProperty("createDateTime")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_FORMAT)
  public LocalDateTime getCreateDateTime() {
    return createDateTime;
  }
  
  public void setCreateDateTime(LocalDateTime createDateTime) {
    this.createDateTime = createDateTime;
  }
  
  @JsonProperty("updateDateTime")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_FORMAT)
  public LocalDateTime getUpdateDateTime() {
    return updateDateTime;
  }
  
  public void setUpdateDateTime(LocalDateTime updateDateTime) {
    this.updateDateTime = updateDateTime;
  }
}
