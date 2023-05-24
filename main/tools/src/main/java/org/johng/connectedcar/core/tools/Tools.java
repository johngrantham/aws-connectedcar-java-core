package org.johng.connectedcar.core.tools;

import java.util.Scanner;

import org.johng.connectedcar.core.tools.commands.PopulateAppointmentsCommand;
import org.johng.connectedcar.core.tools.commands.PopulateCustomersCommand;
import org.johng.connectedcar.core.tools.commands.PopulateDealersCommand;

public class Tools {

  public static void Main(String[] args) {
    Scanner scanner = null;

    try {
      System.out.println("Type the command number and press enter");
      System.out.println("  Type 1 to populate dealer data");
      System.out.println("  Type 2 to populate customer data");
      System.out.println("  Type 3 to populate appointment data");

      scanner = new Scanner(System.in);
      int command = scanner.nextInt();

      switch (command) {
        case 1:
            PopulateDealersCommand populateDealersCommand = new PopulateDealersCommand();
            populateDealersCommand.execute();
            break;
        case 2:
            PopulateCustomersCommand populateCustomersCommand = new PopulateCustomersCommand();
            populateCustomersCommand.execute();
            break;
        case 3:
            PopulateAppointmentsCommand populateAppointmentsCommand = new PopulateAppointmentsCommand();
            populateAppointmentsCommand.execute();
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