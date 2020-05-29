package by.bsu.model.entity;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Train extends Entity{
    private final String idTrain;
    private static RailTransport head;
    private List<PassengerWaggon> waggons;

    public Train(){
        super();
        idTrain= UUID.randomUUID().toString();
    }

    public Train(RailTransport head, List<PassengerWaggon> waggons) {
        idTrain= UUID.randomUUID().toString();
        this.head = head;
        this.waggons = waggons;
    }

    public String getIdTrain(){
        return idTrain;
    }

    public RailTransport getHead() {
        return head;
    }

    public void setHead(Locomotive head) {
        this.head = head;
    }

    public List<PassengerWaggon> getWaggons() {
        return waggons;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj != null && obj.getClass() == getClass()) {
            Train t = (Train) obj;
            return this.idTrain == t.idTrain;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTrain) * 59;
    }

    @Override
    public String toString() {
        return "Train №: " + idTrain +
                "\nTraction: " + head.toString() +
                "\nNumber of waggons: " + waggons.size()+
                "\nWaggons: "+ waggons.toString();
    }

    public static void serializeStatic(ObjectOutputStream oos) throws IOException {
        oos.writeObject(head);
    }

    public static void deserializeStatic(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        //n=ois.readInt();
        head = (RailTransport) ois.readObject();
    }
}
