package org.tomaszkowalczyk94.interpreter;

import org.tomaszkowalczyk94.RpnUtil;
import org.tomaszkowalczyk94.api.UnsupportedOperation;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Parser {

    Expresion parse(String fullExpresionInString) {
        List<String> parts = RpnUtil.parseMathOperations(fullExpresionInString);

        Deque<Expresion> stack = new LinkedList<>();

        parts.forEach(part -> {
            Expresion expresion = RpnUtil.getNumberFromPart(part)
                    .map(this::createNumberExpresion)
                    .orElseGet(() -> {
                        Expresion operationExpresion = createOperationExpresion(part, new LinkedList<>(stack));
                        stack.clear();
                        return operationExpresion;
                    });
            stack.add(expresion);
        });

        return stack.removeFirst();
    }

    private Expresion createNumberExpresion(Double number) {
        return new NumberExpresion(number);
    }

    private Expresion createOperationExpresion(String operation, List<Expresion> expresions) {

        switch (operation) {
            case "+": return new AddExpresion(expresions);
            case "-": return new SubtractionExpresion(expresions);
            case "*": return new MultiplyExpresion(expresions);
            case "/": return new DivideExpresion(expresions);

            default: throw new UnsupportedOperation("Unsupported operation");
        }
    }
}
