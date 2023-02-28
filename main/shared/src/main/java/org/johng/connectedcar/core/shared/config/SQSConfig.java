package org.johng.connectedcar.core.shared.config;

public class SQSConfig {

  private String UserQueueUrl;

  public SQSConfig(String UserQueueUrl) {
    this.UserQueueUrl = UserQueueUrl;
  }

  public String getUserQueueUrl() {
    return UserQueueUrl;
  }
}
