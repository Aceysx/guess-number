package com.thoughtworks.guessnumber.model;

import com.thoughtworks.guessnumber.NumberGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Answer {
    private static final int DEFAULT_ANSWERS_LENGTH = 4;
    private List<Integer> values;

    private Answer(List<Integer> values) {
        this.values = values;
    }

    public static Answer build() {
        return new Answer(generateAnswersValue());
    }

    private static List<Integer> generateAnswersValue() {
        Set<Integer> result = new HashSet<>();
        while (result.size() != DEFAULT_ANSWERS_LENGTH) {
            result.add(NumberGenerator.number());
        }
        return new ArrayList<>(result);
    }

    public List<Integer> getValues() {
        return this.values;
    }
}
