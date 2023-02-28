package org.johng.connectedcar.core.shared.orchestrators;

import org.johng.connectedcar.core.shared.data.updates.CustomerProvision;

public interface IAdminOrchestrator {

  public void createCustomer(CustomerProvision provision);

  public void createCustomerUsingMessage(CustomerProvision provision);

}