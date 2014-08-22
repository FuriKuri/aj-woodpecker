package io.github.furikuri.woodpecker.cache;

import io.github.furikuri.woodpecker.annotation.Cache;

public class ExampleClass {
    public int methodCalls = 0;

    @Cache
    public String returnSameString(String str) {
        methodCalls++;
        return str;
    }
}
