package org.johng.connectedcar.core.services;

import com.google.inject.Inject;

import org.johng.connectedcar.core.services.context.IServiceContext;
import org.johng.connectedcar.core.services.translator.ITranslator;
import org.johng.connectedcar.core.shared.data.User;
import org.johng.connectedcar.core.shared.services.IMessageService;

import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MessageService extends BaseService implements IMessageService {

  @Inject
  public MessageService(IServiceContext serviceContext, ITranslator translatorService) {
    super(serviceContext, translatorService);
  }
  
  @Override
  public void sendCreateUser(User user) {
    if (user == null || !user.validate())
      throw new IllegalArgumentException();

    try {
      String urn = getServiceContext().getConfig().getSqsConfig().getUserQueueUrl();

      String message = new ObjectMapper().writeValueAsString(user);

      SendMessageRequest request = new SendMessageRequest()
        .withQueueUrl(urn)
        .withMessageBody(message);

      getServiceContext().getSQSClient().sendMessage(request);
    }
    catch (Exception e) {
      throw new IllegalArgumentException(e);
    }
  }
}
