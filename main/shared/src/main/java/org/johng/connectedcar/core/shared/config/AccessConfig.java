package org.johng.connectedcar.core.shared.config;

public class AccessConfig {

  private String accessKeyId;
  private String secretAccessKey;
  private String sessionToken;
  
  public AccessConfig(String accessKeyId, String secretAccessKey, String sessionToken) {
    this.accessKeyId = accessKeyId;
    this.secretAccessKey = secretAccessKey;
    this.sessionToken = sessionToken;
  }

  public String getAccessKeyId() {
    return accessKeyId;
  }

  public String getSecretAccessKey() {
    return secretAccessKey;
  }

  public String getSessionToken() {
    return sessionToken;
  }
}
