package org.johng.connectedcar.core.shared.services;

import org.johng.connectedcar.core.shared.data.User;

public interface IUserService {
  
  public void createUser(User user);

  public void setPermanentPassword(User user);

}
