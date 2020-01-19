package com.thoughtworks.guessnumber;

import com.thoughtworks.guessnumber.model.GuessNumber;
import com.thoughtworks.guessnumber.model.GuessResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class GuessNumberGameTest {
    @Mock
    private GuessNumber guessNumber;
    @InjectMocks
    private GuessNumberGame guessNumberGame = new GuessNumberGame(guessNumber);
    private GuessResult guessResult = GuessResult.correct(4);

    @Test
    public void should_return_result_when_guess_number() {
        when(guessNumber.guess(anyList())).thenReturn(guessResult);
        assertEquals(1, guessNumberGame.guess("1 2 3 4").size());

        assertEquals(2, guessNumberGame.guess("5 2 3 4").size());
    }

    @Test
    public void should_return_last_result_when_guess_number_more_than_6() {
        when(guessNumber.guess(anyList())).thenReturn(guessResult);
        assertEquals(1, guessNumberGame.guess("1 2 3 4").size());
        assertEquals(2, guessNumberGame.guess("5 2 3 4").size());
        assertEquals(3, guessNumberGame.guess("5 2 3 4").size());
        assertEquals(4, guessNumberGame.guess("5 2 3 4").size());
        assertEquals(5, guessNumberGame.guess("5 2 3 4").size());
        assertEquals(6, guessNumberGame.guess("5 2 3 4").size());
        assertEquals(6, guessNumberGame.guess("5 2 3 4").size());
    }
}