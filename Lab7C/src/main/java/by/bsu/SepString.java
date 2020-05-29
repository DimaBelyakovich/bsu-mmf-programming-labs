package by.bsu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class SepString {
    private static String newText = "";
    private static Logger logger = LogManager.getLogger();

    public static String characterize(String text, int strLength){
        List<String> words = new ArrayList<>();
        for (String item: text.split("\\s+")) {
            words.add(item);
        }

        String line = "";
        int lineLength = 0;

        for (String word: words) {
            lineLength += word.length();
            if(lineLength <= strLength){
                line = line + word + " ";
                lineLength ++;

                if(word == words.get(words.size()-1)){
                    newText += line;
                }
            }else{
                line += "\n";
                newText += line;
                line = word + " ";
                lineLength = line.length() ;
                if(word == words.get(words.size()-1)){
                    newText += line;
                }
            }
        }
        return newText;
    }
}
