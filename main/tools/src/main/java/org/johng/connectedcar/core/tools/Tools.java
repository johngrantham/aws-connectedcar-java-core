package org.johng.connectedcar.core.tools;

import java.util.Scanner;

import org.johng.connectedcar.core.tools.commands.SeedAppointmentDataCommand;
import org.johng.connectedcar.core.tools.commands.SeedCustomerDataCommand;
import org.johng.connectedcar.core.tools.commands.SeedDealerDataCommand;

public class Tools {

  public static void Main(String[] args) {
    Scanner scanner = null;

    try {
      System.out.println("Type the command number and press enter");
      System.out.println("  Type 1 to seed dealer data");
      System.out.println("  Type 2 to seed customer data");
      System.out.println("  Type 3 to seed appointment data");

      scanner = new Scanner(System.in);
      int command = scanner.nextInt();

      switch (command) {
        case 1:
            SeedDealerDataCommand seedDealerDataCommand = new SeedDealerDataCommand();
            seedDealerDataCommand.execute();
            break;
        case 2:
            SeedCustomerDataCommand seedCustomerDataCommand = new SeedCustomerDataCommand();
            seedCustomerDataCommand.execute();
            break;
        case 3:
            SeedAppointmentDataCommand seedAppointmentDataCommand = new SeedAppointmentDataCommand();
            seedAppointmentDataCommand.execute();
            break;
      }

    }
    catch (Exception e) {
      e.printStackTrace();
    }
    finally {
      if (scanner != null) scanner.close();
    }
  }
}