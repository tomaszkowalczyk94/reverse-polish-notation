package org.tomaszkowalczyk94;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RpnUtil {
    public static List<String> parseMathOperations(String mathOperations) {

        return Arrays.stream(mathOperations.split(" "))
                .collect(Collectors.toList());

    }
}
