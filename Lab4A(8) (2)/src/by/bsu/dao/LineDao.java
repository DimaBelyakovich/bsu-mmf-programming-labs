package by.bsu.dao;

import by.bsu.figure.Line;

public class LineDao extends Dao<Line> {
    private static final String dir = "data/line.dat";
    @Override
    public String getDir() {
        return dir;
    }
}
