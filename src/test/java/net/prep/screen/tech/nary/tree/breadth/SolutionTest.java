package net.prep.screen.tech.nary.tree.breadth;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution sut = new Solution();

    @Test
    public void testEmptyTree() {
        List<List<Integer>> result = sut.levelOrder(null);

        assertTrue(result.size() == 0);
    }

    @Test
    public void testTreeWithOneNode() {
        Node n = new Node(1);
        n.children = null;
        List<List<Integer>> result = sut.levelOrder(n);

        assertTrue(result.size() == 1);
        assertEquals(1, result.stream().flatMap(Collection::stream).count());
    }

    @Test
    public void testTreeWithThreeNodes() {
        Node r = new Node(1);
        Node lc = new Node(2);
        Node rc = new Node(3);
        List<Node> cList = new ArrayList<>();
        cList.add(lc);
        cList.add(rc);
        r.children = cList;
        List<List<Integer>> result = sut.levelOrder(r);

        assertEquals(2, result.size());
        assertEquals(1, result.get(0).size());
        assertEquals(2, result.get(1).size());
        assertEquals(3, result.stream().flatMap(Collection::stream).count());
        Set<Integer> t = result.stream().flatMap(Collection::stream).collect(Collectors.toSet());
        assertTrue(t.contains(1));
        assertTrue(t.contains(2));
        assertTrue(t.contains(3));
    }

}