package by.bsu.dao;

import by.bsu.model.entity.Train;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;

public class TrainDao {
    private static final String dir = "data/train.dat";
    static Logger log = LogManager.getLogger();
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private ArrayList<Train> data;

    public TrainDao() {
        this.data = new ArrayList<>();
    }

    public void save(){

        try{
            outputStream = new ObjectOutputStream(new FileOutputStream(dir));
            for (Train item: data) {
                saveSerial(item, outputStream);
            }
            outputStream.writeObject(data);
            log.info(data.size() + " objects SAVED successfully");
            outputStream.close();
        }
        catch (IOException e){
            log.error(e);
        }
    }

    public void load(){
        try{
            inputStream = new ObjectInputStream(new FileInputStream(dir));
            log.info(inputStream);
            data = (ArrayList<Train>)inputStream.readObject();
            for (Train item: data) {
                loadSerial(item, inputStream);
            }
            log.info( data.size() + " objects LOADED successfully");
            inputStream.close();
        }
        catch (IOException e){
            log.error(e);
        }
        catch (ClassNotFoundException e){
            log.error(e);
        }
    }

    public  void create(Train entity){
        data.add(entity);
        log.info(entity + " added");
    }

    private void saveSerial(Train train, ObjectOutputStream oos) throws IOException{
        train.serializeStatic(oos);
    }

    public void loadSerial(Train train, ObjectInputStream ois)throws IOException, ClassNotFoundException{
        train.deserializeStatic(ois);
    }

    public ArrayList<Train> getAll(){
        return data;
    }

}
