package com.thoughtworks.guessnumber.model;


public class NumberGenerator {
    public static Integer number() {
        return (int) (Math.random() * 9);
    }
}
