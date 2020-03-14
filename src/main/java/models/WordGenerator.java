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
    List<String> words = new ArrayList<>();

    public WordGenerator(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public List<String> getDictionaryWords(PhoneNumber phoneNumber) {
        List<String> dictionaryMatchingWords = new ArrayList<>();
        List<String> possibleWordsOfPhoneNumber = generatePossibleWords(phoneNumber);
        for (String word : possibleWordsOfPhoneNumber) {
            if (dictionary.match(word))
                dictionaryMatchingWords.add(word);
        }
        return dictionaryMatchingWords;
    }

    public List<String> generatePossibleWords(PhoneNumber phoneNumber) {
        List<Integer> digitsOfPhoneNumber = phoneNumber.getDigits();
        wordMaker(digitsOfPhoneNumber, 0, "", phoneNumber.getPhoneNumber().toString().length());
        return words;
    }

    private void wordMaker(List<Integer> digitsOfPhoneNumber, int currentDigit, String word, int phoneNumberLength) {
        for (Character keypadCharacter : keypad.get(digitsOfPhoneNumber.get(currentDigit)).toCharArray()) {
            if (currentDigit == phoneNumberLength - 1) {
                words.add(word + keypadCharacter);
            } else {
                wordMaker(digitsOfPhoneNumber, currentDigit + 1, word + keypadCharacter, phoneNumberLength);
            }
        }
    }
}