package by.bsu.dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;


public abstract class Dao<E, K>{

    static Logger log = LogManager.getLogger();
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private ArrayList<E> data;

    public Dao() {
        this.data = new ArrayList<>();
    }

    public void save(){
        try{
            outputStream = new ObjectOutputStream(new FileOutputStream(getDir()));
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
            inputStream = new ObjectInputStream(new FileInputStream(getDir()));
            log.info(inputStream);
            data = (ArrayList<E>)inputStream.readObject();
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

    public  void create(E entity){
        data.add(entity);
        log.info(entity + " added");
    }

    public ArrayList<E> getAll(){
        return data;
    }

    public abstract String getDir();
}
