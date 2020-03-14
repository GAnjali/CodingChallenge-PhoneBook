package model;

import models.PhoneNumber;
import models.WordGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordGeneratorTest {
    private WordGenerator wordGenerator;
    private PhoneNumber phoneNumber;

    @Before
    public void init() {
        wordGenerator = new WordGenerator();
        phoneNumber = new PhoneNumber(2255);
    }

    @Test
    public void shouldReturnListOfWordsWhenCalledGeneratePossibleWords() {
        Assert.assertNotNull(wordGenerator.generatePossibleWords(phoneNumber));
    }
}
