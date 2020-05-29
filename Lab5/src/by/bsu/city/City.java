package by.bsu.city;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class City {
    static Logger log = LogManager.getLogger();

    private String name;
    private CityTypes type;
    private int population;
    private List<Street> streets;

    public void streets() {
    }

    public class Street{

        private String name;
        private int numOfLanes;
        private StreetTypes type;
        private boolean deadEnd;

        public Street(){
            super();
        }

        public Street(String name, int numOfLanes){
            this.name = name;
            this.type = StreetTypes.getType(numOfLanes);
            this.deadEnd = false;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setNumOfLanes(int num){
            this.numOfLanes = num;
            this.type = StreetTypes.getType(num);
        }

        private void setDeadEnd(boolean type){
            this.deadEnd = type;
        }

        public boolean isDeadEnd() {
            return deadEnd;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Street.class.getSimpleName() + "[", "]")
                    .add("name='" + name + "'")
                    .add("numOfLanes=" + numOfLanes)
                    .add("type='" + type + "'")
                    .add("deadEnd=" + deadEnd)
                    .toString();
        }
    }

    private City(){
        super();
    }

    public static class CityBuilder{
        private String name;
        private CityTypes type;
        private int population;
        private List<Street> streets;

        public CityBuilder(String name){
            this.name = name;
            this.streets = new ArrayList<>();
        }

        public CityBuilder setPopulation(int population){
            this.population = population;
            this.type = CityTypes.getType(population);
            return this;
        }

        public City build(){
            City city = new City();

            city.streets = this.streets;
            city.type = this.type;
            city.name = this.name;
            city.population = this.population;

            return city;
        }
    }

    public City(String name, int population) {
        this.name = name;
        this.population = population;
        this.type = CityTypes.getType(population);
        this.streets = new ArrayList<>();
        log.info("created");
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
        this.type = CityTypes.getType(population);
    }

    public void setStreets(){
        Scanner scan = new Scanner(System.in);
        Street st = new Street();

        end:
        while (true){
            System.out.println("1. Input Street\n0. Exit");
            int choice = scan.nextInt();
            switch (choice){
                case 1:
                    boolean bn = false;
                    System.out.println("Name: ");
                    st.setName(scan.next());
                    System.out.println("Num of lanes");
                    st.setNumOfLanes(scan.nextInt());
                    System.out.println("Dead end?");
                    bn=scan.nextBoolean();
                    st.setDeadEnd(bn);

                    streets.add(st);
                    log.info("Street added successfully");
                    break;
                case 0:
                    break end;
                default: continue;
            }
        }
    }

    public List<Street> getStreets() {
        return streets;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", City.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("type='" + type + "'")
                .add("population=" + population)
                .add("streets=" + streets)
                .toString();
    }
}
