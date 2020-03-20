package model;

import IO.Input;
import exceptions.NoSuchFileFoundException;
import models.Dictionary;
import models.WordGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static helper.PhoneBookConstants.DATA_PATH;

public class WordGeneratorTest {
    private WordGenerator wordGenerator;

    @Before
    public void init() throws IOException, NoSuchFileFoundException {
        Input input = new Input();
        Dictionary dictionary = new Dictionary(input.loadFile("dictionary.txt", DATA_PATH));
        wordGenerator = new WordGenerator(dictionary);
    }

    @Test
    public void shouldReturnCALLListOfWordsWhenCalledGetDictionaryWordsWith2255() throws IOException, NoSuchFileFoundException {
        Assert.assertTrue(wordGenerator.generateWord("2255").contains("CALL"));
    }

    @Test
    public void shouldReturnBANGLOREDictionaryMatchedListOfWordsWhenCalledGetDictionaryWordsWith22645673() throws IOException, NoSuchFileFoundException {
        Assert.assertTrue(wordGenerator.generateWord("22645673").contains("BANGLORE"));
    }

    @Test
    public void shouldReturnWAY2DictionaryMatchedListOfWordsWhenCalledGetDictionaryWordsWith9292() throws IOException, NoSuchFileFoundException {
        Assert.assertTrue(wordGenerator.generateWord("9292").contains("WAY2"));
    }
}
