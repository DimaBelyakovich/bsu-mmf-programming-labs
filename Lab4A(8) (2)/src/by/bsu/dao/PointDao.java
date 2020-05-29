package by.bsu.dao;

import by.bsu.figure.Point;

public class PointDao extends Dao<Point> {
    private static final String dir = "data/point.dat";


    @Override
    public String getDir() {
        return dir;
    }
}
