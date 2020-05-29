package by.bsu.service;

import by.bsu.dao.Dao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Service<E, DAO extends Dao<E>> {
    protected static Logger log = LogManager.getLogger();
    protected ArrayList<E> data;
    protected DAO dao;

    public boolean add(E ob){
        try{
            if(ob != null){
                return data.add(ob);
            }
            else {
                return false;
            }
        }catch (NullPointerException e){
            log.error(e);
            return false;
        }finally {
            dao.save(data);
        }
    }

    public ArrayList<E> getAll(){
        return data;
    }

    public E get(int index){
        return data.get(index);
    }

    public void setEl(E el,int index){
        data.set(index,el);
        dao.save(data);
    }

    public boolean delete(){
        System.out.println(getAll());
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        if(index > 0){
            data.remove(index);
            dao.save(data);
            return true;
        }
        return false;
    }
}
