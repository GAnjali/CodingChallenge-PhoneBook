package model;

import IO.Input;
import exceptions.NoSuchFileFoundException;
import models.Dictionary;
import models.PhoneNumber;
import models.SubWordGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class SubWordGeneratorTest {
    private SubWordGenerator subWordGenerator;

    @Before
    public void init() throws IOException, NoSuchFileFoundException {
        Input input = new Input();
        Dictionary dictionary = new Dictionary(input.loadFile("dictionary.txt"));
        subWordGenerator = new SubWordGenerator(dictionary);
    }

    @Test
    public void shouldContainREADY2GOForGivenNumber() {
        List<String> subMatchedWords = subWordGenerator.generateDictionarySubMatchingWords(new PhoneNumber("73239246"), "");
        Assert.assertTrue(subMatchedWords.contains("READY2GO"));
    }

    @Test
    public void shouldContainREADY2GO1ForGivenNumber() {
        List<String> subMatchedWords = subWordGenerator.generateDictionarySubMatchingWords(new PhoneNumber("732392461"), "");
        Assert.assertTrue(subMatchedWords.contains("READY2GO1"));
    }

    @Test
    public void shouldContainWAY2ForGivenNumber() {
        List<String> subMatchedWords = subWordGenerator.generateDictionarySubMatchingWords(new PhoneNumber("9292"), "");
        Assert.assertTrue(subMatchedWords.contains("WAY2"));
    }

    @Test
    public void shouldContainCALL8MEForGivenNumber() {
        List<String> subMatchedWords = subWordGenerator.generateDictionarySubMatchingWords(new PhoneNumber("2255863"), "");
        Assert.assertTrue(subMatchedWords.contains("CALL8ME"));
    }

    @Test
    public void shouldContainCALLDotMEForGivenNumber() {
        List<String> subMatchedWords = subWordGenerator.generateDictionarySubMatchingWords(new PhoneNumber("2255.63"), "");
        Assert.assertTrue(subMatchedWords.contains("CALL.ME"));
    }

    @Test
    public void shouldContainCALLHyphenMEForGivenNumber() {
        List<String> subMatchedWords = subWordGenerator.generateDictionarySubMatchingWords(new PhoneNumber("2255-63"), "");
        Assert.assertTrue(subMatchedWords.contains("CALL-ME"));
    }
}
