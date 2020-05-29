package by.bsu;

import by.bsu.dao.PassengerDao;
import by.bsu.dao.TrainDao;
import by.bsu.model.ComfortLevel;
import by.bsu.model.Engine;
import by.bsu.model.entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Logger log = LogManager.getLogger();
    static Scanner scan = new Scanner(System.in);
    static PassengerDao pDao = new PassengerDao();
    static TrainDao tDao = new TrainDao();

    public static void main(String[] args) {
        pDao.load();
        tDao.load();
        while(true) {
            System.out.println("Choose what to manage: \n1.train\n2.passenger\n3.task sorting\n0.Exit");
            int choice = scan.nextInt();
            switch (choice)
            {
                case 1:{
                    trainManager();
                    break;
                }
                case 2:{
                    passengerManger();
                    break;
                }
                case 3:{
                    List<Train> trains = tDao.getAll();
                    System.out.println(trains);
                    System.out.println("index of train");
                    int trainNum = scan.nextInt();
                    Train tr = trains.get(trainNum);
                    List<PassengerWaggon> pw = tr.getWaggons();
                    System.out.println("min");
                    int min = scan.nextInt();
                    System.out.println("max");
                    int max = scan.nextInt();
                    for (int i = 0; i < pw.size(); i++) {
                        if(pw.get(i).getNumberOfSeats()<max && pw.get(i).getNumberOfSeats()>min){
                            System.out.println(pw.get(i));
                        }
                    }
                    break;
                }
                case 0: System.exit(0);
                default: continue;
            }
        }
    }

    private static void passengerManger(){
        pDao.load();

        while(true) {
            System.out.println("Choose what to do: \n1.Add\n2.Delete\n4.Show All\n0.Back");
            int choice = scan.nextInt();
            switch (choice)
            {
                case 1:{
                    pDao.create(passengerBuilder());
                    break;
                }
                case 4:{
                    System.out.println(pDao.getAll());
                    break;
                }
                case 0: {
                    pDao.save();
                    main(new String[0]);
                };
                default: continue;
            }

        }
    }

    private static void trainManager(){
        tDao.load();
        while(true) {
            System.out.println("Choose what to do: \n1.Add\n2.Delete\n4.Show All\n0.Back");
            int choice = scan.nextInt();
            switch (choice)
            {
                case 1:{
                    tDao.create(trainBuilder());
                    break;
                }
                case 4:{
                    System.out.println(tDao.getAll());
                    break;
                }
                case 0: {
                    tDao.save();
                    main(new String[0]);
                };
                default: continue;
            }

        }
    }

    private static Passenger passengerBuilder(){

        String name = scan.next();
        int pasId = scan.nextInt();
        Passenger p = new Passenger(pasId, name);
        point:
        while(true){
            System.out.println("1. add item\n0. Exit");
            int choice = scan.nextInt();

            switch (choice){
                case 1:
                    System.out.println("item id");
                    int iId = scan.nextInt();
                    System.out.println("item name");
                    String iName = scan.next();
                    System.out.println("item weight");
                    int iWeight = scan.nextInt();
                    Item item = new Item(iId,iName,iWeight);
                    break;
                case 0:
                    break point;
                default: continue;
            }
        }
        return p;
    }

    private static Train trainBuilder(){
        pDao.load();
        List<Passenger> passengers = pDao.getAll();
        Locomotive.BuilderSub locomotive = Locomotive.newLocomotive();
        System.out.println("Enter speed of train");
        int speed = scan.nextInt();
        locomotive.speed(speed);
        System.out.println("Enter type of locomotive: TURBOSHAFT, DIESEL, PETROL, ELECTRIC_MOTOR");
        locomotive.engine(Engine.valueOf(scan.next().toUpperCase()));

        List<PassengerWaggon> waggons = new ArrayList<>();

        int n = 2;
        for (int i = 0; i < n; i++) {
            PassengerWaggon.BuilderSub waggonP = PassengerWaggon.newPassengerWaggon();

            System.out.println("Enter comfort level: ECONOMY, COUPE, LUXE, VIP");
            waggonP.comfort(ComfortLevel.valueOf(scan.next().toUpperCase()));

            System.out.println("Enter num of seats");
            waggonP.numberOfSeats(scan.nextInt());

            PassengerWaggon waggon = waggonP.build();

            point:
            while(true){
                System.out.println("1. add some passenger\n2. add one passenger\n0. Exit");
                int choice = scan.nextInt();

                switch (choice){
                    case 1:
                        int num = scan.nextInt();
                        for (int j = 0; j < num; j++) {
                            waggon.addPassenger(passengerBuilder());
                        }
                        break;
                    case 2:
                        waggon.addPassenger(passengerBuilder());
                        break;
                    case 0:
                        break point;
                    default: continue;
                }
            }
            waggons.add(waggon);
        }


        for (int i = 0; i < waggons.size(); i++) {
            for (int j = 0; j < passengers.size(); j++) {
                waggons.get(i).addPassenger(passengers.get(j));
            }
        }
        Train tr = new Train(locomotive.build(),waggons);
        return tr;
    }
}
