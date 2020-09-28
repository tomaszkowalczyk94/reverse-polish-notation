package org.tomaszkowalczyk94;

import org.junit.Test;
import org.tomaszkowalczyk94.interpreter.RpnInterpreterCalculator;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ReversePolishNotationCalculatorTest {

    @Test
    public void calculate() {
        //given
        Map<String, Double> mapOfResultsByExpression = Map.of(
                "2 3 + 5 *", 25.0,
                "2 3 5 + 5 *", 50.0,
                "2 7 + 3 / 14 3 - 4 * + 2 /", -28.0
        );

        var calculators = List.of(
                new RpnStackCalculator(),
                new RpnInterpreterCalculator()
        );

        mapOfResultsByExpression.forEach((expression, expectedResult) -> calculators.forEach(calculator -> {
            //when
            double result = calculator.calculate(expression);

            //then
            assertEquals(expectedResult, result, 0.1);
        }));

    }
}