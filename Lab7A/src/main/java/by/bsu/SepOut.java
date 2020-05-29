package by.bsu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SepOut {
    private static String newText = "";
    private static Logger logger = LogManager.getLogger();

    public static String delComments(String text, String sepLeft, String sepRight){
        if((text.indexOf(sepLeft)!=-1) && (text.indexOf(sepRight)!=-1)){
            newText = text.replace(text.substring(text.indexOf(sepLeft)+1, text.indexOf(sepRight)),"");
        }
        return newText;
    }
}
