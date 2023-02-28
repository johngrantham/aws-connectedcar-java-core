package org.johng.connectedcar.core.services.context;

import org.johng.connectedcar.core.shared.config.ServiceConfig;

import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.sqs.AmazonSQS;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;

public interface IServiceContext {
  
  public ServiceConfig getConfig();
  
  public AWSCognitoIdentityProvider getCognitoProvider();
  
  public DynamoDbEnhancedClient getDynamoDbClient();

  public AmazonSQS getSQSClient();

}
