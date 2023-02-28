package org.johng.connectedcar.core.services.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

import org.johng.connectedcar.core.services.AppointmentService;
import org.johng.connectedcar.core.services.CustomerService;
import org.johng.connectedcar.core.services.DealerService;
import org.johng.connectedcar.core.services.EventService;
import org.johng.connectedcar.core.services.MessageService;
import org.johng.connectedcar.core.services.RegistrationService;
import org.johng.connectedcar.core.services.TimeslotService;
import org.johng.connectedcar.core.services.UserService;
import org.johng.connectedcar.core.services.VehicleService;
import org.johng.connectedcar.core.services.context.IServiceContext;
import org.johng.connectedcar.core.services.context.NonTracingContext;
import org.johng.connectedcar.core.services.translator.ITranslator;
import org.johng.connectedcar.core.services.translator.Translator;
import org.johng.connectedcar.core.shared.orchestrators.AdminOrchestrator;
import org.johng.connectedcar.core.shared.orchestrators.CustomerOrchestrator;
import org.johng.connectedcar.core.shared.orchestrators.IAdminOrchestrator;
import org.johng.connectedcar.core.shared.orchestrators.ICustomerOrchestrator;
import org.johng.connectedcar.core.shared.services.IAppointmentService;
import org.johng.connectedcar.core.shared.services.ICustomerService;
import org.johng.connectedcar.core.shared.services.IDealerService;
import org.johng.connectedcar.core.shared.services.IEventService;
import org.johng.connectedcar.core.shared.services.IMessageService;
import org.johng.connectedcar.core.shared.services.IRegistrationService;
import org.johng.connectedcar.core.shared.services.ITimeslotService;
import org.johng.connectedcar.core.shared.services.IUserService;
import org.johng.connectedcar.core.shared.services.IVehicleService;

public class NonTracingModule extends AbstractModule {

  @Override 
  protected void configure() {
    bind(IServiceContext.class).to(NonTracingContext.class).in(Singleton.class);
    bind(ITranslator.class).to(Translator.class).in(Singleton.class);
    
    bind(IDealerService.class).to(DealerService.class).in(Singleton.class);
    bind(ITimeslotService.class).to(TimeslotService.class).in(Singleton.class);
    bind(IAppointmentService.class).to(AppointmentService.class).in(Singleton.class);
    bind(ICustomerService.class).to(CustomerService.class).in(Singleton.class);
    bind(IRegistrationService.class).to(RegistrationService.class).in(Singleton.class);
    bind(IVehicleService.class).to(VehicleService.class).in(Singleton.class);
    bind(IEventService.class).to(EventService.class).in(Singleton.class);
    bind(IUserService.class).to(UserService.class).in(Singleton.class);
    bind(IMessageService.class).to(MessageService.class).in(Singleton.class);
    bind(IAdminOrchestrator.class).to(AdminOrchestrator.class).in(Singleton.class);
    bind(ICustomerOrchestrator.class).to(CustomerOrchestrator.class).in(Singleton.class);
  }
}
