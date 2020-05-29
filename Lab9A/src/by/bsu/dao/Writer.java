package by.bsu.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;

public class Writer {
    private static Logger logger = LogManager.getLogger();

    public static void writer(Map<String, Integer> map, String path){
        try{
            Files.write(Paths.get(path),
                        map.entrySet().stream().map(k->k.getKey()+":"+k.getValue()).collect(Collectors.toList()),
                        StandardCharsets.UTF_8);

            boolean isFileExist = new File(path).exists();
            if(isFileExist){
                logger.info("good");
            }

        } catch (IOException e) {
            logger.error(e);
        }
    }
}
