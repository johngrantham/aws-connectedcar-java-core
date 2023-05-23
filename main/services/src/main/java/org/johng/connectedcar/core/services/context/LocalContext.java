package org.johng.connectedcar.core.services.context;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.johng.connectedcar.core.shared.config.AccessConfig;
import org.johng.connectedcar.core.shared.config.CognitoConfig;
import org.johng.connectedcar.core.shared.config.DynamoConfig;
import org.johng.connectedcar.core.shared.config.SQSConfig;
import org.johng.connectedcar.core.shared.config.ServiceConfig;

import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;

public class LocalContext extends BaseContext implements IServiceContext {

  private ServiceConfig serviceConfig = null;
  private AWSCognitoIdentityProvider cognitoProvider = null;
  private DynamoDbEnhancedClient dynamoDbClient = null;
  private AmazonSQS sqsClient = null;

  public ServiceConfig getConfig() {
    if (serviceConfig == null) {
      Properties properties = getProperties();
      
      ServiceConfig config = new ServiceConfig(
          properties.getProperty(REGION),
          new AccessConfig(
              properties.getProperty(ACCESS_KEY_ID),
              properties.getProperty(SECRET_ACCESS_KEY),
              properties.getProperty(SESSION_TOKEN)),
          new CognitoConfig(
              properties.getProperty(USER_POOL_ID),
              properties.getProperty(CLIENT_ID),
              properties.getProperty(CLIENT_SECRET)),
          new DynamoConfig(
              properties.getProperty(DEALER_TABLE_NAME),
              properties.getProperty(TIMESLOT_TABLE_NAME),
              properties.getProperty(APPOINTMENT_TABLE_NAME),
              properties.getProperty(CUSTOMER_TABLE_NAME),
              properties.getProperty(REGISTRATION_TABLE_NAME),
              properties.getProperty(VEHICLE_TABLE_NAME),
              properties.getProperty(EVENT_TABLE_NAME)),
            new SQSConfig(
              properties.getProperty(USER_QUEUE_URL)));

      serviceConfig = config;
    }

    return serviceConfig;
  }

  public synchronized AWSCognitoIdentityProvider getCognitoProvider() {
    if (cognitoProvider == null) {
	    AWSCredentials credentials = new BasicSessionCredentials(
	        getConfig().getAccessConfig().getAccessKeyId(), 
	        getConfig().getAccessConfig().getSecretAccessKey(),
          getConfig().getAccessConfig().getSessionToken());
	    
	    AWSCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider(credentials);
	    
	    AWSCognitoIdentityProvider provider = AWSCognitoIdentityProviderClientBuilder.standard()
	        .withCredentials(credentialsProvider)
	        .withRegion(getConfig().getRegion())
	        .build();

      cognitoProvider = provider;
    }

    return cognitoProvider;
  }

  public synchronized DynamoDbEnhancedClient getDynamoDbClient() {
    if (dynamoDbClient == null) {
      StaticCredentialsProvider provider = StaticCredentialsProvider.create(
        AwsSessionCredentials.create(
          getConfig().getAccessConfig().getAccessKeyId(),
          getConfig().getAccessConfig().getSecretAccessKey(),
          getConfig().getAccessConfig().getSessionToken()));

      DynamoDbClient ddb = DynamoDbClient.builder()
        .credentialsProvider(provider)
        .region(Region.of(getConfig().getRegion()))
        .httpClient(UrlConnectionHttpClient.builder().build())
        .build();        
      
      DynamoDbEnhancedClient client = DynamoDbEnhancedClient
        .builder()
        .dynamoDbClient(ddb)
        .build();
        
      dynamoDbClient = client;
    }

    return dynamoDbClient;
  }

  public synchronized AmazonSQS getSQSClient() {
    if (sqsClient == null)
    {
	    AWSCredentials credentials = new BasicSessionCredentials(
	        getConfig().getAccessConfig().getAccessKeyId(), 
	        getConfig().getAccessConfig().getSecretAccessKey(),
          getConfig().getAccessConfig().getSessionToken());
	    
	    AWSCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider(credentials);

      AmazonSQS client = AmazonSQSClientBuilder.standard()
        .withCredentials(credentialsProvider)
        .withRegion(getConfig().getRegion())
        .build(); 
        
      sqsClient = client;
    }

    return sqsClient;
  }
  
  private Properties getProperties() {
    final String FILE = "config.properties";
    
    Properties props = new Properties();
    InputStream stream = null;
    
    try {
      stream = getClass().getClassLoader().getResourceAsStream(FILE);
      
      if (stream != null) {
        props.load(stream);
      }
      else {
        throw new FileNotFoundException(FILE);
      }
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      if (stream != null) {
        try {
          stream.close();
        }
        catch (Exception ignore) {}
      }
    }

    return props;
  }
}
