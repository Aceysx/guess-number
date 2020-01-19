package com.thoughtworks.guessnumber;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GuessNumberGameTest {
    private GuessNumberGame guessNumberGame;

    @Before
    public void setUp() {
        guessNumberGame = new GuessNumberGame();
    }
    @Test
    public void should_return_error_msg_when_given_input_str_is_invalid() {
    }
}