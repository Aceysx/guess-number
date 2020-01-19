package com.thoughtworks.guessnumber;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberGeneratorTest {

    @Test
    public void should_generate_number_between_0_and_9() {
        Integer number = NumberGenerator.number();
        assertTrue(number < 10);
    }
}