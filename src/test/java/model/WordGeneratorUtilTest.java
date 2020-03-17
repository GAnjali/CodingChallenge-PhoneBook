package model;

import IO.Input;
import exceptions.NoSuchFileFoundException;
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
    public void init() throws IOException, NoSuchFileFoundException {
        Input input = new Input();
        Dictionary dictionary = new Dictionary(input.loadFile("\\dictionary.txt"));
        wordGenerator = new WordGenerator(dictionary);
        phoneNumber = new PhoneNumber(2255);
    }

    @Test
    public void shouldReturnDictionaryMatchedListOfWordsWhenCalledGetDictionaryWords() {
        Assert.assertTrue(wordGenerator.getDictionaryWords(phoneNumber).contains("CALL"));
    }
}
