package io.github.furikuri.woodpecker.examples;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.SourceLocation;

public class SimpleJoinPoint implements JoinPoint {
    private Signature signature;

    private Object[] args;

    @Override
    public String toString() {
        return null;
    }

    @Override
    public String toShortString() {
        return null;
    }

    @Override
    public String toLongString() {
        return null;
    }

    @Override
    public Object getThis() {
        return null;
    }

    @Override
    public Object getTarget() {
        return null;
    }

    @Override
    public Object[] getArgs() {
        return args;
    }

    @Override
    public Signature getSignature() {
        return signature;
    }

    @Override
    public SourceLocation getSourceLocation() {
        return null;
    }

    @Override
    public String getKind() {
        return null;
    }

    @Override
    public StaticPart getStaticPart() {
        return null;
    }

    public void setSignature(Signature signature) {
        this.signature = signature;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
