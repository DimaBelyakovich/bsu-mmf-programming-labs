package by.bsu.entities.cargoShip;

import by.bsu.entities.Port;
import by.bsu.entities.abstractShip.AbstractShip;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class CargoShip extends AbstractShip<Integer> {
    static Logger log = LogManager.getLogger();
    Scanner scan = new Scanner(System.in);
    private List<Item> containers;

    public CargoShip() {
        containers = new ArrayList<>();
        this.setFrom(Port.randomPort());
        this.setTo(Port.randomPort());
    }

    public CargoShip(List<Item> containers) {
        this.containers = containers;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CargoShip.class.getSimpleName() + "[", "]")
                .add(super.toString())
                .add("containers=" + containers)
                .toString();
    }

    @Override
    public void load() {
        end:
        while (true){
            System.out.println("1.Add container\n2.Exit");
            int choice = scan.nextInt();
            switch (choice){
                case 1:{
                    Item item = new Item();
                    System.out.println("container name");
                    item.setName(scan.next());
                    System.out.println("container weight: ");
                    item.setWeight(scan.nextDouble());
                    System.out.println("fragile items?");
                    item.setFragile(scan.nextBoolean());
                    containers.add(item);
                    log.info("item added successfully");
                    break;
                }
                case 2:{
                    break end;
                }
                default: continue;
            }
        }
    }

    @Override
    public void unload() {
        menu:
        while (true){
            System.out.println("All containers");
            for (int i = 0; i < containers.size(); i++) {
                System.out.println(i + ") " + containers.get(i));
            }

            System.out.println("1.Delete one container\n2.Delete all containers\n0.Exit");
            int choice = scan.nextInt();
            switch (choice){
                case 1:{
                    System.out.println("enter the index of the container to be deleted");
                    int index = scan.nextInt();
                    containers.remove(index);
                    log.info("one object removed successfully");
                    break;
                }
                case 2:{
                    containers.clear();
                    log.info("all containers removed successfully");
                    break menu;
                }
                case 0:{
                    break menu;
                }
            }
        }
    }
}
