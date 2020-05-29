package by.bsu.view;

import by.bsu.entities.Tanker;
import by.bsu.entities.cargoShip.CargoShip;
import by.bsu.services.builders.CargoShipBuilder;
import by.bsu.services.builders.TankerBuilder;

import java.util.ArrayList;
import java.util.Scanner;

public class MainManager {
    private ArrayList<CargoShip> cargoShips = new ArrayList<>();
    private ArrayList<Tanker> tankers = new ArrayList<>();

    static Scanner scan = new Scanner(System.in);

    public void menu(){
        endd:
        while (true){
            System.out.println("1.Add CargoShip\n2.Add Tanker\n3.Get all cargoShips\n4.Get all tankers\n5.Mange CargoShips\n6.Manage Tankers\n0.exit");
            int choice = scan.nextInt();
            switch (choice){
                case 1:{
                    cargoShips.add(CargoShipBuilder.builder());
                    break;
                }
                case 2:{
                    tankers.add(TankerBuilder.builder());
                    break;
                }
                case 3:{
                    for (CargoShip ship: cargoShips) {
                        System.out.println(ship);
                    }
                    break;
                }
                case 4:{
                    for (Tanker ship: tankers) {
                        System.out.println(ship);
                    }
                    break;
                }
                case 5:{
                    for (int i = 0; i < cargoShips.size(); i++) {
                        System.out.println(i + ") " + cargoShips.get(i));
                    }
                    System.out.println("Enter index");
                    int index = scan.nextInt();
                    CargoShipManager.cargoShipManager(cargoShips.get(index));
                    break;
                }
                case 6:{
                    for (int i = 0; i < tankers.size(); i++) {
                        System.out.println(i + ") " + tankers.get(i));
                    }
                    System.out.println("Enter index");
                    int index = scan.nextInt();
                    TankerManager.tankerManager(tankers.get(index));
                    break;
                }
                case 0: break endd;
                default: continue;
            }
        }
    }
}
