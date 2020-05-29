package by.bsu.service.builders;

import by.bsu.figure.Polygon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class PolygonBuilder {
    static Polygon polygon = new Polygon();
    static Scanner scanner = new Scanner(System.in);
    static Logger log = LogManager.getLogger();

    public Polygon consoleBuilder(){
        try{
            PointBuilder pointBuilder = new PointBuilder();
            for (int i = 0; i < 4; i++) {
                System.out.println("set vertex" + (i+1));
                polygon.setVertex(pointBuilder.consoleBuilder(), i);
            }
            return polygon;
        }catch (Exception e){
            log.error(e);
            return polygon;
        }
    }
}
