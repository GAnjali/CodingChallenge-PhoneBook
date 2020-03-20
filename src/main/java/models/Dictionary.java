package models;

import java.util.List;
import java.util.stream.Collectors;

public class Dictionary {
    List<String> words;

    public Dictionary(List<String> words) {
        this.words = words;
    }

    public boolean match(String word) {
        return words.stream().anyMatch(word::equalsIgnoreCase);
    }

    public List<String> getMatchedWords(List<String> letterCombinations) {
        return letterCombinations.stream().filter(this::match).collect(Collectors.toList());
    }
}
