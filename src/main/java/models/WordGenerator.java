package models;

import exceptions.NoSuchFileFoundException;

import java.io.IOException;
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
    List<String> matchedWords;
    List<String> outputSubWords;
    SubWordGenerator subWordGenerator;

    public WordGenerator(Dictionary dictionary) {
        this.dictionary = dictionary;
        matchedWords = new ArrayList<>();
    }

    public List<String> generateWord(String phoneNumber) throws IOException, NoSuchFileFoundException {
        List<String> matchedWords = dictionary.getMatchedWords(this.generatePossibleLetterCombinations(new PhoneNumber(Integer.parseInt(phoneNumber))));
        if (matchedWords.size() == 0) {
            outputSubWords = new ArrayList<>();
            subWordGenerator = new SubWordGenerator(dictionary);
            return subWordGenerator.generateSubMatchedWords(phoneNumber, "", 0, phoneNumber.length());
        }
        return matchedWords;
    }

    public List<String> generatePossibleLetterCombinations(PhoneNumber phoneNumber) {
        List<Integer> digitsOfPhoneNumber = phoneNumber.getDigits();
        letterCombinations(digitsOfPhoneNumber, 0, "", phoneNumber.getPhoneNumber().toString().length());
        return matchedWords;
    }

    private void letterCombinations(List<Integer> digitsOfPhoneNumber, int currentDigit, String word, int phoneNumberLength) {
        for (Character keypadCharacter : keypad.get(digitsOfPhoneNumber.get(currentDigit)).toCharArray()) {
            if (currentDigit == phoneNumberLength - 1) {
                matchedWords.add(word + keypadCharacter);
            } else {
                letterCombinations(digitsOfPhoneNumber, currentDigit + 1, word + keypadCharacter, phoneNumberLength);
            }
        }
    }
}