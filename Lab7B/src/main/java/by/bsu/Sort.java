package by.bsu;

import by.bsu.components.Text;
import by.bsu.components.Word;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sort {

    public static List<Word> sorting(Text text){
        List<String> WordsString = new ArrayList<>();
        String regax = "^(?ui:[аеёиоуыэюя]).*";
        for (int i = 0; i < text.getSentences().size(); i++) {
            for (int j = 0; j < text.getSentences().get(i).getWords().size(); j++) {
                WordsString.add(text.getSentences().get(i).getWords().get(j).getValue());
            }
        }

        List<String> vowels = new ArrayList<>();
        for (String item: WordsString) {
            if(item.matches(regax)){
                vowels.add(item);
            }
        }
        vowels.removeIf(e->e.length()==1);

        Collections.sort(vowels, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char s1 = o1.charAt(1);
                char s2 = o2.charAt(1);
                if(s1<s2){
                    return -1;
                }else{
                    return 1;
                }
            }
        });

        List<Word> sorted = new ArrayList<>();
        vowels.stream().map(e->sorted.add(new Word(e))).collect(Collectors.toList());

        return sorted;
    }
}
