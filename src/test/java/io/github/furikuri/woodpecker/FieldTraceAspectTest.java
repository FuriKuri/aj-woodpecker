package io.github.furikuri.woodpecker;

import io.github.furikuri.woodpecker.helper.AnnotatedSampleClass;
import io.github.furikuri.woodpecker.helper.TestAppender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FieldTraceAspectTest {
    private TestAppender testAppender = new TestAppender();

    @Before
    public void initLogger() {
        testAppender.initLogger();
    }

    @After
    public void unregisterLogger() {
        testAppender.removeLogger();
    }

    @Test
    public void logFieldChanging() {
        AnnotatedSampleClass annotatedSampleClass = new AnnotatedSampleClass();
        annotatedSampleClass.setA(10);
        assertTrue(testAppender.containsLogMessage("Field 'a' was changed. Old value: 1; New value: 10"));
    }
}
