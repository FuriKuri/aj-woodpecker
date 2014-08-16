package io.github.furikuri.woodpecker.helper;

import io.github.furikuri.woodpecker.annotation.NotNull;
import io.github.furikuri.woodpecker.annotation.ToString;
import io.github.furikuri.woodpecker.annotation.Trace;

@ToString
public class AnnotatedSampleClass {

    @Trace
    private int a = 1;

    private String name = "Class";

    public String concat(@NotNull String a, @NotNull String b) {
        return a + b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
