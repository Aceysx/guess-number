package com.thoughtworks.guessnumber;

import com.thoughtworks.guessnumber.model.GuessNumber;
import com.thoughtworks.guessnumber.model.GuessNumberValidator;
import com.thoughtworks.guessnumber.model.GuessResult;

import java.util.*;
import java.util.stream.Collectors;

public class GuessNumberGame {
    private GuessNumber guessNumber;
    private List<Map<String, GuessResult>> result;
    private Integer MAX_GUESS_COUNT = 6;

    public GuessNumberGame(GuessNumber guessNumber) {
        this.guessNumber = guessNumber;
        this.result = new ArrayList<>();
    }

    public List<Map<String, GuessResult>> guess(String input) {
        if (isOver()) {
            return result;
        }
        if (GuessNumberValidator.verify(input)) {
            List<Integer> inputs = format(input);
            result.add(buildGuessResult(
                input,
                guessNumber.guess(inputs))
            );
            return result;
        }

        throw new IllegalArgumentException();
    }

    private boolean isOver() {
        return this.result.size() >= MAX_GUESS_COUNT;
    }

    private Map<String, GuessResult> buildGuessResult(String input, GuessResult guess) {
        Map result = new HashMap();
        result.put(input, guess);
        return result;
    }

    private List<Integer> format(String input) {
        return Arrays.stream(input.split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

}
