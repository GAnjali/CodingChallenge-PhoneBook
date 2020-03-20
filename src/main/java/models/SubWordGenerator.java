package models;

import java.util.ArrayList;
import java.util.List;

public class SubWordGenerator {
    List<String> matchedSubWords;
    Dictionary dictionary;

    public SubWordGenerator(Dictionary dictionary) {
        matchedSubWords = new ArrayList<>();
        this.dictionary = dictionary;
    }


    public List<String> generateSubWords(String phoneNumber, String output) {
        boolean foundMatchedWord = false;
        for (int startIndex = 0; !foundMatchedWord && startIndex < phoneNumber.length(); startIndex++) {
            for (int endIndex = startIndex + 1; endIndex <= phoneNumber.length(); endIndex++) {
                List<String> subWordMatch = getSubMatchedWord(phoneNumber.substring(startIndex, endIndex));
                if (subWordMatch.size() > 0) {
                    output = output + subWordMatch.get(0);
                    if (endIndex < phoneNumber.length()) {
                        output = output + phoneNumber.charAt(endIndex++);
                        if (endIndex < phoneNumber.length())
                            return generateSubWords(phoneNumber.substring(endIndex), output);
                    }
                    if (endIndex >= phoneNumber.length()) {
                        matchedSubWords.add(output);
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
