package models;

import java.util.List;

public class Dictionary {
    List<String> words;

    public Dictionary(List<String> words) {
        this.words = words;
    }

    public boolean match(String word) {
        return false;
    }
}
