package by.bsu;

import by.bsu.city.City;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    static Logger log = LogManager.getLogger();
    public static void main(String[] args) {
        City city = new City("Pinsk", 140_000){
            public void streets(){
                for (Street street: getStreets()) {
                    System.out.println(street);
                }
            }
        };

        System.out.println("Minsk");
        City Minsk = new City.CityBuilder("Minsk").setPopulation(2_000_000).build();
        Minsk.setStreets();
        System.out.println(Minsk);

        System.out.println("Pinsk");
        city.setStreets();
        city.streets();
    }
}
