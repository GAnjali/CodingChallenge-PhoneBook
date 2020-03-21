package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WordGenerator {
    private Dictionary dictionary;
    private Map<Integer, String> keypad = Map.of(
            2, "ABC",
            3, "DEF",
            4, "GHI",
            5, "JKL",
            6, "MNO",
            7, "PQRS",
            8, "TUV",
            9, "WXYZ"
    );
    private SubWordGenerator subWordGenerator;

    public WordGenerator(Dictionary dictionary) {
        this.dictionary = dictionary;
        subWordGenerator = new SubWordGenerator(dictionary);
    }

    public List<String> generate(String phoneNumber) {
        List<String> matchedWords = dictionary.getMatchedWords(generatePossibleLetterCombinations(new PhoneNumber(phoneNumber)));
        if (matchedWords.size() == 0) {
            return subWordGenerator.generate(phoneNumber, "");
        }
        return matchedWords;
    }

    public List<String> generatePossibleLetterCombinations(PhoneNumber phoneNumber) {
        List<Integer> digitsOfPhoneNumber = phoneNumber.getDigits();
        return letterCombinations(digitsOfPhoneNumber, 0, "", new ArrayList<>());
    }

    private List<String> letterCombinations(List<Integer> digitsOfPhoneNumber, int currentDigit, String letterCombination, List<String> letterCombinations) {
        String keypadChars = keypad.get(digitsOfPhoneNumber.get(currentDigit));
        if (keypadChars == null) {
            letterCombinations(digitsOfPhoneNumber, currentDigit + 1, letterCombination + digitsOfPhoneNumber.get(currentDigit), letterCombinations);
        } else {
            for (Character keypadCharacter : keypadChars.toCharArray()) {
                if (currentDigit == digitsOfPhoneNumber.size() - 1) {
                    letterCombinations.add(letterCombination + keypadCharacter);
                } else {
                    letterCombinations(digitsOfPhoneNumber, currentDigit + 1, letterCombination + keypadCharacter, letterCombinations);
                }
            }
        }
        return letterCombinations;
    }
}