package io.github.furikuri.woodpecker.helper;

import io.github.furikuri.woodpecker.annotation.NotNull;
import io.github.furikuri.woodpecker.annotation.ToString;

@ToString
public class AnnotatedSampleClass {

    private int a = 1;

    private String name = "Class";

    public String concat(@NotNull String a, @NotNull String b) {
        return a + b;
    }
}
