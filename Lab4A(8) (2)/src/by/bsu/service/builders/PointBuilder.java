package by.bsu.service.builders;

import by.bsu.figure.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class PointBuilder {
    static Point point = new Point();
    static Scanner scanner = new Scanner(System.in);
    static Logger log = LogManager.getLogger();

    public Point consoleBuilder(){
        try {
            System.out.println("set x:");
            point.setpX(scanner.nextDouble());
            System.out.println("set y:");
            point.setpY(scanner.nextDouble());
            System.out.println("set color:");
            point.setColor(scanner.next());
            return point;
        }catch (Exception e){
            log.error(e);
            return point;
        }
    }
}
