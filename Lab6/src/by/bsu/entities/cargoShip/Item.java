package by.bsu.entities.cargoShip;

import by.bsu.services.GenerateId;

import java.util.StringJoiner;

public class Item {
    private String name;
    private Double weight;
    private Boolean fragile;
    private long id;

    public Item() {
        super();
        this.id = GenerateId.generateLongId();
    }

    public Item(Double weight, Boolean fragile, String name) {
        this.name = name;
        this.weight = weight;
        this.fragile = fragile;
        this.id = GenerateId.generateLongId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Boolean getFragile() {
        return fragile;
    }

    public void setFragile(Boolean fragile) {
        this.fragile = fragile;
    }

    public long getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Item.class.getSimpleName() + "[", "]")
                .add("name=" + name)
                .add("weight=" + weight)
                .add("fragile=" + fragile)
                .add("id=" + id)
                .toString();
    }


}
