package org.tomaszkowalczyk94;

import java.util.*;
import java.util.function.BinaryOperator;

public class RpnStackCalculator implements ReversePolishNotationCalculator {


    private final static Map<String, BinaryOperator<Double>> mapOfOperations = Map.of(
        "+", Double::sum,
        "-", (val1, val2) -> val1 - val2,
        "*", (val1, val2) -> val1 * val2,
        "/", (val1, val2) -> val1 / val2
    );


    @Override
    public double calculate(String expression) {
        List<String> parts = RpnUtil.parseMathOperations(expression);

        Stack<Double> stack = new Stack<>();

        parts.forEach(part -> {
            getNumberFromPart(part).ifPresentOrElse(stack::push, () -> doOperation(stack, part));
        });

        return stack.pop();
    }

    private Optional<Double> getNumberFromPart(String part) {
        try {
            return Optional.of(Double.parseDouble(part));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }



    private void doOperation(Stack<Double> stack, String operation) {

        Double result = stack.stream()
                .reduce(mapOfOperations.get(operation))
                .orElseThrow();

        stack.clear();
        stack.add(result);
    }


}
