package io.github.furikuri.woodpecker;

import org.apache.log4j.Logger;

public aspect MethodTraceAspect {
    private static final Logger LOG = Logger.getLogger(MethodTraceAspect.class);

    pointcut methodTraceMethods() : execution(@io.github.furikuri.woodpecker.annotation.Trace * *.*(..)) ;

    before() : methodTraceMethods() {
        LOG.debug("Method was called: " + thisJoinPoint.getSignature()
                + "; Parameters: [" + parametersAsString(thisJoinPoint.getArgs()) + "]");
    }

    after() returning(Object r) : methodTraceMethods() {
        LOG.debug("Method '" + thisJoinPoint.getSignature() + "' returns: " + r);
    }

    private String parametersAsString(Object[] parameters) {
        String result = "";
        boolean first = true;
        for (Object parameter : parameters) {
            if (first) {
                first = false;
            } else {
                result += ", ";
            }
            result += parameter;
        }
        return result;
    }
}
