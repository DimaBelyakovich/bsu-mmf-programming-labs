package by.bsu.entities;

import by.bsu.entities.abstractShip.AbstractShip;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import java.util.StringJoiner;

public class Tanker extends AbstractShip<Double> {
    static Logger log = LogManager.getLogger();
    Scanner scan = new Scanner(System.in);

    private Double fullness = Double.valueOf(0);

    public Tanker() {
        super();
        this.setFrom(Port.randomPort());
        this.setTo(Port.randomPort());
    }

    public Double getFullness() {
        return fullness;
    }

    public void setFullness(Double fullness) {
        this.fullness = fullness;
    }

    @Override
    public void load() {
        System.out.println("How many tons to pour?(double)");
        double fill = scan.nextDouble();
        if(fullness + fill < super.getCapacity()){
            fullness += fill;
            log.info("completed successfully" + fullness + " from " + super.getCapacity());
        }else {
            log.info("not completed");
        }
    }

    @Override
    public void unload() {
        menu:
        while (true){
            System.out.println("Fullness: " + fullness + " from " + super.getCapacity());

            System.out.println("1.Delete quantity\n2.Delete all\n0.Exit");
            int choice = scan.nextInt();
            switch (choice){
                case 1:{
                    System.out.println("enter quantity");
                    int quantity = scan.nextInt();
                    fullness -= quantity;

                    log.info("quantity removed successfully");
                    break;
                }
                case 2:{
                    fullness = Double.valueOf(0);
                    log.info("all removed successfully");
                    break menu;
                }
                case 0:{
                    break menu;
                }
            }
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Tanker.class.getSimpleName() + "[", "]")
                .add(super.toString())
                .add("fullness=" + fullness)
                .toString();
    }
}
