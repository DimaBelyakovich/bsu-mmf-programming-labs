package by.bsu.components;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Sentence{
    private List<Word> words;

    public Sentence(String sentence) {
        this.words = new ArrayList<Word>();
        formation(sentence);
    }

    private void formation(String sentence){
        String regax = "[,:;\\-\\s\\n]";
        for (String word: sentence.split(regax)) {
            Word wordCl = new Word(word);
            words.add(wordCl);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Sentence.class.getSimpleName() + "[", "]\n")
                .add("words=" + words)
                .toString();
    }

    public List<Word> getWords() {
        return words;
    }
}
