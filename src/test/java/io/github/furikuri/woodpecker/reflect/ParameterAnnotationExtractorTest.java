package io.github.furikuri.woodpecker.reflect;

import io.github.furikuri.woodpecker.annotation.NotNull;
import io.github.furikuri.woodpecker.helper.Example;
import io.github.furikuri.woodpecker.helper.SimpleJoinPoint;
import io.github.furikuri.woodpecker.helper.SimpleMethodSignature;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParameterAnnotationExtractorTest {
    @Test
    public void extractParametersWithSpecifiedAnnotation() throws NoSuchMethodException {
        SimpleJoinPoint joinPoint = new SimpleJoinPoint();
        SimpleMethodSignature signature = new SimpleMethodSignature();
        signature.setMethod(Example.class.getMethod("methodWithTwoNotNullParameters",
                String.class, String.class, String.class));
        joinPoint.setSignature(signature);
        joinPoint.setArgs(new Object[] {"Hello", "World", null});
        List<ParameterInfo> result = ParameterAnnotationExtractor.extractMatchedParameters(NotNull.class, joinPoint);

        assertEquals(2, result.size());

        assertEquals("Hello", result.get(0).getValue());
        assertEquals(String.class, result.get(0).getClazz());
        assertEquals(0, result.get(0).getArgPosition());

        assertEquals(null, result.get(1).getValue());
        assertEquals(String.class, result.get(1).getClazz());
        assertEquals(2, result.get(1).getArgPosition());
    }
}