package org.tomaszkowalczyk94.interpreter;


class NumberExpresion implements Expresion{

    private final Double number;

    NumberExpresion(Double number) {
        this.number = number;
    }

    @Override
    public double interpret() {
        return number;
    }
}
