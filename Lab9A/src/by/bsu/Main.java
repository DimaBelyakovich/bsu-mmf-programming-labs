package by.bsu;

import by.bsu.dao.Reader;
import by.bsu.dao.Writer;

import java.io.*;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Map<String, Integer> wordsMap = Counter.words(Reader.reader(new File("data/poem.txt")));
        System.out.println(wordsMap);
        Map<String, Integer> lettersMap = Counter.letters(Reader.reader(new File("data/poem.txt")));
        System.out.println(lettersMap);

        Writer.writer(wordsMap, "data/wordsOut.txt");
        Writer.writer(lettersMap, "data/lettersOut.txt");
    }
}
