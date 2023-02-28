package org.johng.connectedcar.core.test.services;

import org.johng.connectedcar.core.shared.data.User;
import org.johng.connectedcar.core.shared.services.IMessageService;

public class StubMessageService implements IMessageService {

  @Override
  public void sendCreateUser(User user) {
    if (user == null || !user.validate())
      throw new IllegalArgumentException();

  }
}
