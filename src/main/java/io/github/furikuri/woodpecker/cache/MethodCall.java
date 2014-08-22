package io.github.furikuri.woodpecker.cache;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.List;
import java.util.logging.Logger;

public class MethodCall {
    private final MethodSignature signature;
    private final List<Object> parameters;

    public MethodCall(MethodSignature signature, List<Object> parameters) {
        this.signature = signature;
        this.parameters = parameters;
    }

    public MethodSignature getSignature() {
        return signature;
    }

    public List<Object> getParameters() {
        return parameters;
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
