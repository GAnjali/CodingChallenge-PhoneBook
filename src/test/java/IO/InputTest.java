package IO;

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
    public void shouldReturnListOfWordsWhenCalledLoadDict() throws IOException {
        List<String> dictionaryWords = input.loadFile("\\src\\main\\java\\data\\dictionary.txt");
        Assert.assertFalse(dictionaryWords.isEmpty());
    }

    @Test(expected = IOException.class)
    public void shouldThrowExceptionWhenCalledLoadDictWithInvalidFilePath() throws IOException {
        input.loadFile("\\");
    }
}
