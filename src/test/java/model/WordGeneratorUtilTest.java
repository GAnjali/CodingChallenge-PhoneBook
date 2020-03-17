package model;

import IO.Input;
import exceptions.NoSuchFileFoundException;
import models.Dictionary;
import models.PhoneNumber;
import models.WordGeneratorUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class WordGeneratorUtilTest {
    private WordGeneratorUtil wordGeneratorUtil;
    private PhoneNumber phoneNumber;

    @Before
    public void init() throws IOException, NoSuchFileFoundException {
        Input input = new Input();
        Dictionary dictionary = new Dictionary(input.loadFile("\\dictionary.txt"));
        wordGeneratorUtil = new WordGeneratorUtil(dictionary);
        phoneNumber = new PhoneNumber(2255);
    }

    @Test
    public void shouldReturnDictionaryMatchedListOfWordsWhenCalledGetDictionaryWords() {
        Assert.assertTrue(wordGeneratorUtil.getDictionaryWords(phoneNumber).contains("CALL"));
    }
}
