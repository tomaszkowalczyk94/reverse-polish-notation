package org.tomaszkowalczyk94.interpreter;

import java.util.List;

class AddExpresion implements Expresion {

    private List<Expresion> expressions;

    AddExpresion(List<Expresion> expressions) {
        this.expressions = expressions;
    }

    @Override
    public double interpret() {
        return expressions.stream()
                .map(Expresion::interpret)
                .reduce(0.0, Double::sum);
    }
}
