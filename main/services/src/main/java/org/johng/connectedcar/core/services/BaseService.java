package org.johng.connectedcar.core.services;

import java.util.ArrayList;
import java.util.List;

import org.johng.connectedcar.core.services.context.IServiceContext;
import org.johng.connectedcar.core.services.data.items.AppointmentItem;
import org.johng.connectedcar.core.services.data.items.CustomerItem;
import org.johng.connectedcar.core.services.data.items.DealerItem;
import org.johng.connectedcar.core.services.data.items.EventItem;
import org.johng.connectedcar.core.services.data.items.RegistrationItem;
import org.johng.connectedcar.core.services.data.items.TimeslotItem;
import org.johng.connectedcar.core.services.data.items.VehicleItem;
import org.johng.connectedcar.core.services.translator.ITranslator;
import org.johng.connectedcar.core.shared.config.TableEnum;

import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.PageIterable;

public abstract class BaseService {
  
  protected static final TableSchema<DealerItem> DEALER_TABLE_SCHEMA = TableSchema.fromClass(DealerItem.class);
  protected static final TableSchema<TimeslotItem> TIMESLOT_TABLE_SCHEMA = TableSchema.fromClass(TimeslotItem.class);
  protected static final TableSchema<AppointmentItem> APPOINTMENT_TABLE_SCHEMA = TableSchema.fromClass(AppointmentItem.class);
  protected static final TableSchema<CustomerItem> CUSTOMER_TABLE_SCHEMA = TableSchema.fromClass(CustomerItem.class);
  protected static final TableSchema<RegistrationItem> REGISTRATION_TABLE_SCHEMA = TableSchema.fromClass(RegistrationItem.class);
  protected static final TableSchema<VehicleItem> VEHICLE_TABLE_SCHEMA = TableSchema.fromClass(VehicleItem.class);
  protected static final TableSchema<EventItem> EVENT_TABLE_SCHEMA = TableSchema.fromClass(EventItem.class);

  private IServiceContext serviceContext;
  private ITranslator translator;
  
  protected BaseService(
    IServiceContext serviceContext, 
    ITranslator translator) {
      
    this.serviceContext = serviceContext;
    this.translator = translator;
  }
  
  protected IServiceContext getServiceContext() {
    return serviceContext;
  }

  protected ITranslator getTranslator() {
    return translator;
  }

  /********************************************************************************************************/

  protected DynamoDbTable<DealerItem> getDealerTable() {
    String tableName = serviceContext.getConfig().getDynamoDbConfig().getTableName(TableEnum.DEALER);
    return serviceContext.getDynamoDbClient().table(tableName, DEALER_TABLE_SCHEMA);
  }
  
  protected DynamoDbTable<AppointmentItem> getAppointmentTable() {
    String tableName = serviceContext.getConfig().getDynamoDbConfig().getTableName(TableEnum.APPOINTMENT);
    return serviceContext.getDynamoDbClient().table(tableName, APPOINTMENT_TABLE_SCHEMA);
  }
  
  protected DynamoDbTable<TimeslotItem> getTimeslotTable() {
    String tableName = serviceContext.getConfig().getDynamoDbConfig().getTableName(TableEnum.TIMESLOT);
    return serviceContext.getDynamoDbClient().table(tableName, TIMESLOT_TABLE_SCHEMA);
  }
  
  protected DynamoDbTable<CustomerItem> getCustomerTable() {
    String tableName = serviceContext.getConfig().getDynamoDbConfig().getTableName(TableEnum.CUSTOMER);
    return serviceContext.getDynamoDbClient().table(tableName, CUSTOMER_TABLE_SCHEMA);
  }
  
  protected DynamoDbTable<RegistrationItem> getRegistrationTable() {
    String tableName = serviceContext.getConfig().getDynamoDbConfig().getTableName(TableEnum.REGISTRATION);
    return serviceContext.getDynamoDbClient().table(tableName, REGISTRATION_TABLE_SCHEMA);
  }
  
  protected DynamoDbTable<VehicleItem> getVehicleTable() {
    String tableName = serviceContext.getConfig().getDynamoDbConfig().getTableName(TableEnum.VEHICLE);
    return serviceContext.getDynamoDbClient().table(tableName, VEHICLE_TABLE_SCHEMA);
  }
  
  protected DynamoDbTable<EventItem> getEventTable() {
    String tableName = serviceContext.getConfig().getDynamoDbConfig().getTableName(TableEnum.EVENT);
    return serviceContext.getDynamoDbClient().table(tableName, EVENT_TABLE_SCHEMA);
  }

  /********************************************************************************************************/
  
  protected <T> List<T> getItems(PageIterable<T> pages) {
    List<T> items = new ArrayList<T>();
    pages.forEach(r -> items.addAll(r.items()));
    return items;
  }
}
