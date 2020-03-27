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

    public List<String> generateDictionarySubMatchingWords(PhoneNumber phoneNumber, String word) {
        int phoneNumberLength = phoneNumber.getValue().length();
        for (int startIndex = 0; startIndex < phoneNumberLength; startIndex++) {
            for (int endIndex = startIndex + 1; endIndex <= phoneNumberLength; endIndex++) {
                List<String> subWordMatch = getSubMatchedWord(phoneNumber.getValue().substring(startIndex, endIndex));
                if (subWordMatch.size() > 0) {
                    return handleSubWordMatchFound(phoneNumber.getValue(), subWordMatch, endIndex, word, matchedSubWords);
                }
            }
        }
        return matchedSubWords;
    }

    private List<String> handleSubWordMatchFound(String phoneNumber, List<String> subWordMatch, int endIndex, String word, List<String> matchedSubWords) {
        word += subWordMatch.get(0);
        if (endIndex < phoneNumber.length()) {
            word += phoneNumber.charAt(endIndex++);
            if (endIndex < phoneNumber.length())
                return generateDictionarySubMatchingWords(new PhoneNumber(phoneNumber.substring(endIndex)), word);
        }
        matchedSubWords.add(word);
        return matchedSubWords;
    }

    private List<String> getSubMatchedWord(String subPhoneNumber) {
        PhoneNumber subPhoneNum = new PhoneNumber(subPhoneNumber);
        WordGenerator wordGenerator = new WordGenerator(dictionary);
        return dictionary.getMatchedWords(wordGenerator.generatePossibleLetterCombinations(subPhoneNum));
    }
}
