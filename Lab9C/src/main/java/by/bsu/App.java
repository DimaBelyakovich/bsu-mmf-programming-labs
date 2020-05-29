package by.bsu;

import by.bsu.dao.Dao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.List;

public class App {
    private static Logger logger = LogManager.getLogger();

    public static void main( String[] args ) {
        List<String> line = Dao.reader(new File("data/code.txt"));
        line.forEach(oldStr-> System.out.println(oldStr));
        System.out.println("--------------------------------");
        List<String> newCode = CommentOut.delComments(line);
        newCode.forEach(str-> System.out.println(str));
        Dao.saver(newCode,"data/outCode.txt");
    }
}
