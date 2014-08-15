package io.github.furikuri.woodpecker.helper;

import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

public class SimpleMethodSignature implements MethodSignature {
    private Method method;

    @Override
    public Class getReturnType() {
        return null;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Class[] getParameterTypes() {
        return new Class[0];
    }

    @Override
    public String[] getParameterNames() {
        return new String[0];
    }

    @Override
    public Class[] getExceptionTypes() {
        return new Class[0];
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
    public String getName() {
        return null;
    }

    @Override
    public int getModifiers() {
        return 0;
    }

    @Override
    public Class getDeclaringType() {
        return null;
    }

    @Override
    public String getDeclaringTypeName() {
        return null;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
