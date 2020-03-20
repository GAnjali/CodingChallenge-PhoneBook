package model;

import models.PhoneNumber;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PhoneNumberTest {
    private PhoneNumber phoneNumber;

    @Before
    public void init() {
        phoneNumber = new PhoneNumber("2255");
    }

    @Test
    public void shouldReturnListOfDigitsWhenCalledGetDigits() {
        Assert.assertNotNull(phoneNumber.getDigits());
        Assert.assertEquals(4, phoneNumber.getDigits().size());
    }

    @Test
    public void shouldVerifyReplaceDotWithHyphen() {
        phoneNumber = new PhoneNumber("7.7");
        Assert.assertEquals("7-7", phoneNumber.removeNoise());
    }

    @Test
    public void shouldVerifyReplaceSpaceWithHyphen() {
        phoneNumber = new PhoneNumber("7 7");
        Assert.assertEquals("7-7", phoneNumber.removeNoise());
    }

    @Test
    public void shouldVerifyRemovePunctuationExceptDotHyphen() {
        phoneNumber = new PhoneNumber("7*7](^+%$#. ");
        Assert.assertEquals("77--", phoneNumber.removeNoise());
    }
}
