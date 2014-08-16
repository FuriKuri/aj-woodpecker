package io.github.furikuri.woodpecker;

import org.aspectj.lang.Signature;

import java.lang.reflect.Field;

public aspect FieldTracerAspect {
    before(Object arg, Object prop) : set(@io.github.furikuri.woodpecker.annotation.Trace * *.*) && args(arg) && target(prop) {
        System.out.println("Trace!!" + arg + prop);
        try {
            Field field = getField(thisJoinPoint.getSignature());
            Object oldValue = field.get(prop);
            System.out.println("Old value" + oldValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private Field getField(Signature signature) throws NoSuchFieldException {
        Field field = signature.getDeclaringType().getDeclaredField(signature.getName());
        field.setAccessible(true);
        return field;
    }
}
