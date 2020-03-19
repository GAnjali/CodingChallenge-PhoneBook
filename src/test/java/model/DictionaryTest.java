package model;

import IO.Input;
import exceptions.NoSuchFileFoundException;
import models.Dictionary;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static helper.PhoneBookConstants.DATA_PATH;

public class DictionaryTest {
    private Dictionary dictionary;

    @Before
    public void init() throws IOException, NoSuchFileFoundException {
        Input input = new Input();
        dictionary = new Dictionary(input.loadFile("dictionary.txt", DATA_PATH));
    }

    @Test
    public void shouldReturnTrueWhenCalledMatchWithDictionaryWord() {
        Assert.assertTrue(dictionary.match("ACONEX"));
    }

    @Test
    public void shouldReturnTrueWhenCalledMatchCaseSensitiveDictionaryWord() {
        Assert.assertTrue(dictionary.match("Aconex"));
    }

    @Test
    public void shouldReturnTrueWhenCalledMatchLowerCaseDictionaryWord() {
        Assert.assertTrue(dictionary.match("aconex"));
    }

    @Test
    public void shouldReturnFalseWhenCalledMatchWithUnknownWord() {
        Assert.assertFalse(dictionary.match("yx"));
    }
}
