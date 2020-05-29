package by.bsu;

import by.bsu.entities.cargoShip.CargoShip;
import by.bsu.entities.Port;
import by.bsu.view.MainManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        MainManager view = new MainManager();
        view.menu();
    }
}
