package by.bsu;

import by.bsu.managers.LineManager;
import by.bsu.managers.PointManager;
import by.bsu.managers.PolygonManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main {
    static Logger log = LogManager.getLogger();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        close:
        while(true){
            System.out.println("1.points\n2.lines\n3.polygons\n0.exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    PointManager pointManager = new PointManager();
                    pointManager.manager();
                    break;
                case 2:
                    LineManager lineManager = new LineManager();
                    lineManager.manager();
                    break;
                case 3:
                    PolygonManager polygonManager = new PolygonManager();
                    polygonManager.manager();
                    break;
                case 0:
                    break close;
                default:
                    continue;
            }
        }
    }
}
