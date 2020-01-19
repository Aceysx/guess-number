package com.thoughtworks.guessnumber.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GuessNumber {
    private Answer answer;

    public GuessNumber(Answer answer) {
        this.answer = answer;
    }

    public GuessResult guess(List<Integer> inputs) {
        List<Integer> numberAndLocationIsCorrect = findNumberAndLocationIsCorrect(inputs);
        List<Integer> numberCorrectAndLocationIsFailure = findLocationsIsCorrect(inputs);
        return buildGuessResult(
            numberAndLocationIsCorrect.size(),
            numberCorrectAndLocationIsFailure.size()
        );
    }

    private GuessResult buildGuessResult(Integer numberAndLocationIsCorrectSize,
                                         Integer numberCorrectAndLocationIsFailureSize) {
        if (Objects.equals(numberAndLocationIsCorrectSize, answer.getValues().size())) {
            return GuessResult.correct(numberAndLocationIsCorrectSize);
        }
        return GuessResult.failure(numberAndLocationIsCorrectSize, numberCorrectAndLocationIsFailureSize);
    }

    private List<Integer> findLocationsIsCorrect(List<Integer> inputs) {
        List<Integer> answerValues = answer.getValues();
        return inputs.stream()
            .filter(item -> {
                Integer answerValue = answerValues.get(inputs.indexOf(item));
                return answerValues.contains(item) && !answerValue.equals(item);
            })
            .collect(Collectors.toList());
    }

    private List<Integer> findNumberAndLocationIsCorrect(List<Integer> inputs) {
        List<Integer> answerValues = answer.getValues();
        return inputs.stream()
            .filter(item -> {
                Integer answerValue = answerValues.get(inputs.indexOf(item));
                return answerValue.equals(item);
            })
            .collect(Collectors.toList());
    }
}
