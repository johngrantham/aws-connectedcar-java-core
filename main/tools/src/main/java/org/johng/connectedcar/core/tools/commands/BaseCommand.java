package org.johng.connectedcar.core.tools.commands;

import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Random;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.opencsv.bean.CsvToBeanBuilder;
import org.johng.connectedcar.core.services.modules.LocalModule;
import org.johng.connectedcar.core.shared.data.enums.StateCodeEnum;
import org.johng.connectedcar.core.shared.services.IAppointmentService;
import org.johng.connectedcar.core.shared.services.ICustomerService;
import org.johng.connectedcar.core.shared.services.IDealerService;
import org.johng.connectedcar.core.shared.services.IEventService;
import org.johng.connectedcar.core.shared.services.IRegistrationService;
import org.johng.connectedcar.core.shared.services.ITimeslotService;
import org.johng.connectedcar.core.shared.services.IUserService;
import org.johng.connectedcar.core.shared.services.IVehicleService;
import org.johng.connectedcar.core.tools.data.CustomerData;
import org.johng.connectedcar.core.tools.data.DealerData;

public abstract class BaseCommand {

  protected static final String DEALERS_FILE_PATH = "data/dealers";
  protected static final String CUSTOMERS_FILE_PATH = "data/customers";
  protected static final String CREDENTIALS_FILE_PATH = "data/credentials";

  protected static final String DATE_FORMAT = "yyyy-MM-dd";

  private Injector injector;

  private static Random random = new Random();

  public BaseCommand() {
    injector = Guice.createInjector(new LocalModule());
  }

  protected IDealerService getDealerService() {
    return injector.getInstance(IDealerService.class);
  }

  protected ITimeslotService getTimeslotService() {
    return injector.getInstance(ITimeslotService.class);
  }

  protected IAppointmentService getAppointmentService() {
    return injector.getInstance(IAppointmentService.class);
  }

  protected ICustomerService getCustomerService() {
    return injector.getInstance(ICustomerService.class);
  }

  protected IRegistrationService getRegistrationService() {
    return injector.getInstance(IRegistrationService.class);
  }

  protected IVehicleService getVehicleService() {
    return injector.getInstance(IVehicleService.class);
  }
  
  protected IEventService getEventService() {
    return injector.getInstance(IEventService.class);
  }

  protected IUserService getUserService() {
    return injector.getInstance(IUserService.class);
  }

  protected static StateCodeEnum getRandomStateCode() {
    StateCodeEnum[] values = StateCodeEnum.values();
    return values[random.nextInt(values.length)];
  }

  protected static <T> T getRandomItem(List<T> items) {
    if (items.size() > 0) {
      return items.get(random.nextInt(items.size()));
    }

    return null;
  }

  protected static List<DealerData> readDealerData(File file)
  {
    try {
      return new CsvToBeanBuilder<DealerData>(new FileReader(file))
        .withType(DealerData.class)
        .build()
        .parse();
    } 
    catch (Exception e) {
      e.printStackTrace();
    }  

    return null;
  }  

  protected static List<CustomerData> readCustomerData(File file)
  {
    try {
      return new CsvToBeanBuilder<CustomerData>(new FileReader(file))
        .withType(CustomerData.class)
        .build()
        .parse();
    } 
    catch (Exception e) {
      e.printStackTrace();
    }  

    return null;
  }  
}
