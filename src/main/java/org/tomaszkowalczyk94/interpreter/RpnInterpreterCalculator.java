package org.tomaszkowalczyk94.interpreter;

import org.tomaszkowalczyk94.api.ReversePolishNotationCalculator;

public class RpnInterpreterCalculator implements ReversePolishNotationCalculator {

    @Override
    public double calculate(String expression) {
        Expresion parsedFinalExpresion = new Parser().parse(expression);
        return parsedFinalExpresion.interpret();
    }

}
