package io.github.furikuri.woodpecker.reflect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class ParameterAnnotationExtractor {

    /**
     * Extract for an annotation the matching parameters for a method signature.
     *
     * @param annotationType
     * @param joinPoint
     * @return
     */
    public static final List<ParameterInfo> extractMatchedParameters(
            Class<? extends Annotation> annotationType,
            JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        List<ParameterInfo> result = new ArrayList<>();
        Method m = methodSignature.getMethod();
        Annotation[][] annotations = m.getParameterAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            if (containsAnnotation(annotationType, annotations[i])) {
                result.add(new ParameterInfo(i, joinPoint.getArgs()[i], m.getParameterTypes()[i]));
            }
        }
        return result;
    }

    private static boolean containsAnnotation(
            Class<? extends Annotation> annotationType,
            Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(annotationType)) {
                return true;
            }
        }
        return false;
    }
}
