package models;

import IO.Input;
import exceptions.NoSuchFileFoundException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SubWordGenerator {
    List<String> matchedSubWords;

    public SubWordGenerator() {
        matchedSubWords = new ArrayList<>();
    }

    public List<String> generateSubMatchedWords(String phoneNumber, String output, int start, int end) throws IOException, NoSuchFileFoundException {
        for (int i = start; i < end; i++) {
            boolean foundMatchedWord = false;
            for (int j = i + 1; j <= end; j++) {
                List<String> subWordMatch = getSubMatchedWord(phoneNumber.substring(i, j));
                if (subWordMatch.size() > 0) {
                    output = output + subWordMatch.get(0);
                    if (j < end) {
                        output = output + phoneNumber.charAt(j++);
                        if (j < end)
                            return generateSubMatchedWords(phoneNumber, output, j, end);
                    }
                    if (j >= end) {
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

    public List<String> getSubMatchedWord(String subPhoneNumber) throws IOException, NoSuchFileFoundException {
        PhoneNumber subPhoneNum = new PhoneNumber(Integer.parseInt(subPhoneNumber));
        Dictionary dictionary = new Dictionary(new Input().loadFile("dictionary.txt", "C:\\Users\\ganjali\\Documents\\Anjali\\Assignment-docstore\\PhoneBook\\src\\main\\java\\data"));
        WordGeneratorUtil wordGeneratorUtil = new WordGeneratorUtil(dictionary);
        return dictionary.getMatchedWords(wordGeneratorUtil.generatePossibleLetterCombinations(subPhoneNum));
    }
}
