package com.design;

import com.design.exception.CustomException;
import com.design.manager.ParkingLotManager;
import com.design.services.ParkingSpotInventoryService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class MainApplication {

  public static void main(String args[]) {
    ParkingSpotInventoryService.initializeParkingLots();
    Scanner sc = new Scanner(System.in);
    ApplicationContext context =
        new ClassPathXmlApplicationContext(new String[] {"configuration.xml"});
    ParkingLotManager parkingLotManager = (ParkingLotManager) context.getBean("parkingLotManager");
    while (true) {
      try {
        System.out.println("Please select option");
        byte actionType = sc.nextByte();
        String requestData = sc.next();
        parkingLotManager.performAction(actionType, requestData);
      } catch (CustomException exception) {
        System.out.println(
            "Error Message: " + exception.getCustomExceptionResponseCodes().getErrorMessage());
      }
    }
  }
}
