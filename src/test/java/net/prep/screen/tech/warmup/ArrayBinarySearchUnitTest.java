package net.prep.screen.tech.warmup;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ArrayBinarySearchUnitTest {

    ArrayBinarySearch<Integer> sutInt = new ArrayBinarySearch<>();
    ArrayBinarySearch<String> sutString = new ArrayBinarySearch<>();

    @Test
    public void EmptyIntArrayShouldReturnNull() {
        var intArray = new Integer[0];

        var result = sutInt.search(intArray, 0);
        assertNull(result);
    }

    @Test
    public void EmptyStringArrayShouldReturnNull() {
        var stringArray = new String[0];

        var result = sutString.search(stringArray, "abc");
        assertNull(result);
    }

    @Test
    public void SingletonIntArrayShouldReturnNullOnMismatch() {
        var intArray = new Integer[]{5};

        var result = sutInt.search(intArray, 0);
        assertNull(result);
        result = sutInt.search(intArray, 10);
        assertNull(result);
    }

    @Test
    public void SingletonStringArrayShouldReturnNullOnMismatch() {
        var stringArray = new String[]{"xyz"};

        var result = sutString.search(stringArray, "abc");
        assertNull(result);
        result = sutString.search(stringArray, "zzz");
        assertNull(result);
    }

    @Test
    public void SingletonIntArrayShouldReturnValueOnMatch() {
        var intArray = new Integer[]{5};

        var result = sutInt.search(intArray, 5);
        assertEquals(result, 5);
    }

    @Test
    public void SingletonStringArrayShouldReturnValueOnMatch() {
        var stringArray = new String[]{"xyz"};

        var result = sutString.search(stringArray, "xyz");
        assertEquals(result, "xyz");
    }

    @Test
    public void TwoEntryStringArrayTests() {
        var stringArray = new String[]{"b", "d"};

        assertNull(sutString.search(stringArray, "x"));
        assertNull(sutString.search(stringArray, "a"));
        assertNull(sutString.search(stringArray, "c"));
        assertEquals(sutString.search(stringArray, "d"), "d");
        assertEquals(sutString.search(stringArray, "b"), "b");
    }

    @Test
    public void ThreeEntryStringArrayTests() {
        var stringArray = new String[]{"b", "d", "f"};

        assertNull(sutString.search(stringArray, "x"));
        assertNull(sutString.search(stringArray, "a"));
        assertNull(sutString.search(stringArray, "c"));
        assertNull(sutString.search(stringArray, "e"));
        assertEquals(sutString.search(stringArray, "d"), "d");
        assertEquals(sutString.search(stringArray, "b"), "b");
        assertEquals(sutString.search(stringArray, "f"), "f");
    }

}