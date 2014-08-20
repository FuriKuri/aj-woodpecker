package io.github.furikuri.woodpecker;

import org.apache.log4j.Logger;
import org.aspectj.lang.Signature;

import java.lang.reflect.Field;

public aspect FieldTracerAspect {
    private final Logger log = Logger.getLogger(FieldTracerAspect.class);

    before(Object arg, Object prop) : set(@io.github.furikuri.woodpecker.annotation.Trace * *.*) && args(arg) && target(prop) {
        try {
            Field field = getField(thisJoinPoint.getSignature());
            Object oldValue = field.get(prop);
            log.debug("Old value: " + oldValue + "; New value: " + arg);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            // do nothing
        }
    }

    private Field getField(Signature signature) throws NoSuchFieldException {
        Field field = signature.getDeclaringType().getDeclaredField(signature.getName());
        field.setAccessible(true);
        return field;
    }
}
