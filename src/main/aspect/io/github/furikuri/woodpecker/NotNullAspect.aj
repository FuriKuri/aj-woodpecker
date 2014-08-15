package io.github.furikuri.woodpecker;

import io.github.furikuri.woodpecker.annotation.NotNull;
import io.github.furikuri.woodpecker.reflect.ParameterAnnotationExtractor;
import io.github.furikuri.woodpecker.reflect.ParameterInfo;
import org.aspectj.lang.reflect.MethodSignature;

import java.util.List;

public aspect NotNullAspect {
    before() : execution(@io.github.furikuri.woodpecker.annotation.NotNull * *.*(String) ) {
        System.out.println("Method NotNull");
    }

    pointcut notNullMethods() : execution(* *.*(.., @io.github.furikuri.woodpecker.annotation.NotNull (*), ..)) ;

    before() : notNullMethods() {
        List<ParameterInfo> params = ParameterAnnotationExtractor.extractMatchedParameters(NotNull.class,
                thisJoinPoint);

        System.out.println("NotNull");
    }
}
