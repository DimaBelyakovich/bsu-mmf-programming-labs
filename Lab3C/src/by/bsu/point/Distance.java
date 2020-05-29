package by.bsu.point;

import java.util.StringJoiner;

public class Distance {
    public double calculateDistance(ComplexPoint p1, ComplexPoint p2){
        int cx = p2.getX()-p1.getX();
        int cy = p2.getY()-p1.getY();
        return Math.sqrt(cx*cx + cy*cy);
    }

    public double calculateDistance(ComplexPoint p1){
        return Math.hypot(p1.getX(),p1.getY());
    }
}
