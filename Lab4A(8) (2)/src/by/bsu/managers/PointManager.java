package by.bsu.managers;

import by.bsu.figure.Point;
import by.bsu.service.builders.*;
import by.bsu.service.PointService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class PointManager {
    private static Logger logger = LogManager.getLogger();
    private static Scanner scanner = new Scanner(System.in);
    private PointService pointService = new PointService();

    public void manager(){
        int choice;

        end:
        while(true){
            int index = 0;
            Point point = new Point();

            if(pointService.getAll().size() != 0) {
                for (int i = 0; i < pointService.getAll().size(); i++) {
                    System.out.print(i + ") ");
                    System.out.println(pointService.getAll().get(i));
                }

                System.out.println("take point");
                index = scanner.nextInt();
                point = pointService.get(index);
            }


            System.out.println("1.Scaling\n2.Rotate\n3.Change color\n4.Add\n5.Delete\n0.Exit");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("not available for point");
                    break;
                case 2:
                    System.out.println("angle:");

                    try {
                        int alf = scanner.nextInt();
                        pointService.rotatePoint(point, alf);
                    }catch (IllegalArgumentException e){
                        logger.error(e);
                    }finally {
                        break;
                    }
                case 3:
                    System.out.println("enter color");
                    point.setColor(scanner.next());
                    pointService.setEl(point, index);
                    break;
                case 4:
                    PointBuilder pointBuilder = new PointBuilder();
                    pointService.add(pointBuilder.consoleBuilder());
                    break;
                case 5:
                    pointService.delete();
                case 0:
                    break end;
                default:
                    continue;
            }
        }
    }

}
