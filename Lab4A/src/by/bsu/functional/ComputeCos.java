package by.bsu.functional;

import by.bsu.figure.Point;

public class ComputeCos {
    public static double cos(Point vA, Point vB){
        double up = vA.getpX()*vB.getpX()+vA.getpY()*vB.getpY();
        double down = Math.sqrt(Math.pow(vA.getpX(),2)+Math.pow(vA.getpY(),2))*Math.sqrt(Math.pow(vB.getpX(),2)+Math.pow(vB.getpY(),2));
        return up/down;
    }
}
