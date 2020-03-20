package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WordGenerator {
    Dictionary dictionary;
    Map<Integer, String> keypad = Map.of(
            0, "",
            1, "",
            2, "ABC",
            3, "DEF",
            4, "GHI",
            5, "JKL",
            6, "MNO",
            7, "PQRS",
            8, "TUV",
            9, "WXYZ"
    );
    SubWordGenerator subWordGenerator;

    public WordGenerator(Dictionary dictionary) {
        this.dictionary = dictionary;
    }


    public List<String> generateWords(String phoneNumber) {
        List<String> matchedWords = dictionary.getMatchedWords(this.generatePossibleLetterCombinations(new PhoneNumber(Integer.parseInt(phoneNumber))));
        if (matchedWords.size() == 0) {
            subWordGenerator = new SubWordGenerator(dictionary);
            return subWordGenerator.generateSubWords(phoneNumber, "");
        }
        return matchedWords;
    }

    public List<String> generatePossibleLetterCombinations(PhoneNumber phoneNumber) {
        List<Integer> digitsOfPhoneNumber = phoneNumber.getDigits();
        return letterCombinations(digitsOfPhoneNumber, 0, "", new ArrayList<>());
    }

    private List<String> letterCombinations(List<Integer> digitsOfPhoneNumber, int currentDigit, String letterCombination, List<String> letterCombinations) {
        for (Character keypadCharacter : keypad.get(digitsOfPhoneNumber.get(currentDigit)).toCharArray()) {
            if (currentDigit == digitsOfPhoneNumber.size() - 1) {
                letterCombinations.add(letterCombination + keypadCharacter);
            } else {
                letterCombinations(digitsOfPhoneNumber, currentDigit + 1, letterCombination + keypadCharacter, letterCombinations);
            }
        }
        return letterCombinations;
    }
}