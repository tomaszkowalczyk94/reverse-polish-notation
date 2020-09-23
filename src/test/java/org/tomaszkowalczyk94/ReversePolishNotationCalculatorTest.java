package org.tomaszkowalczyk94;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ReversePolishNotationCalculatorTest {

    @Test
    public void calculate() {
        //given
        Map<String, Double> mapOfResultsByExpression = Map.of(
                "2 3 + 5 *", 25.0,
                "2 7 + 3 / 14 3 - 4 * + 2 /", -28.0
        );

        var calculator = new RpnStackCalculator();

        mapOfResultsByExpression.forEach((expression, expectedResult) -> {

            //when
            double result = calculator.calculate(expression);

            //then
            assertEquals(expectedResult, result, 0.1);
        });

    }
}