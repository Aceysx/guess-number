package com.thoughtworks.guessnumber;


public class NumberGenerator {
    public static Integer number() {
        return (int) (Math.random() * 9);
    }
}
