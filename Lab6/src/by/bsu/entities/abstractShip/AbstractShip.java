package by.bsu.entities.abstractShip;

import by.bsu.entities.Port;

import java.util.StringJoiner;

public abstract class AbstractShip<T extends Object> implements IShip {
    private String name;
    private T capacity;
    private Double displacement;
    private Engine engine;

    private Port from;
    private Port to;

    public AbstractShip(){
        super();
    }

    public String move(){
        return new StringJoiner(", ", Port.class.getSimpleName() + "[", "]")
                .add("from=" + from)
                .add("to=" + to)
                .toString();
    }

    public void rename(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public T getCapacity() {
        return capacity;
    }

    public void setCapacity(T capacity) {
        this.capacity = capacity;
    }

    public Double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(Double displacement) {
        this.displacement = displacement;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Port getFrom() {
        return from;
    }

    public void setFrom(Port from) {
        this.from = from;
    }

    public Port getTo() {
        return to;
    }

    public void setTo(Port to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", "Ship" + "[", "]")
                .add("name='" + name + "'")
                .add("capacity=" + capacity)
                .add("displacement=" + displacement)
                .add("engine=" + engine)
                .add(move())
                .toString();
    }
}
