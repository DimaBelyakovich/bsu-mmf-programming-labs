package by.bsu.services.builders;

import by.bsu.entities.abstractShip.Engine;
import by.bsu.entities.cargoShip.CargoShip;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class CargoShipBuilder {
    static Logger logger = LogManager.getLogger();
    static Scanner scan = new Scanner(System.in);

    public static CargoShip builder(){
        CargoShip cShip = new CargoShip();
        System.out.println("Enter ship name: ");
        cShip.rename(scan.next());

        System.out.println("Enter capacity(number of containers): ");
        cShip.setCapacity(scan.nextInt());

        System.out.println("Enter ship displacement(Double): ");
        cShip.setDisplacement(scan.nextDouble());

        System.out.println("DIESEL(power: 40_000), GAZO_DIESEL(power: 50_000), DOUBLE_TYPE(power: 55_000), PETROL(power: 20_000)");
        cShip.setEngine(Engine.valueOf(scan.next().toUpperCase()));

        return cShip;
    }
}
