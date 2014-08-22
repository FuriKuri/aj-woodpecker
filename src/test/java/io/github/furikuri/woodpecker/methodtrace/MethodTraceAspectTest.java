package io.github.furikuri.woodpecker.methodtrace;

import io.github.furikuri.woodpecker.helper.TestAppender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MethodTraceAspectTest {
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
    public void traceMethod() {
        new Example().returnMe("Value");
        new Example().returnNothing("Nothing", "Me", 42);
        testAppender.containsLogMessage("Method was called: String io.github.furikuri.woodpecker.methodtrace.Example." +
                "returnMe(String); Parameters: [Value]");
        testAppender.containsLogMessage("Method 'String io.github.furikuri.woodpecker.methodtrace.Example." +
                "returnMe(String)' returns: Value");
        testAppender.containsLogMessage("Method was called: void io.github.furikuri.woodpecker.methodtrace.Example." +
                "returnNothing(String, String, int); Parameters: [Nothing, Me, 42]");
        testAppender.containsLogMessage("Method 'void io.github.furikuri.woodpecker.methodtrace.Example." +
                "returnNothing(String, String, int)' returns: null");
    }
}
