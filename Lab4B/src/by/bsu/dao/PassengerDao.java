package by.bsu.dao;

public class PassengerDao extends Dao{
    private static final String dir = "data/passenger.dat";

    @Override
    public String getDir() {
        return dir;
    }
}
