package org.tomaszkowalczyk94.interpreter;

import java.util.List;

class MultiplyExpresion implements Expresion {

    private List<Expresion> expressions;

    MultiplyExpresion(List<Expresion> expressions) {
        this.expressions = expressions;
    }

    @Override
    public double interpret() {
        return expressions.stream()
                .map(Expresion::interpret)
                .reduce((val1, val2) -> val1 * val2)
                .orElse(0.0);
    }
}
