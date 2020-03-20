package model;

import models.PhoneBookUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PhoneBookUtilTest {
    PhoneBookUtil phoneBookUtil;

    @Before
    public void init(){
        phoneBookUtil = new PhoneBookUtil();
    }

    @Test
    public void shouldVerifyReplaceDotWithHyphen(){
        Assert.assertEquals("7-7", phoneBookUtil.replaceDotWithHyphen("7.7"));
    }

    @Test
    public void shouldVerifyReplaceSpaceWithHyphen(){
        Assert.assertEquals("7-7", phoneBookUtil.replaceSpaceWithHyphen("7 7"));
    }

    @Test
    public void shouldVerifyRemovePunctuationExceptDotHyphen(){
        Assert.assertEquals("77. ", phoneBookUtil.removeAllPunctuationsOtherThanDotSpace("7*7](^+%$#. "));
    }
}
