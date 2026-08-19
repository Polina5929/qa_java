
package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    private Feline felineMock;

    @Before
    public void setUp() {
        felineMock = Mockito.mock(Feline.class);
    }

    @Test
    public void getKittensDelegatesToFeline() throws Exception {
        when(felineMock.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", felineMock);
        assertEquals(3, lion.getKittens());
        verify(felineMock, times(1)).getKittens();
    }

    @Test
    public void getFoodDelegatesToFelineEatMeat() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        Lion lion = new Lion("Самка", felineMock);
        assertEquals(expectedFood, lion.getFood());
        verify(felineMock, times(1)).eatMeat();
    }

    @Test(expected = Exception.class)
    public void constructorThrowsExceptionForInvalidSex() throws Exception {
        new Lion("НекорректныйПол", felineMock);
    }
}