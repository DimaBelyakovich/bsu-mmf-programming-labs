package by.bsu.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dao {
    private static List<String> code = new ArrayList<>();
    private static Logger logger = LogManager.getLogger();

    public static List<String> reader(File file){
        try(Scanner fin = new Scanner(file)) {

            while(fin.hasNext()){
                String line = fin.nextLine();
                code.add(line+"\n");
            }

            logger.info("load successful");
        } catch (FileNotFoundException e) {
            logger.error(e);
        }finally {
            return code;
        }
    }

    public static void saver(List<String> code, String path){
        try(FileWriter fw = new FileWriter(new File(path))) {
            for (String line: code) {
                fw.write(line);
            }
            fw.flush();
            logger.info("save successful");
        } catch (IOException e) {
            logger.error(e);
        }
    }
}
