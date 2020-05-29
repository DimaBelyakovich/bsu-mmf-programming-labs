package by.bsu.model.entity;

import java.util.StringJoiner;

public abstract class RailTransport extends Entity{
    private int transportId;
    //private String name;
    private String color;

    public abstract class BuilderBase <T extends BuilderBase<T>>{
        abstract T This();

        public T transportID(int transportID) {
            RailTransport.this.transportId = transportID;
            return This();
        }

        public T color(String color) {
            RailTransport.this.color = color;
            return This();
        }

        public abstract RailTransport build();
    }

    public int getTransportId() {
        return transportId;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RailTransport.class.getSimpleName() + "[", "]")
                .add("transportId=" + transportId)
                .add("color='" + color + "'")
                .toString();
    }


}
