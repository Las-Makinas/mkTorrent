package com.lasmakinas;

import org.junit.Assert;
import org.junit.Test;

public class DummyClassTest {

    private DummyClass dummyObject = new DummyClass();

    @Test
    public void dummyTestHappyPath() {
        int dummyResult = dummyObject.dummyMethod(10);
        Assert.assertEquals(1, dummyResult);
    }

    @Test(expected = IllegalArgumentException.class)
    public void dummyTestNotSoHappyPath() {
        dummyObject.dummyMethod(-1);
    }
}
