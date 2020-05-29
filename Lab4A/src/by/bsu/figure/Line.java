package by.bsu.figure;

import java.util.StringJoiner;

public class Line extends Point {
    private double xEnd;
    private double yEnd;
    private String color = "black";

    public Line(){
        super();
    }

    public Line(Point start, Point end){
        super.setpX(start.getpX());
        super.setpY(start.getpY());
        xEnd = end.getpX();
        yEnd = end.getpY();
    }

    public Line(double x, double y) {
        this.xEnd = x;
        this.yEnd = y;
    }

    public Point getPointStart(){
        return new Point(super.getpX(),super.getpY());
    }

    public Point setPointEnd(){
        return new Point(xEnd,yEnd);
    }

    public double getxEnd() {
        return xEnd;
    }

    public void setxEnd(double xEnd) {
        this.xEnd = xEnd;
    }

    public double getyEnd() {
        return yEnd;
    }

    public void setyEnd(double yEnd) {
        this.yEnd = yEnd;
    }

    public double getxStart(){
        return super.getpX();
    }

    public double getyStart(){
        return super.getpY();
    }

    public void setColor(String color){
        this.color = color;
    }

    public double length(){
        return Math.hypot(xEnd-super.getpX(),yEnd-super.getpY());
    }
    @Override
    public String toString() {
        return new StringJoiner(", ", Line.class.getSimpleName() + "[", "]")
                .add("xStart="+super.getpX())
                .add("yStart="+super.getpY())
                .add("xEnd=" + xEnd)
                .add("yEnd=" + yEnd)
                .add("length="+length())
                .add("color='" + color + "'")
                .toString();
    }
}
