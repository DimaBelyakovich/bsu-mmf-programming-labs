package by.bsu.managers;

import by.bsu.figure.Line;
import by.bsu.service.builders.*;
import by.bsu.service.LineService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class LineManager {
    private static Logger logger = LogManager.getLogger();
    private static Scanner scanner = new Scanner(System.in);
    private LineService lineService = new LineService();

    public void manager(){
        int choice;

        end:
        while(true){
            int index = 0;
            Line line = new Line();

            if(lineService.getAll().size() != 0) {
                for (int i = 0; i < lineService.getAll().size(); i++) {
                    System.out.print(i + ") ");
                    System.out.println(lineService.getAll().get(i));
                }

                System.out.println("take line");
                index = scanner.nextInt();
                //add if statement
                line = lineService.get(index);
            }


            System.out.println("1.Scaling\n2.Rotate\n3.Change color\n4.Add\n5.Delete\n0.Exit");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("coeff");

                    try {
                        double c = scanner.nextDouble();
                        lineService.scaleLine(line, c);
                    }catch (IllegalArgumentException e){
                        logger.error(e);
                    }finally {
                        break;
                    }
                case 2:
                    System.out.println("angle");

                    try {
                        int alf = scanner.nextInt();
                        lineService.rotateLine(line, alf);
                    }catch (IllegalArgumentException e){
                        logger.error(e);
                    }finally {
                        break;
                    }
                case 3:
                    System.out.println("enter color");
                    line.setColor(scanner.next());
                    lineService.setEl(line, index);
                    break;
                case 4:
                    LineBuilder lineBuilder = new LineBuilder();
                    lineService.add(lineBuilder.consoleBuilder());
                    break;
                case 5:
                    lineService.delete();
                case 0:
                    break end;
                default:
                    continue;
            }
        }
    }
}
