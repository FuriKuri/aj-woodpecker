package io.github.furikuri.woodpecker;

import io.github.furikuri.woodpecker.helper.AnnotatedSampleClass;
import io.github.furikuri.woodpecker.helper.ToStringClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ToStringAspectTest {
    @Test
    public void returnsAllFields() {
        AnnotatedSampleClass annotatedSampleClass = new AnnotatedSampleClass();
        assertEquals("AnnotatedSampleClass[a=1,name=Class]", annotatedSampleClass.toString());

        annotatedSampleClass.setA(34);
    }

    @Test
    public void returnsOriginalToStringValue() {
        ToStringClass toStringClass = new ToStringClass();
        assertEquals("old", toStringClass.toString());
    }
}