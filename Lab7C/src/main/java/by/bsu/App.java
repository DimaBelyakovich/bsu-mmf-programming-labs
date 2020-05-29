package by.bsu;

import by.bsu.dao.Dao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Scanner;

public class App {
    private static Logger logger = LogManager.getLogger();
    private static Scanner scanner = new Scanner(System.in);

    public static void main( String[] args ) {
        String text = Dao.reader(new File("data/code.txt"));
        System.out.println(text);
        System.out.println("----------");
        String newText = SepString.characterize(text, 15);
        System.out.println(newText);
        Dao.saver(newText,"data/outCode.txt");
    }
}
