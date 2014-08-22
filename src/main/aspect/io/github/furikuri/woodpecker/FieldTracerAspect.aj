package io.github.furikuri.woodpecker;

import org.apache.log4j.Logger;
import org.aspectj.lang.Signature;

import java.lang.reflect.Field;

public aspect FieldTracerAspect {
    private static final Logger LOG = Logger.getLogger(FieldTracerAspect.class);

    before(Object arg, Object prop) : set(@io.github.furikuri.woodpecker.annotation.Trace * *.*)
            && args(arg) && target(prop) {
        Object oldValue = null;
        try {
            Signature signature = thisJoinPoint.getSignature();
            Field field = thisJoinPoint.getSignature().getDeclaringType().getDeclaredField(signature.getName());
            oldValue = getFieldValue(field, prop);
            LOG.debug("Field '" + field.getName() + "' was changed. Old value: " + oldValue + "; New value: " + arg);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            // ignore exception here
        }
    }

    private Object getFieldValue(Field field , Object obj) throws IllegalAccessException, NoSuchFieldException {
        boolean fieldAccessible = field.isAccessible();
        field.setAccessible(true);
        Object result = field.get(obj);
        field.setAccessible(fieldAccessible);
        return result;
    }
}
