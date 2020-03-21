package models;

import java.util.ArrayList;
import java.util.List;

public class SubWordGenerator {
    private final Dictionary dictionary;
    private List<String> matchedSubWords;

    public SubWordGenerator(Dictionary dictionary) {
        this.dictionary = dictionary;
        matchedSubWords = new ArrayList<>();
    }

    public List<String> generateSubWords(String phoneNumber, String word) {
        boolean foundMatchedWord = false;
        for (int startIndex = 0; !foundMatchedWord && startIndex < phoneNumber.length(); startIndex++) {
            for (int endIndex = startIndex + 1; endIndex <= phoneNumber.length(); endIndex++) {
                List<String> subWordMatch = getSubMatchedWord(phoneNumber.substring(startIndex, endIndex));
                if (subWordMatch.size() > 0) {
                    word += subWordMatch.get(0);
                    if (endIndex < phoneNumber.length()) {
                        word += phoneNumber.charAt(endIndex++);
                        if (endIndex < phoneNumber.length())
                            return generateSubWords(phoneNumber.substring(endIndex), word);
                    }
                    if (endIndex >= phoneNumber.length()) {
                        matchedSubWords.add(word);
                        foundMatchedWord = true;
                        break;
                    }
                }
            }
        }
        return matchedSubWords;
    }

    public List<String> getSubMatchedWord(String subPhoneNumber) {
        PhoneNumber subPhoneNum = new PhoneNumber(subPhoneNumber);
        WordGenerator wordGenerator = new WordGenerator(dictionary);
        return dictionary.getMatchedWords(wordGenerator.generatePossibleLetterCombinations(subPhoneNum));
    }
}
