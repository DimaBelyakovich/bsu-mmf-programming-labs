package by.bsu.dao;

import by.bsu.figure.Polygon;

public class PolygonDao extends Dao<Polygon> {
    private static final String dir = "data/polygon.dat";
    @Override
    public String getDir() {
        return dir;
    }
}
