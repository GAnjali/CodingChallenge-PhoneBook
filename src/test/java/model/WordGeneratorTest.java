package model;

import IO.Input;
import models.Dictionary;
import models.PhoneNumber;
import models.WordGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static helper.PhoneBookConstants.DATA_PATH;

public class WordGeneratorTest {
    private WordGenerator wordGenerator;
    private PhoneNumber phoneNumber;

    @Before
    public void init() throws IOException {
        Input input = new Input();
        Dictionary dictionary = new Dictionary(input.loadFile(DATA_PATH));
        wordGenerator = new WordGenerator(dictionary);
        phoneNumber = new PhoneNumber(2255);
    }

    @Test
    public void shouldReturnListOfWordsWhenCalledGeneratePossibleWords() {
        Assert.assertNotNull(wordGenerator.generatePossibleWords(phoneNumber));
    }

    @Test
    public void shouldReturnDictionaryMatchedListOfWordsWhenCalledGetDictionaryWords() {
        Assert.assertTrue(wordGenerator.getDictionaryWords(phoneNumber).contains("CALL"));
    }
}
