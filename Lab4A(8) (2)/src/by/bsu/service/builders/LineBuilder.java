package by.bsu.service.builders;

import by.bsu.figure.Line;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class LineBuilder {
    static Line line = new Line();
    static Scanner scanner = new Scanner(System.in);
    static Logger log = LogManager.getLogger();

    public Line consoleBuilder(){
        PointBuilder pointBuilder = new PointBuilder();
        try{
            System.out.println("set start point:");
            line.setPointStart(pointBuilder.consoleBuilder());
            System.out.println("set end point:");
            line.setPointEnd(pointBuilder.consoleBuilder());
            return line;
        }catch (Exception e){
            log.error(e);
            return line;
        }
    }
}
