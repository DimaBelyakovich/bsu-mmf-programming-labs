package by.bsu.dao;

import by.bsu.Item;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Dao {
    private static List<Item> text = new ArrayList<>();
    private static Logger logger = LogManager.getLogger();

    public static List<Item> reader(File file){
        try(Scanner fin = new Scanner(file)) {
            while(fin.hasNext()){
                Item item = new Item(fin.next().toLowerCase());
                text.add(item);
            }
            logger.info("load successful");
        } catch (FileNotFoundException e) {
            logger.error(e);
        }finally {
            return text;
        }
    }

    public static void saver(List<Item> text, String path){
        try {
            Files.write(Paths.get(path),
                    text.stream().map(e->e.getItemName() +":"+ e.getItemHash()).collect(Collectors.toList()),
                    StandardCharsets.UTF_8);
        }catch (IOException e){
            logger.error(e);
        }
    }
}
