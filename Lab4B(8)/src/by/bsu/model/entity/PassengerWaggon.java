package by.bsu.model.entity;

import by.bsu.model.ComfortLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class PassengerWaggon extends RailTransport {
    private int numberOfSeats;
    private ComfortLevel comfort;
    private List<Passenger> passengers;

    private PassengerWaggon() {
        passengers = new ArrayList<>();
    }

    public static BuilderSub newPassengerWaggon() {
        return new PassengerWaggon().new BuilderSub();
    }

    public class BuilderSub extends RailTransport.BuilderBase<BuilderSub> {

        public BuilderSub numberOfSeats(int numberOfSeats) {
            PassengerWaggon.this.numberOfSeats = numberOfSeats;
            return this;
        }

        public BuilderSub comfort(ComfortLevel comfort) {
            PassengerWaggon.this.comfort = comfort;
            return this;
        }

        @Override
        BuilderSub This() {
            return this;
        }

        @Override
        public PassengerWaggon build() {
            return PassengerWaggon.this;
        }
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public ComfortLevel getComfort() {
        return comfort;
    }

    public int getCountPassengers() {
        return passengers.size();
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void addPassenger(Passenger p){
        if(passengers.size()==numberOfSeats){
            throw new RuntimeException("all places have already reserved");
        }
        passengers.add(p);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PassengerWaggon.class.getSimpleName() + "[", "]")
                .add("numberOfSeats=" + numberOfSeats)
                .add("comfort=" + comfort)
                .add("passengers=" + passengers)
                .toString();
    }
}
