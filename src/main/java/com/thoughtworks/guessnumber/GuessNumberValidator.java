package com.thoughtworks.guessnumber;

import java.util.Arrays;

public class GuessNumberValidator {
    private static Long DEFAULT_ANSWER_LENGTH = 4L;

    public static boolean verify(String input) {
        return Arrays.stream(input.split(" "))
            .filter(item -> item.length() == 1)
            .filter(item -> Character.isDigit(item.charAt(0)))
            .count() == DEFAULT_ANSWER_LENGTH;
    }
}
