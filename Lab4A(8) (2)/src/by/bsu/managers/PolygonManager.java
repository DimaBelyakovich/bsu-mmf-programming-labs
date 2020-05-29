package by.bsu.managers;

import by.bsu.service.builders.PolygonBuilder;
import by.bsu.figure.Polygon;
import by.bsu.service.PolygonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class PolygonManager {
    private static Logger logger = LogManager.getLogger();
    private static Scanner scanner = new Scanner(System.in);
    private PolygonService polygonService = new PolygonService();

    public void manager(){
        int choice;

        end:
        while(true){
            int index = 0;
            Polygon polygon = new Polygon();

            if(polygonService.getAll().size() != 0) {
                for (int i = 0; i < polygonService.getAll().size(); i++) {
                    System.out.print(i + ") ");
                    System.out.println(polygonService.getAll().get(i));
                }

                System.out.println("take polygon");
                index = scanner.nextInt();
                //add if statement
                polygon = polygonService.get(index);
            }


            System.out.println("1.Scaling\n2.Rotate\n3.Change color\n4.Add\n5.Delete\n0.Exit");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("coeff");

                    try {
                        double c = scanner.nextDouble();
                        polygonService.scalePolygon(polygon, c);
                    }catch (IllegalArgumentException e){
                        logger.error(e);
                    }finally {
                        break;
                    }
                case 2:
                    System.out.println("angle");

                    try {
                        int alf = scanner.nextInt();
                        polygonService.rotatePolygon(polygon, alf);
                    }catch (IllegalArgumentException e){
                        logger.error(e);
                    }finally {
                        break;
                    }
                case 3:
                    System.out.println("enter color");
                    polygon.setColor(scanner.next());
                    polygonService.setEl(polygon, index);
                    break;
                case 4:
                    PolygonBuilder polygonBuilder = new PolygonBuilder();
                    polygonService.add(polygonBuilder.consoleBuilder());
                    break;
                case 5:
                    polygonService.delete();
                case 0:
                    break end;
                default:
                    continue;
            }
        }
    }
}
