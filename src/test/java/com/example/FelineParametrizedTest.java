package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {

    private final int kittensCount;
    private final int expected;

    public FelineParametrizedTest(int kittensCount, int expected) {
        this.kittensCount = kittensCount;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0, 0},
                {1, 1},
                {5, 5}
        });
    }

    @Test
    public void getKittensWithParameterReturnsCorrectValue() {
        Feline feline = new Feline();
        assertEquals(expected, feline.getKittens(kittensCount));
    }
}