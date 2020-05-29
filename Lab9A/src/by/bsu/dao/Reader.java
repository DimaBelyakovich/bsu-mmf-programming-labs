package by.bsu.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {
    private static String poem = "";
    private static Logger logger = LogManager.getLogger();

    public static String reader(File file){
        try(Scanner fin = new Scanner(file)) {
            while(fin.hasNext()){
                poem += fin.next() + " ";
            }
        } catch (FileNotFoundException e) {
            logger.error(e);
        }finally {
            return poem;
        }
    }
}
