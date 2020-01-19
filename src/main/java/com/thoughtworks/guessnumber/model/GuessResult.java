package com.thoughtworks.guessnumber.model;

public class GuessResult {
    private Boolean isCorrect;
    private String result;

    public GuessResult(boolean isCorrect, Integer correctSize, int failureSize) {
        this.isCorrect = isCorrect;
        this.result = correctSize + "A" + failureSize + "B";
    }

    public static GuessResult correct(Integer numbersCorrectSize) {
        return new GuessResult(true, numbersCorrectSize, 0);
    }

    public static GuessResult failure(Integer numberAndLocationIsCorrectSize,
                                      Integer numberCorrectAndLocationIsFailureSize) {
        return new GuessResult(false, numberAndLocationIsCorrectSize,
            numberCorrectAndLocationIsFailureSize);
    }

    public Boolean isCorrect() {
        return isCorrect;
    }

    public String getResult() {
        return result;
    }
}
