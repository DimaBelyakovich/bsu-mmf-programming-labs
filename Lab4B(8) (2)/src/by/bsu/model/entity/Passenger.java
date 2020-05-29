package by.bsu.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Passenger extends Entity{
    private int passengerId;
    private final String name;
    private List<Item> items;

    public Passenger(){
        super();
        this.name = "";
    }

    public Passenger(int passengerId, String name) {
        this.passengerId = passengerId;
        this.name = name;
        this.items = new ArrayList<>();
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Item getItem(int index){
        return items.get(index);
    }

    public void addItem(Item item){
        items.add(item);
    }

    public Item removeItem(int index){
        return items.remove(index);
    }

    public int getBaggageWeight(){
        int weight=0;
        for (Item item: items) {
            weight+=item.getItemWeight();
        }
        return weight;
    }

    public String getName(){
        return name;
    }

    public int getPassengerID() {
        return passengerId;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj != null && obj.getClass() == getClass()) {
            Passenger p = (Passenger) obj;
            return p.passengerId == this.passengerId;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 31 * passengerId;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", passengerID=" + passengerId +
                '}';
    }
}
