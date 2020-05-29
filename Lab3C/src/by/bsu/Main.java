package by.bsu;

import by.bsu.point.ComplexPoint;
import by.bsu.point.Distance;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        ComplexPoint z0 = new ComplexPoint();
        ComplexPoint z1 = new ComplexPoint(3,-4);
        ComplexPoint z2 = new ComplexPoint(-2,5);
        Distance distance = new Distance();
        logger.info(z1.toString());
        logger.info(z2.toString());
        //logger.info(z0.toString());
        //logger.info(distance.calculateDistance(z1,z0));
        logger.info(distance.calculateDistance(z1));
        logger.info(distance.calculateDistance(z1,z2));
    }
}
