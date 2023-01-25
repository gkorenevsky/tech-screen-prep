package net.prep.screen.tech.list.of.lists;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution.ListOfLists sut;

    @Test
    public void testWithEmptyList() {
        List<List<String>> emptyList = new ArrayList<>();
        sut = new Solution.ListOfLists(emptyList);

        assertFalse(sut.hasNext());
        assertNull(sut.next());
    }

    @Test
    public void testWithSingletonEmptyList() {
        List<List<String>> lol = new ArrayList<>();
        lol.add(new ArrayList<>());
        sut = new Solution.ListOfLists(lol);

        assertFalse(sut.hasNext());
        assertNull(sut.next());
    }

    @Test
    public void testWithMultipleEmptyLists() {
        List<List<String>> lol = new ArrayList<>();
        lol.add(new ArrayList<>());
        lol.add(new ArrayList<>());
        lol.add(new ArrayList<>());
        sut = new Solution.ListOfLists(lol);

        assertFalse(sut.hasNext());
        assertNull(sut.next());
    }

    @Test
    public void testWithMultipleEmptyListsAndOneNonEmptyList() {
        List<List<String>> lol = new ArrayList<>();
        lol.add(new ArrayList<>());
        lol.add(new ArrayList<>());
        lol.add(new ArrayList<>());
        lol.add(List.of("abc"));
        sut = new Solution.ListOfLists(lol);

        assertTrue(sut.hasNext());
        assertEquals("abc", sut.next());
        assertFalse(sut.hasNext());
        assertNull(sut.next());
    }

    @Test
    public void testWithMultipleEmptyAndNonEmptyLists() {
        List<List<String>> lol = new ArrayList<>();
        lol.add(List.of("abc"));
        lol.add(new ArrayList<>());
        lol.add(new ArrayList<>());
        lol.add(List.of("def"));
        lol.add(new ArrayList<>());
        lol.add(List.of("ghi"));
        lol.add(new ArrayList<>());
        sut = new Solution.ListOfLists(lol);

        assertTrue(sut.hasNext());
        assertEquals("abc", sut.next());
        assertEquals("def", sut.next());
        assertEquals("ghi", sut.next());
        assertFalse(sut.hasNext());
        assertNull(sut.next());
    }

}