package com.thoughtworks.guessnumber.model;

import java.util.Arrays;

public class GuessNumberValidator {

    public static boolean verify(String input,long length) {
        return Arrays.stream(input.split(" "))
            .filter(item -> item.length() == 1)
            .filter(item -> Character.isDigit(item.charAt(0)))
            .count() == length;
    }
}
