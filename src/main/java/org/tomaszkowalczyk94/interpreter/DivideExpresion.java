package org.tomaszkowalczyk94.interpreter;

import java.util.List;

class DivideExpresion implements Expresion{

    private List<Expresion> expressions;

    DivideExpresion(List<Expresion> expressions) {
        this.expressions = expressions;
    }


    @Override
    public double interpret() {
        return expressions.stream()
                .map(Expresion::interpret)
                .reduce((val1, val2) -> val1 / val2)
                .orElse(0.0);
    }
}
