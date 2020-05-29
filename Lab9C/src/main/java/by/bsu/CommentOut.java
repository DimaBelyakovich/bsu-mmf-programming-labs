package by.bsu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CommentOut {
    private static List<String> newCode = new ArrayList<>();
    private static Logger logger = LogManager.getLogger();

    public static List<String> delComments(List<String> code){

        for (String line: code) {
            if((line.indexOf("/*") != -1)&& (line.indexOf("*/") != -1)){
                newCode.add(line.replace(line.substring(line.indexOf("/*"), line.indexOf("*/")+2),""));
            }else if((line.indexOf("//")!=-1) && (line.indexOf("\n") != -1)){
                newCode.add(line.replace(line.substring(line.indexOf("//"), line.indexOf("\n")), ""));
            }else {
                newCode.add(line);
            }
        }
        return newCode;
    }
}
