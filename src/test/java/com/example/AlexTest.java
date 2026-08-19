package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.*;

public class AlexTest {

    private Alex alex;

    @Before
    public void setUp() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        alex = new Alex(felineMock);
    }

    @Test
    public void getFriendsReturnsCorrectList() {
        List<String> expected = List.of("Марти", "Глория", "Мелман");
        assertEquals(expected, alex.getFriends());
    }

    @Test
    public void getPlaceOfLivingReturnsZoo() {
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void getKittensReturnsZero() {
        assertEquals(0, alex.getKittens());
    }

    @Test
    public void doesHaveManeReturnsTrue() {
        assertTrue(alex.doesHaveMane());
    }
}