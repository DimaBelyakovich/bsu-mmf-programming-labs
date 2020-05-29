package by.bsu.view;

import by.bsu.entities.Port;
import by.bsu.entities.Tanker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class TankerManager {static Logger logger = LogManager.getLogger();
    static Scanner scan = new Scanner(System.in);

    public static void tankerManager(Tanker ship){
        end1:
        while (true) {
            System.out.println("what to do?");
            System.out.println("1.Manage move\n2.Rename ship\n3.Load\n4.Unload\n0.exit");
            int choice = scan.nextInt();

            switch (choice){
                case 1:{

                    point:
                    while(true) {
                        System.out.println(ship.move());
                        System.out.println("What to change?\n1.from\n2.to\n3.Exit");
                        int choiceMove = scan.nextInt();
                        switch (choiceMove) {
                            case 1: {
                                System.out.println(
                                        "SHANGHAI(country : China),\n" +
                                        "SINGAPORE(country : Singapore),\n" +
                                        "HONG_KONG(country : China),\n" +
                                        "SHENZHEN(country : China),\n" +
                                        "BUSAN(country : South_Korea),\n" +
                                        "QINGDAO(country : China),\n" +
                                        "DUBAI(country : UAE),\n" +
                                        "BREMEN(country : Germany),\n" +
                                        "HUMBURG(country : Germany),\n" +
                                        "WELLINGTON(country : New_Zeland),\n" +
                                        "LONDON(country : UK),\n" +
                                        "BOSTON(country : USA),\n" +
                                        "LOS_ANGELES(country : USA),\n" +
                                        "HALIFAX(country : Canada)");
                                System.out.println("Enter:");
                                ship.setFrom(Port.valueOf(scan.next().toUpperCase()));
                                break;
                            }
                            case 2: {
                                System.out.println("SHANGHAI(country : China),\n" +
                                        "SINGAPORE(country : Singapore),\n" +
                                        "HONG_KONG(country : China),\n" +
                                        "SHENZHEN(country : China),\n" +
                                        "BUSAN(country : South_Korea),\n" +
                                        "QINGDAO(country : China),\n" +
                                        "DUBAI(country : UAE),\n" +
                                        "BREMEN(country : Germany),\n" +
                                        "HUMBURG(country : Germany),\n" +
                                        "WELLINGTON(country : New_Zeland),\n" +
                                        "LONDON(country : UK),\n" +
                                        "BOSTON(country : USA),\n" +
                                        "LOS_ANGELES(country : USA),\n" +
                                        "HALIFAX(country : Canada)");
                                System.out.println("Enter:");
                                ship.setTo(Port.valueOf(scan.next().toUpperCase()));
                                break;
                            }
                            case 3: {
                                break point;
                            }
                            default: continue;
                        }
                    }
                    break;
                }
                case 2:{
                    System.out.println(ship.getName());
                    System.out.println("Enter new Name");
                    ship.rename(scan.next());
                    break;
                }
                case 3:{
                    ship.load();
                    break;
                }
                case 4:{
                    ship.unload();
                    break;
                }
                case 0:{
                    break end1;
                }
                default: continue;
            }
        }
    }
}
