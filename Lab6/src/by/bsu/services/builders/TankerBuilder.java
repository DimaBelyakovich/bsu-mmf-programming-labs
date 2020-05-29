package by.bsu.services.builders;

import by.bsu.entities.Tanker;
import by.bsu.entities.abstractShip.Engine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class TankerBuilder {
    static Logger logger = LogManager.getLogger();
    static Scanner scan = new Scanner(System.in);
    public static Tanker builder(){
        Tanker tanker = new Tanker();
        System.out.println("Enter ship name: ");
        tanker.rename(scan.next());

        System.out.println("Enter capacity(amount of oil): ");
        tanker.setCapacity(scan.nextDouble());

        System.out.println("Enter ship displacement(Double): ");
        tanker.setDisplacement(scan.nextDouble());

        System.out.println("DIESEL(power: 40_000), GAZO_DIESEL(power: 50_000), DOUBLE_TYPE(power: 55_000), PETROL(power: 20_000)");
        tanker.setEngine(Engine.valueOf(scan.next().toUpperCase()));
        return tanker;
    }
}
