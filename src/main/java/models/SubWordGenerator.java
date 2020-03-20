package models;

import exceptions.NoSuchFileFoundException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SubWordGenerator {
    List<String> matchedSubWords;
    Dictionary dictionary;

    public SubWordGenerator(Dictionary dictionary) {
        matchedSubWords = new ArrayList<>();
        this.dictionary = dictionary;
    }

    public List<String> generateSubMatchedWords(String phoneNumber, String output, int start, int end) throws IOException, NoSuchFileFoundException {
        for (int startIndex = start; startIndex < end; startIndex++) {
            boolean foundMatchedWord = false;
            for (int endIndex = startIndex + 1; endIndex <= end; endIndex++) {
                List<String> subWordMatch = getSubMatchedWord(phoneNumber.substring(startIndex, endIndex));
                if (subWordMatch.size() > 0) {
                    output = output + subWordMatch.get(0);
                    if (endIndex < end) {
                        output = output + phoneNumber.charAt(endIndex++);
                        if (endIndex < end)
                            return generateSubMatchedWords(phoneNumber, output, endIndex, end);
                    }
                    if (endIndex >= end) {
                        matchedSubWords.add(output);
                        foundMatchedWord = true;
                        break;
                    }
                }
            }
            if (foundMatchedWord)
                break;
        }
        return matchedSubWords;
    }

    public List<String> getSubMatchedWord(String subPhoneNumber) {
        PhoneNumber subPhoneNum = new PhoneNumber(Integer.parseInt(subPhoneNumber));
        WordGeneratorUtil wordGeneratorUtil = new WordGeneratorUtil(dictionary);
        return dictionary.getMatchedWords(wordGeneratorUtil.generatePossibleLetterCombinations(subPhoneNum));
    }
}
