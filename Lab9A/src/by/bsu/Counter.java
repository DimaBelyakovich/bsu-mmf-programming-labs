package by.bsu;

import java.util.HashMap;
import java.util.Map;

public class Counter {
    private static Map<String, Integer> countWords = new HashMap<String, Integer>();
    private static Map<String, Integer> countLetters = new HashMap<String, Integer>();

    public static Map<String, Integer> words(String poem){
        String poemNew = poem.toLowerCase().replaceAll("\\,|\\.|\\-","");

        for (String str: poemNew.split(" ")) {
            if(countWords.containsKey(str)){
                countWords.put(str,countWords.get(str)+1);
            }else{
                countWords.put(str,0);
            }
        }
        return countWords;
    }

    public static Map<String, Integer> letters(String poem){
        String poemNew = poem.toLowerCase().replaceAll("\\,.- ","");

        for (String ch: poemNew.split("")) {
            if(countLetters.containsKey(ch)){
                countLetters.put(ch,countLetters.get(ch)+1);
            }else{
                countLetters.put(ch,0);
            }
        }
        return countLetters;
    }
}
