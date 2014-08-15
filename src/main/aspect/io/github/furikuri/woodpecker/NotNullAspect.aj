package io.github.furikuri.woodpecker;

import io.github.furikuri.woodpecker.annotation.NotNull;
import io.github.furikuri.woodpecker.reflect.ParameterAnnotationExtractor;
import io.github.furikuri.woodpecker.reflect.ParameterInfo;

import java.util.List;

public aspect NotNullAspect {
    pointcut notNullMethods() : execution(* *.*(.., @io.github.furikuri.woodpecker.annotation.NotNull (*), ..)) ;

    before() : notNullMethods() {
        List<ParameterInfo> params = ParameterAnnotationExtractor.extractMatchedParameters(NotNull.class,
                thisJoinPoint);

        for (ParameterInfo param : params) {
            if (param.getValue() == null) {
                throw new IllegalArgumentException("The arg" + param.getArgPosition() + " of the class type "
                        + param.getClazz() + " is null. Following method was called: " + thisJoinPoint.getSignature());
            }
        }
    }
}
