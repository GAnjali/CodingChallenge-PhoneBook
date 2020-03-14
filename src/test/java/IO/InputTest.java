package IO;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static helper.PhoneBookConstants.DICT_FILE_PATH;

public class InputTest {
    private Input input;

    @Before
    public void init() {
        input = new Input();
    }

    @Test
    public void shouldReturnListOfWordsWhenCalledLoadDict() throws IOException {
        List<String> dictionaryWords = input.loadFile(DICT_FILE_PATH);
        Assert.assertFalse(dictionaryWords.isEmpty());
    }

    @Test(expected = IOException.class)
    public void shouldThrowExceptionWhenCalledLoadDictWithInvalidFilePath() throws IOException {
        input.loadFile("\\");
    }
}
