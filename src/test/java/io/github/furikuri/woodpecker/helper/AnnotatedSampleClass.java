package io.github.furikuri.woodpecker.helper;

import io.github.furikuri.woodpecker.annotation.NotNull;

public class AnnotatedSampleClass {

    public String concat(@NotNull String a, @NotNull String b) {
        return a + b;
    }
}
