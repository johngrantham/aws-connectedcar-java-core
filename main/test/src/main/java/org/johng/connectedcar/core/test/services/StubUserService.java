package org.johng.connectedcar.core.test.services;

import org.johng.connectedcar.core.shared.data.User;
import org.johng.connectedcar.core.shared.services.IUserService;

public class StubUserService implements IUserService {

  @Override
  public void createUser(User user) {
    if (user == null || !user.validate())
      throw new IllegalArgumentException();

  }

  public void setPermanentPassword(User user) {
    if (user == null || !user.validate())
      throw new IllegalArgumentException();

  }

  public String authenticate(User user) {
    if (user == null || !user.validate())
      throw new IllegalArgumentException();

    return null;
  }
}
