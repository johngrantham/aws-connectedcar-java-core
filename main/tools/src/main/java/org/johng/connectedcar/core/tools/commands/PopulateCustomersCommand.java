package org.johng.connectedcar.core.tools.commands;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;
import org.johng.connectedcar.core.shared.data.entities.Customer;
import org.johng.connectedcar.core.shared.data.entities.Registration;
import org.johng.connectedcar.core.shared.data.entities.Vehicle;
import org.johng.connectedcar.core.tools.data.CustomerData;

public class PopulateCustomersCommand extends BaseCommand {

  public void execute() {
    File folder = new File(CUSTOMERS_FILE_PATH);
    File[] files = folder.listFiles();

    for (File file : files) {
      populateCustomers(file);
    }
  }

  private void populateCustomers(File file)
  {
    List<CustomerData> results = readCustomerData(file);
    List<List<CustomerData>> batches = Lists.partition(results, 20);

    batches.parallelStream().forEach(batch -> {
      List<Customer> customers = new ArrayList<Customer>();
      List<Vehicle> vehicles = new ArrayList<Vehicle>();
      List<Registration> registrations = new ArrayList<Registration>();

      for (CustomerData data : batch) {
        customers.add(data.GetCustomer());
        vehicles.add(data.GetVehicle());
        registrations.add(data.GetRegistration());
      }

      getCustomerService().batchUpdate(customers);
      getVehicleService().batchUpdate(vehicles);
      getRegistrationService().batchUpdate(registrations);
    });
  }
}
