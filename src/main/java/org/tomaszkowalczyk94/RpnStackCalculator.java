package org.tomaszkowalczyk94;

import org.tomaszkowalczyk94.api.ReversePolishNotationCalculator;

import java.util.*;
import java.util.function.BinaryOperator;

public class RpnStackCalculator implements ReversePolishNotationCalculator {

    private static final  Map<String, BinaryOperator<Double>> mapOfOperations = Map.of(
            "+", Double::sum,
            "-", (val1, val2) -> val1 - val2,
            "*", (val1, val2) -> val1 * val2,
            "/", (val1, val2) -> val1 / val2
    );

    @Override
    public double calculate(String expression) {
        List<String> parts = RpnUtil.parseMathOperations(expression);

        Deque<Double> stack = new LinkedList<>();

        parts.forEach(part -> RpnUtil.getNumberFromPart(part).ifPresentOrElse(stack::push, () -> doOperation(stack, part)));

        return stack.pop();
    }

    private void doOperation(Deque<Double> stack, String operation) {

        List<Double> list = new LinkedList<>(stack);
        Collections.reverse(list);
        Double result = list.stream()
                .reduce(mapOfOperations.get(operation))
                .orElseThrow();

        stack.clear();
        stack.push(result);
    }


}
