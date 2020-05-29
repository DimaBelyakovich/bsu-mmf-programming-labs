package by.bsu.entities.abstractShip;

public interface IShip {
    public String move();
    public void rename(String name);
    public void load();
    public void unload();
}
