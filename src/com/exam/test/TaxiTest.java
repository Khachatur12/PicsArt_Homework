package com.exam.test;

import com.exam.models.Taxi;
import com.exam.services.TaxiService;

import java.util.Scanner;

public class TaxiTest {
    public static void main(String[] args) {
        int count = 1;
        TaxiService taxiService = new TaxiService();
        Taxi[] taxis = taxiService.getTaxisArray(count);

        boolean isActive = true;
        Scanner scanner = new Scanner(System.in);

        while (isActive){
            System.out.println("\n0: exit");
            System.out.println("1: Print cost and topSpeed if the first taxi is sport otherwise print model and country");
            System.out.println("2: Get newer.");
            System.out.println("3: Get Taxi with smallest seats count");
            System.out.println("4: Print all not sport Taxis");
            System.out.println("5: Print all sport Taxis which were road more than 50000 km ");
            System.out.println("6: Print first Taxi with minimal weight");
            System.out.println("7: Pring first Taxi with minimal cost from all sport Taxis");
            System.out.println("8: Print Taxis order by year");
            String comm = scanner.next();

            switch (comm){
                case "0":
                    isActive = false;
                    break;
                case "1":
                    taxiService.printInfo(taxis[0]);
                    break;
                case "2":
                    Taxi newer = taxiService.getFirstNewer(taxis);
                    System.out.printf(newer.toString());
                    break;
                case "3":
                    String country = taxiService.getNameOfFirstSmallestSeats(taxis);
                    System.out.println(country);
                    break;
                case "4":
                    taxiService.printNotSportTaxis(taxis);
                    break;
                case "5":
                    taxiService.printSportTaxis_RoadMore50000(taxis);
                    break;
                case "6":
                    Taxi taxi6 = taxiService.getLastTaxiWithMinimalWeight(taxis);
                    System.out.println(taxi6);
                    break;
                case "7":
                    Taxi taxi7 = taxiService.getSportTaxi_MinimalCost(taxis);
                    System.out.println(taxi7);
                    break;
                case "8":
                    taxiService.printTaxiOrderByYear(taxis);
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}
