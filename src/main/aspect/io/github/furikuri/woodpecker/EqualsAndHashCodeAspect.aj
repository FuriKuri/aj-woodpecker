package io.github.furikuri.woodpecker;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public aspect EqualsAndHashCodeAspect {
    private interface ReflectiveEquals {}

    private interface ReflectiveHashCode {}

    declare parents: (@io.github.furikuri.woodpecker.annotation.EqualsAndHashCode *) implements ReflectiveEquals;

    declare parents: (@io.github.furikuri.woodpecker.annotation.EqualsAndHashCode *) implements ReflectiveHashCode;

    public boolean ReflectiveEquals.equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    public int ReflectiveHashCode.hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
