package model;

import IO.Input;
import exceptions.NoSuchFileFoundException;
import models.Dictionary;
import models.WordGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class WordGeneratorTest {
    private WordGenerator wordGenerator;

    @Before
    public void init() throws IOException, NoSuchFileFoundException {
        Input input = new Input();
        Dictionary dictionary = new Dictionary(input.loadFile("dictionary.txt"));
        wordGenerator = new WordGenerator(dictionary);
    }

    @Test
    public void shouldReturnCALLListOfWordsWhenCalledGetDictionaryWordsWith2255() {
        Assert.assertTrue(wordGenerator.generateWords("2255").contains("CALL"));
    }

    @Test
    public void shouldReturnBANGLOREDictionaryMatchedListOfWordsWhenCalledGetDictionaryWordsWith22645673() {
        Assert.assertTrue(wordGenerator.generateWords("22645673").contains("BANGLORE"));
    }

    @Test
    public void shouldReturnWAY2DictionaryMatchedListOfWordsWhenCalledGetDictionaryWordsWith9292() {
        Assert.assertTrue(wordGenerator.generateWords("9292").contains("WAY2"));
    }

    @Test
    public void shouldReturnS0SDictionaryMatchedListOfWordsWhenCalledGetDictionaryWordsWith9292() {
        Assert.assertTrue(wordGenerator.generateWords("707").contains("S0S"));
    }

    @Test
    public void shouldContainCALLDotMEForGivenNumber() {
        Assert.assertTrue(wordGenerator.generateWords("2255.63").contains("CALL.ME"));
    }

    @Test
    public void shouldContainCALLHyphenMEForGivenNumber() {
        List<String> subMatchedWords = wordGenerator.generateWords("2255-63");
        Assert.assertTrue(subMatchedWords.contains("CALL-ME"));
    }
}
