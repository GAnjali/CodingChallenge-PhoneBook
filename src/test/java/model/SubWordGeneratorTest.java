package model;

import IO.Input;
import exceptions.NoSuchFileFoundException;
import models.Dictionary;
import models.SubWordGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static helper.PhoneBookConstants.DATA_PATH;

public class SubWordGeneratorTest {
    private SubWordGenerator subWordGenerator;

    @Before
    public void init() throws IOException, NoSuchFileFoundException {
        Input input = new Input();
        Dictionary dictionary = new Dictionary(input.loadFile("dictionary.txt", DATA_PATH));
        subWordGenerator = new SubWordGenerator(dictionary);
    }

    @Test
    public void shouldContainREADY2GOForGivenNumber() throws IOException, NoSuchFileFoundException {
        List<String> subMatchedWords = subWordGenerator.generateSubWords("73239246", "", 0, 8);
        Assert.assertTrue(subMatchedWords.contains("READY2GO"));
    }

    @Test
    public void shouldContainREADY2GO1ForGivenNumber() throws IOException, NoSuchFileFoundException {
        List<String> subMatchedWords = subWordGenerator.generateSubWords("732392461", "", 0, 9);
        Assert.assertTrue(subMatchedWords.contains("READY2GO1"));
    }

    @Test
    public void shouldContainWAY2ForGivenNumber() throws IOException, NoSuchFileFoundException {
        List<String> subMatchedWords = subWordGenerator.generateSubWords("9292", "", 0, 4);
        Assert.assertTrue(subMatchedWords.contains("WAY2"));
    }

    @Test
    public void shouldContainCALL8MEForGivenNumber() throws IOException, NoSuchFileFoundException {
        List<String> subMatchedWords = subWordGenerator.generateSubWords("2255863", "", 0, 7);
        Assert.assertTrue(subMatchedWords.contains("CALL8ME"));
    }
}
