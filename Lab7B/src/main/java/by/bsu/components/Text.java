package by.bsu.components;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Text {
    private List<Sentence> sentences = new ArrayList<>();

    public Text(String text) {
        formation(text);
    }

    private void formation(String text){
        String regax = "[.!?]";
        for (String sentence: text.split(regax)) {
            String sentenceTmp = "";

            if(sentence.indexOf("\n")!=-1 || sentence.indexOf("\n\n")!=-1){
                sentenceTmp = sentence.replace("\n","")
                                      .replace("\n\n", "")
                                      .replace("\r","");
            }

            Sentence sentenceCl = new Sentence(sentenceTmp);
            sentences.add(sentenceCl);
        }
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        return new StringJoiner(",", Text.class.getSimpleName() + "[", "]")
                .add("sentences=" + sentences)
                .toString();
    }
}
