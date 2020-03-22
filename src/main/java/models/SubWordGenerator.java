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

    public List<String> generate(PhoneNumber phoneNumber, String word) {
        boolean foundMatchedWord = false;
        for (int startIndex = 0; !foundMatchedWord && startIndex < phoneNumber.getValue().length(); startIndex++) {
            for (int endIndex = startIndex + 1; endIndex <= phoneNumber.getValue().length(); endIndex++) {
                List<String> subWordMatch = getSubMatchedWord(phoneNumber.getValue().substring(startIndex, endIndex));
                if (subWordMatch.size() > 0) {
                    word += subWordMatch.get(0);
                    if (endIndex < phoneNumber.getValue().length()) {
                        word += phoneNumber.getValue().charAt(endIndex++);
                        if (endIndex < phoneNumber.getValue().length())
                            return generate(new PhoneNumber(phoneNumber.getValue().substring(endIndex)), word);
                    }
                    if (endIndex >= phoneNumber.getValue().length()) {
                        matchedSubWords.add(word);
                        foundMatchedWord = true;
                        break;
                    }
                }
            }
        }
        return matchedSubWords;
    }

    private List<String> getSubMatchedWord(String subPhoneNumber) {
        PhoneNumber subPhoneNum = new PhoneNumber(subPhoneNumber);
        WordGenerator wordGenerator = new WordGenerator(dictionary);
        return dictionary.getMatchedWords(wordGenerator.generatePossibleLetterCombinations(subPhoneNum));
    }
}
