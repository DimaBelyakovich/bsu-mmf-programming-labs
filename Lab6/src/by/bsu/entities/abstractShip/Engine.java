package by.bsu.entities.abstractShip;

public enum Engine {
    DIESEL(40_000), GAZO_DIESEL(50_000), DOUBLE_TYPE(55_000), PETROL(20_000);

    private Integer power; //kW

    Engine(){ }

    Engine(Integer power){
        this.power = power;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }



}
