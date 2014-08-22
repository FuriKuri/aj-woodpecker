package io.github.furikuri.woodpecker.cache;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CacheAspectTest {
    @Test
    public void cacheMethodCall() {
        ExampleClass exampleClass = new ExampleClass();
        assertEquals("Hello", exampleClass.returnSameString("Hello"));
        assertEquals("Hello", exampleClass.returnSameString("Hello"));
        assertEquals("Hello", exampleClass.returnSameString("Hello"));
        assertEquals("World", exampleClass.returnSameString("World"));
        assertEquals("World", exampleClass.returnSameString("World"));
        assertEquals(2, exampleClass.methodCalls);
    }
}
