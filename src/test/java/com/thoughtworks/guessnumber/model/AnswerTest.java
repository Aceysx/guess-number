package com.thoughtworks.guessnumber.model;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.*;

public class AnswerTest {

    @Test
    public void should_create_answer_with_4_number_not_repeated() {
        Answer answer = Answer.build();
        assertEquals(4, new HashSet<>(answer.getValues()).size());
    }
}