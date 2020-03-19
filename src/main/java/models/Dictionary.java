package models;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {
    List<String> words;

    public Dictionary(List<String> words) {
        this.words = words;
    }

    public boolean match(String word) {
        return words.stream().anyMatch(word::equalsIgnoreCase);
    }

    public List<String> getMatchedWords(List<String> letterCombinations) {
        List<String> dictionaryMatchingWords = new ArrayList<>();
        for (String word : letterCombinations) {
            if (match(word))
                dictionaryMatchingWords.add(word);
        }
        return dictionaryMatchingWords;
    }
}
