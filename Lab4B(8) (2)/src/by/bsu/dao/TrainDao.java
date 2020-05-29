package by.bsu.dao;

public class TrainDao extends Dao {
    private static final String dir = "data/train.dat";

    @Override
    public String getDir() {
        return dir;
    }
}
