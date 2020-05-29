package by.bsu.service.functional;

import by.bsu.figure.Line;
import by.bsu.figure.Point;

public class ComputeVector {
    public static Point getVector(Line line){
        double vX = line.getxEnd()-line.getxStart();
        double vY = line.getyEnd()-line.getyStart();
        return new Point(vX,vY);
    }
}
