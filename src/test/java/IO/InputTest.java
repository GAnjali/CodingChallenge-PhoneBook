package IO;

import exceptions.NoSuchFileFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class InputTest {
    private Input input;

    @Before
    public void init() {
        input = new Input();
    }

    @Test
    public void shouldReturnListOfWordsWhenCalledLoadDict() throws IOException, NoSuchFileFoundException {
        List<String> dictionaryWords = input.loadFile("dictionary.txt");
        Assert.assertFalse(dictionaryWords.isEmpty());
    }

    @Test(expected = IOException.class)
    public void shouldThrowExceptionWhenCalledLoadDictWithInvalidFilePath() throws IOException, NoSuchFileFoundException {
        input.loadFile("\\");
    }

    @Test(expected = NoSuchFileFoundException.class)
    public void shouldThrowExceptionWhenCalledLoadDictWithInvalidFileName() throws IOException, NoSuchFileFoundException {
        input.loadFile("dict.txt");
    }
}
