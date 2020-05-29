package by.bsu.figure;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.StringJoiner;

public class Polygon {
    private double x[] = {1,1,2,2};
    private double y[] = {1,2,2,1};
    public String color = "black";
    static Logger log = LogManager.getLogger();
    private final int n=4;
    Point[] square = new Point[n];

    public Polygon(){
        for (int i = 0; i < n; i++) {
            square[i] = new Point();
            square[i].setpX(x[i]);
            square[i].setpY(y[i]);
        }
    }

    public void setVertex(Point p, int i){
        if(i<4 && i>=0){
            square[i]=p;
        }
    }

    public Point getVertex(int i){
        if(i<4 && i>=0){
            return square[i];
        }else{
            return null;
        }
    }

    public Line getEdge(int i){
        int end;
        if(i+1>=n){
            end = 0;
        }else {
            end = i+1;
        }
        return new Line(square[i],square[end]);
    }

    public void setColor(String color){
        for (int i = 0; i < n; i++) {
            square[i].setColor(color);
        }
        this.color = color;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Polygon.class.getSimpleName() + "[", "]")
                .add("square=" + Arrays.toString(square))
                .add("color="+color)
                .toString();
    }
}
