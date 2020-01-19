package com.thoughtworks.guessnumber.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GuessNumberTest {
    @Mock
    private Answer answer;
    @InjectMocks
    private GuessNumber guessNumber = new GuessNumber(answer);

    @Test
    public void should_return_1A0B_when_one_number_correct() {
        when(answer.getValues()).thenReturn(Arrays.asList(1, 5, 6, 7));
        List<Integer> inputs = Arrays.asList(1, 2, 3, 4);
        GuessResult guessResult = guessNumber.guess(inputs);

        assertFalse(guessResult.isCorrect());
        assertEquals("1A0B",guessResult.getResult());
    }

    @Test
    public void should_return_0A2B_when_two_number_location_wrong() {
        when(answer.getValues()).thenReturn(Arrays.asList(1, 5, 6, 7));
        List<Integer> inputs = Arrays.asList(5, 6, 3, 4);
        GuessResult guessResult = guessNumber.guess(inputs);

        assertFalse(guessResult.isCorrect());
        assertEquals("0A2B", guessResult.getResult());
    }

    @Test
    public void should_return_0A0B_when_all_wrong() {
        when(answer.getValues()).thenReturn(Arrays.asList(1, 5, 6, 7));
        List<Integer> inputs = Arrays.asList(9, 4, 3, 2);
        GuessResult guessResult = guessNumber.guess(inputs);

        assertFalse(guessResult.isCorrect());
        assertEquals("0A0B", guessResult.getResult());
    }

    @Test
    public void should_return_4A0B_when_all_correct() {
        when(answer.getValues()).thenReturn(Arrays.asList(1, 5, 6, 7));
        List<Integer> inputs = Arrays.asList(1, 5, 6, 7);
        GuessResult guessResult = guessNumber.guess(inputs);

        assertTrue(guessResult.isCorrect());
        assertEquals("4A0B", guessResult.getResult());
    }

}