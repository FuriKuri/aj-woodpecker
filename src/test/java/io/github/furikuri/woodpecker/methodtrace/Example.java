package io.github.furikuri.woodpecker.methodtrace;

import io.github.furikuri.woodpecker.annotation.Trace;

public class Example {
    @Trace
    public String returnMe(String value) {
        return value;
    }

    @Trace
    public void returnNothing(String value, String value2, int value3) {

    }
}
