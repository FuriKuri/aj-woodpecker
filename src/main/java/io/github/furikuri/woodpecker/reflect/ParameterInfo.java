package io.github.furikuri.woodpecker.reflect;

public class ParameterInfo {
    private final int argPosition;
    private final Object value;
    private final Class<?> clazz;

    public ParameterInfo(int argPosition, Object value, Class<?> clazz) {
        this.argPosition = argPosition;
        this.value = value;
        this.clazz = clazz;
    }

    public int getArgPosition() {
        return argPosition;
    }

    public Object getValue() {
        return value;
    }

    public Class<?> getClazz() {
        return clazz;
    }
}
