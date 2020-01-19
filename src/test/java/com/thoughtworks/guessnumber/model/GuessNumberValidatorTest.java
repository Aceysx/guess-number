package com.thoughtworks.guessnumber.model;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GuessNumberValidatorTest {

    @Test
    public void should_return_error_msg_when_given_input_str_is_invalid() {
        String errorInput = "";
        boolean result = GuessNumberValidator.verify(errorInput, 4);
        assertFalse(result);

        errorInput = "1 2 3";
        result = GuessNumberValidator.verify(errorInput, 4);
        assertFalse(result);

        errorInput = "11 2 3 1";
        result = GuessNumberValidator.verify(errorInput, 4);
        assertFalse(result);

        errorInput = "sd 2 3 1";
        result = GuessNumberValidator.verify(errorInput, 4);
        assertFalse(result);

        errorInput = "1 2 3 1";
        result = GuessNumberValidator.verify(errorInput, 4);
        assertTrue(result);
    }
}