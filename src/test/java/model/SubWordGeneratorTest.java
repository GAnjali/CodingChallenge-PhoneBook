package model;

import exceptions.NoSuchFileFoundException;
import models.SubWordGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class SubWordGeneratorTest {
    private SubWordGenerator subWordGenerator;

    @Before
    public void init() {
        subWordGenerator = new SubWordGenerator();
    }

    @Test
    public void shouldContainREADY2GOForGivenNumber() throws IOException, NoSuchFileFoundException {
        List<String> subMatchedWords = subWordGenerator.generateSubMatchedWords("73239246", "", 0, 8);
        Assert.assertTrue(subMatchedWords.contains("READY2GO"));
    }

    @Test
    public void shouldContainREADY2GO1ForGivenNumber() throws IOException, NoSuchFileFoundException {
        List<String> subMatchedWords = subWordGenerator.generateSubMatchedWords("732392461", "", 0, 9);
        Assert.assertTrue(subMatchedWords.contains("READY2GO1"));
    }

    @Test
    public void shouldContainWAY2ForGivenNumber() throws IOException, NoSuchFileFoundException {
        List<String> subMatchedWords = subWordGenerator.generateSubMatchedWords("9292", "", 0, 4);
        Assert.assertTrue(subMatchedWords.contains("WAY2"));
    }

    @Test
    public void shouldContainCALL8MEForGivenNumber() throws IOException, NoSuchFileFoundException {
        List<String> subMatchedWords = subWordGenerator.generateSubMatchedWords("2255863", "", 0, 7);
        Assert.assertTrue(subMatchedWords.contains("CALL8ME"));
    }
}
