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
    }

    public List<String> generateDictionaryMatchingWords(PhoneNumber phoneNumber) {
        List<String> letterCombinations = generatePossibleLetterCombinations(phoneNumber);
        List<String> dictionaryMatchingWords = dictionary.getMatchedWords(letterCombinations);
        if (dictionaryMatchingWords.size() == 0) {
            subWordGenerator = new SubWordGenerator(dictionary);
            return subWordGenerator.generateDictionarySubMatchingWords(phoneNumber, "");
        }
        return dictionaryMatchingWords;
    }

    public List<String> generatePossibleLetterCombinations(PhoneNumber phoneNumber) {
        List<Integer> digitsOfPhoneNumber = phoneNumber.getDigits();
        return getLetterCombinations(digitsOfPhoneNumber, 0, "", new ArrayList<>());
    }

    private List<String> getLetterCombinations(List<Integer> digitsOfPhoneNumber, int currentDigit, String letterCombination, List<String> letterCombinations) {
        String keypadCharactersOfDigit = keypad.get(digitsOfPhoneNumber.get(currentDigit));
        if (keypadCharactersOfDigit == null) {
            handleNoMatchInKeyPadForCurrentDigit(digitsOfPhoneNumber, currentDigit, letterCombination, letterCombinations);
        } else {
            handleMatchInKeyPadForCurrentDigit(keypadCharactersOfDigit, digitsOfPhoneNumber, currentDigit, letterCombination, letterCombinations);
        }
        return letterCombinations;
    }

    private void handleNoMatchInKeyPadForCurrentDigit(List<Integer> digitsOfPhoneNumber, int currentDigit, String letterCombination, List<String> letterCombinations) {
        getLetterCombinations(digitsOfPhoneNumber, currentDigit + 1, letterCombination + digitsOfPhoneNumber.get(currentDigit), letterCombinations);
    }

    private void handleMatchInKeyPadForCurrentDigit(String keypadCharactersOfDigit, List<Integer> digitsOfPhoneNumber, int currentDigit, String letterCombination, List<String> letterCombinations) {
        for (Character keypadCharacter : keypadCharactersOfDigit.toCharArray()) {
            if (currentDigit == digitsOfPhoneNumber.size() - 1) {
                letterCombinations.add(letterCombination + keypadCharacter);
            } else {
                getLetterCombinations(digitsOfPhoneNumber, currentDigit + 1, letterCombination + keypadCharacter, letterCombinations);
            }
        }
    }
}