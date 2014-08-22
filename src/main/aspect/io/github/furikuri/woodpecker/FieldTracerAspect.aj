package io.github.furikuri.woodpecker;

import org.apache.log4j.Logger;
import org.aspectj.lang.Signature;

import java.lang.reflect.Field;

public aspect FieldTracerAspect {
    private final Logger log = Logger.getLogger(FieldTracerAspect.class);

    before(Object arg, Object prop) : set(@io.github.furikuri.woodpecker.annotation.Trace * *.*) && args(arg) && target(prop) {
        Object oldValue = null;
        try {
            oldValue = getFieldValue(thisJoinPoint.getSignature(), prop);
            log.debug("Old value: " + oldValue + "; New value: " + arg);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            // ignore exception here
        }
    }

    private Object getFieldValue(Signature signature, Object obj) throws IllegalAccessException, NoSuchFieldException {
        Field field = signature.getDeclaringType().getDeclaredField(signature.getName());
        boolean fieldAccessible = field.isAccessible();
        field.setAccessible(true);
        Object result = field.get(obj);
        field.setAccessible(fieldAccessible);
        return result;
    }
}
