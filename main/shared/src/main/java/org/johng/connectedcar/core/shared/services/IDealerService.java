package org.johng.connectedcar.core.shared.services;

import java.util.List;

import org.johng.connectedcar.core.shared.data.entities.Dealer;
import org.johng.connectedcar.core.shared.data.enums.StateCodeEnum;

public interface IDealerService {
  
  public String createDealer(Dealer dealer);
  
  public void deleteDealer(String dealerId);
  
  public Dealer getDealer(String dealerId);
  
  public List<Dealer> getDealers(StateCodeEnum stateCode);
  
}
