package org.tomaszkowalczyk94;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RpnUtil {

    private RpnUtil() {}

    public static List<String> parseMathOperations(String mathOperations) {

        return Arrays.stream(mathOperations.split(" "))
                .collect(Collectors.toList());

    }

    public static Optional<Double> getNumberFromPart(String part) {
        try {
            return Optional.of(Double.parseDouble(part));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
