package org.johng.connectedcar.core.shared.orchestrators;

import org.johng.connectedcar.core.shared.data.User;
import org.johng.connectedcar.core.shared.data.entities.Customer;
import org.johng.connectedcar.core.shared.data.updates.CustomerProvision;
import org.johng.connectedcar.core.shared.services.ICustomerService;
import org.johng.connectedcar.core.shared.services.IMessageService;
import org.johng.connectedcar.core.shared.services.IUserService;

import com.google.inject.Inject;

public class AdminOrchestrator implements IAdminOrchestrator {

  private ICustomerService customerService;
  private IMessageService messageService;
  private IUserService userService;

  @Inject
  public AdminOrchestrator(
      ICustomerService customerService,
      IMessageService messageService,
      IUserService userService) {

    this.customerService = customerService;
    this.userService = userService;
    this.messageService = messageService;
  }

  public void createCustomer(CustomerProvision provision) {   
      Customer customer = new Customer();

      customer.setUsername(provision.getUsername());
      customer.setFirstname(provision.getFirstname());
      customer.setLastname(provision.getLastname());
      customer.setPhoneNumber(provision.getPhoneNumber());

      customerService.createCustomer(customer);

      User user = new User();

      user.setUsername(provision.getUsername());
      user.setPassword(provision.getPassword());
      
      userService.createUser(user);
  }

  public void createCustomerUsingMessage(CustomerProvision provision) {
      Customer customer = new Customer();

      customer.setUsername(provision.getUsername());
      customer.setFirstname(provision.getFirstname());
      customer.setLastname(provision.getLastname());
      customer.setPhoneNumber(provision.getPhoneNumber());

      customerService.createCustomer(customer);

      User user = new User();

      user.setUsername(provision.getUsername());
      user.setPassword(provision.getPassword());

      messageService.sendCreateUser(user);
  }
  
}
