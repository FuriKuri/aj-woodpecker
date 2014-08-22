package io.github.furikuri.woodpecker.equalshashcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class EqualsAndHashCodeTest {

    @Test
    public void equals() {
        Example example = new Example("equals");
        Example example2 = new Example("equals");
        Example example3 = new Example("notEquals");
        assertEquals(example, example2);
        assertNotEquals(example, example3);
    }

    @Test
    public void testHashCode() {
        assertEquals(148650608, new Example("hashcode").hashCode());
    }
}
