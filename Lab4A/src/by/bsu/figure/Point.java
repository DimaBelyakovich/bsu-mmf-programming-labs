package by.bsu.figure;

import java.util.Objects;
import java.util.StringJoiner;

public class Point {
    private double pX;
    private double pY;
    private String color = "black";

    public Point(){
        super();
    }

    public Point(double pX, double pY) {
        this.pX = pX;
        this.pY = pY;
    }

    public double getpX() {
        return pX;
    }

    public void setpX(double pX) {
        this.pX = pX;
    }

    public double getpY() {
        return pY;
    }

    public void setpY(double pY) {
        this.pY = pY;
    }

    public void setColor(String color){
        this.color = color;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Point.class.getSimpleName() + "[", "]")
                .add("x=" + pX)
                .add("y=" + pY)
                .add("color="+color)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.pX, pX) == 0 &&
                Double.compare(point.pY, pY) == 0 &&
                color.equals(point.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pX, pY, color);
    }
}
