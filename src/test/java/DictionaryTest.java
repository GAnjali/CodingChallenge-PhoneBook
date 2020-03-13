import IO.Input;
import models.Dictionary;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static helper.PhoneBookConstants.DICT_PATH;

public class DictionaryTest {
    private Dictionary dictionary;

    @Before
    public void init() throws IOException {
        Input input = new Input();
        dictionary = new Dictionary(input.loadDict(DICT_PATH));
    }

    @Test
    public void shouldReturnTrueWhenCalledMatch() {
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
