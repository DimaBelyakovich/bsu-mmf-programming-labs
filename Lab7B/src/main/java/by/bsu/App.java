package by.bsu;

import by.bsu.components.Text;
import by.bsu.dao.Dao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class App {
    private static Logger logger = LogManager.getLogger();

    public static void main( String[] args ) {
        String textFile = Dao.reader(new File("data/code.txt"));
        Text text = new Text(textFile);
        System.out.println(text);
        System.out.println(Sort.sorting(text));
        Dao.saver(Sort.sorting(text),"data/outCode.txt");
    }
}
