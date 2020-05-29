package by.bsu;

import Exceptions.NotValidException;
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
        System.out.println("name:");
        String name = scan.next();
        System.out.println("id:");
        int pasId = scan.nextInt();
        Passenger p = new Passenger(pasId, name);


        point:
        while(true){
            System.out.println("1. add item\n0. Exit");
            int choice;

            if(scan.hasNextInt()) {
                choice = scan.nextInt();
            }else {
                scan = new Scanner(System.in);
                continue ;
            }
            switch (choice){
                case 1:
                    try {
                        System.out.println("item id");
                        int iId;
                        if(scan.hasNextInt()) {
                            iId = scan.nextInt();
                        }else {
                            throw new NotValidException("not int in id");
                        }
                        System.out.println("item name");
                        String iName = scan.next();
                        System.out.println("item weight");
                        int iWeight;
                        if(scan.hasNextInt()) {
                            iWeight = scan.nextInt();
                        }else {
                            throw new NotValidException("not int in weight");
                        }
                        Item item = new Item(iId, iName, iWeight);
                        p.addItem(item);
                    }catch (NotValidException e){
                        log.error(e);
                    }finally {
                        scan = new Scanner(System.in);
                        break;
                    }

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
        List<PassengerWaggon> waggons = new ArrayList<>();

        try {
            System.out.println("Enter speed of train");
            int speed;
            if (scan.hasNextInt()) {
                speed = scan.nextInt();
            } else {
                scan = new Scanner(System.in);
                throw new NotValidException("not int");
            }
            locomotive.speed(speed);

            System.out.println("Enter type of locomotive: TURBOSHAFT, DIESEL, PETROL, ELECTRIC_MOTOR");
            String type = scan.next().toUpperCase();
            try{
                locomotive.engine(Engine.valueOf(type));
            }catch (EnumConstantNotPresentException | IllegalArgumentException ex){
                throw ex;
            }


            int n;
            if (scan.hasNextInt()) {
                n = scan.nextInt();
            } else {
                scan = new Scanner(System.in);
                throw new NotValidException("not int");
            }

            for (int i = 0; i < n; i++) {
                PassengerWaggon.BuilderSub waggonP = PassengerWaggon.newPassengerWaggon();

                System.out.println("Enter comfort level: ECONOMY, COUPE, LUXE, VIP");
                try {
                    waggonP.comfort(ComfortLevel.valueOf(scan.next().toUpperCase()));
                }catch (EnumConstantNotPresentException ex){
                    throw ex;
                }


                System.out.println("Enter num of seats");
                int numSeats;
                if (scan.hasNextInt()) {
                    numSeats = scan.nextInt();
                    if(numSeats<0){
                        throw new NotValidException("less then 0");
                    }
                    waggonP.numberOfSeats(numSeats);
                } else {
                    scan = new Scanner(System.in);
                    throw new NotValidException("not int");
                }

                PassengerWaggon waggon = waggonP.build();

                point:
                while (true) {
                    System.out.println("1. add some passenger\n2. add one passenger\n0. Exit");
                    int choice;

                    if(scan.hasNextInt()) {
                        choice = scan.nextInt();
                    }else {
                        scan = new Scanner(System.in);
                        continue ;
                    }

                    switch (choice) {
                        case 1:
                            int num;
                            if (scan.hasNextInt()) {
                                num = scan.nextInt();
                            } else {
                                scan = new Scanner(System.in);
                                throw new NotValidException("not int");
                            }

                            for (int j = 0; j < num; j++) {
                                waggon.addPassenger(passengerBuilder());
                            }
                            break;
                        case 2:
                            waggon.addPassenger(passengerBuilder());
                            break;
                        case 0:
                            break point;
                        default:
                            continue;
                    }
                }
                waggons.add(waggon);
            }


            for (int i = 0; i < waggons.size(); i++) {
                for (int j = 0; j < passengers.size(); j++) {
                    waggons.get(i).addPassenger(passengers.get(j));
                }
            }
        }catch (NotValidException | EnumConstantNotPresentException | IllegalArgumentException ex){
            log.error(ex);
            scan = new Scanner(System.in);
        }
        Train tr = new Train(locomotive.build(), waggons);
        return tr;
    }
}
