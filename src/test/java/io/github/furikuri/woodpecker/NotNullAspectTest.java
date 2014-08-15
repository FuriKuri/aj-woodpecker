package io.github.furikuri.woodpecker;

import io.github.furikuri.woodpecker.helper.AnnotatedSampleClass;
import io.github.furikuri.woodpecker.helper.SampleClass;
import org.junit.Test;

public class NotNullAspectTest {
    @Test(expected = IllegalArgumentException.class)
    public void callingMethodWithOneNullParameters() {
        new AnnotatedSampleClass().concat(null, "b");
    }

    @Test(expected = IllegalArgumentException.class)
    public void callingMethodWithTwoNullParameters() {
        new AnnotatedSampleClass().concat(null, null);
    }

    @Test
    public void callingMethodWithNoNullParameters() {
        new AnnotatedSampleClass().concat("a", "b");
    }

    @Test
    public void callingMethodWithoutAnnotationsWithNullParameters() {
        new SampleClass().concat(null, null);
    }
}