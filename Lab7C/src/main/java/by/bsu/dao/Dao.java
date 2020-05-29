package by.bsu.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Dao {
    private static String text = "";
    private static Logger logger = LogManager.getLogger();

    public static String reader(File file){
        try(Scanner fin = new Scanner(file)) {
            while(fin.hasNext()){
                String line = fin.nextLine();
                text += line;
            }
            logger.info("load successful");
        } catch (FileNotFoundException e) {
            logger.error(e);
        }finally {
            return text;
        }
    }

    public static void saver(String text, String path){
        try {
            Files.write(Paths.get(path),
                    Arrays.stream(text.split("\n")).collect(Collectors.toList()),
                    StandardCharsets.UTF_8);
        }catch (IOException e){
            logger.error(e);
        }
    }
}
