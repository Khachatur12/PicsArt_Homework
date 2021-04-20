package com.exam.services;

import com.exam.models.Taxi;


import java.util.Scanner;

public class TaxiService {
    public void printInfo(Taxi taxi) {
        if (taxi.isSport()) {
            System.out.println(taxi.getCost());
            System.out.println(taxi.getTopSpeed());
        } else {
            System.out.println(taxi.getCountry());
            System.out.println(taxi.getModel());
        }
    }

    public Taxi[] getTaxisArray(int n) {
        Taxi[] taxis = new Taxi[n];
        boolean canContinue = true;

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            Taxi taxi = new Taxi();

            do {
                System.out.print("input model: ");
                taxi.setModel(scanner.next());
                if (taxi.getModel() == null || taxi.getModel().isEmpty()) {
                    canContinue = false;
                    System.out.println("invalid value");
                } else {
                    canContinue = true;
                }
            } while (!canContinue);

            do {
                System.out.print("input country: ");
                taxi.setCountry(scanner.next());
                if (taxi.getCountry() == null || taxi.getCountry().isEmpty()) {
                    canContinue = false;
                    System.out.println("invalid value");
                } else {
                    canContinue = true;
                }
            } while (!canContinue);

            do {
                System.out.print("input year of publishing from 1903 to 2020: ");
                taxi.setYear(scanner.nextInt());
                if (taxi.getYear() >= 1903 && taxi.getYear() <= 2020) {
                    canContinue = true;
                } else {
                    canContinue = false;
                    System.out.println("invalid value");

                }
            } while (!canContinue);

            do {
                System.out.print("input milage (from 0 to 999999): ");
                taxi.setMilage(scanner.nextInt());
                if (taxi.getMilage() >= 0 && taxi.getMilage() <= 999999) {
                    canContinue = true;
                } else {
                    canContinue = false;
                    System.out.println("invalid value");
                }
            } while (!canContinue);

            do {
                System.out.print("Is the car sport or not? ('y/n'): ");
                String isSport = scanner.next();
                if (isSport.equals("y") || isSport.equals("n")) {
                    taxi.setSport(isSport.equals("y"));
                    canContinue = true;
                } else {
                    canContinue = false;
                    System.out.println("invalid value");
                }
            } while (!canContinue);

            do {
                System.out.print("input weight of car (from 1000 KG to 3000 KG): ");
                taxi.setWeight(scanner.nextInt());
                if (taxi.getWeight() >= 1000 && taxi.getWeight() <= 3000) {
                    canContinue = true;
                } else {
                    canContinue = false;
                    System.out.println("invalid value");
                }
            } while (!canContinue);

            do {
                System.out.print("input maximal speed per hour (ex: 220) (any not negative value): ");
                taxi.setSeats(scanner.nextInt());
                if (taxi.getSeats() >= 0) {
                    canContinue = true;
                } else {
                    canContinue = false;
                    System.out.println("invalid value");
                }
            } while (!canContinue);

            do {
                System.out.print("input cost of the car (ex: 445.6) (any not negative value): ");
                taxi.setCost(scanner.nextDouble());
                if (taxi.getCost() >= 0) {
                    canContinue = true;
                } else {
                    canContinue = false;
                    System.out.println("invalid value");
                }
            } while (!canContinue);

            taxis[i] = taxi;
        }

        return taxis;
    }

    public Taxi getFirstNewer(Taxi[] taxis) {
        Taxi newer = taxis[0];

        for (int i = 1; i < taxis.length; i++) {
            if (newer.getYear() > taxis[i].getYear())
                newer = taxis[i];
        }

        return newer;
    }

    public String getNameOfFirstSmallestSeats(Taxi[] taxis) {
        Taxi taxi = taxis[0];

        for (int i = 1; i < taxis.length; i++) {
            if (taxi.getSeats() < taxis[i].getSeats())
                taxi = taxis[i];
        }

        return taxi.getCountry();
    }

    public void printNotSportTaxis(Taxi[] taxis) {
        boolean find = false;
        for (int i = 0; i < taxis.length; i++) {
            if (! taxis[i].isSport()){
                find = true;
                System.out.println(taxis[i]);
            }
        }

        if (!find)
            System.out.println("Non");
    }

    public void printSportTaxis_RoadMore50000(Taxi[] taxis) {
        boolean find = false;

        for (int i = 0; i < taxis.length; i++) {
            if (taxis[i].isSport() && taxis[i].getMilage() > 50_000){
                System.out.println(taxis[i]);
                find = true;
            }
        }

        if (!find) System.out.println("Non");
    }

    public Taxi getLastTaxiWithMinimalWeight(Taxi[] taxis) {
        Taxi min = taxis[0];

        for (int i = 1; i < taxis.length; i++) {
            if (min.getWeight() >= taxis[i].getWeight())
                min = taxis[i];
        }

        return min;
    }

    public Taxi getSportTaxi_MinimalCost(Taxi[] taxis) {
        Taxi min = new Taxi();
        boolean finded = false;

        for (int i = 1; i < taxis.length; i++) {
            if (taxis[i].isSport()){
                if (!finded){
                    finded = true;
                    min = taxis[i];
                }

                if (taxis[i].getWeight() < min.getCost())
                    min = taxis[i];
            }

        }

        return min;
    }

    public void printTaxiOrderByYear(Taxi[] taxis) {
        for (int i = 0; i < taxis.length - 1; i++) {
            for (int j = i; j < taxis.length; j++) {
                if (taxis[i].getYear() > taxis[j].getYear()){
                    Taxi taxi = taxis[i];
                    taxis[i] = taxis[j];
                    taxis[j] = taxi;
                }
            }
        }
        for (Taxi taxi : taxis) {
            System.out.println(taxi);
        }
    }
}
