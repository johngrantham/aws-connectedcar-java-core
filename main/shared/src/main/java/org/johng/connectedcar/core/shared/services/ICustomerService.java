package org.johng.connectedcar.core.shared.services;

import java.util.List;

import org.johng.connectedcar.core.shared.data.entities.Customer;
import org.johng.connectedcar.core.shared.data.updates.CustomerPatch;

public interface ICustomerService {
  
  public void createCustomer(Customer customer);
  
  public void updateCustomer(CustomerPatch patch);
  
  public void deleteCustomer(String username);
  
  public Customer getCustomer(String username);
  
  public List<Customer> getCustomers(String lastname);

  public void batchUpdate(List<Customer> customers);
  
}
