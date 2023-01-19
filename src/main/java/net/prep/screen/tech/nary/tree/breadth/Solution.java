package net.prep.screen.tech.nary.tree.breadth;
import java.util.*;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

// This problem despite its relative simplicity proved to be challenging because
// it required all nodes at the same level to be collected in the same list. This
// requires keeping track of the level and also demarcation of the end of the
// level and the beginning of a new level
class Solution {
    public List<List<Integer>> levelOrder(Node root) {

        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new LinkedList<>();

        // This is a queue of nodes to be processed
        Deque<Node> nodeQ = new LinkedList<Node>();

        // initialize the process by adding the root node which is the only node at its level
        nodeQ.add(root);
        nodeQ.add(null);

        traverseTree(nodeQ, result);

        return result;
    }

    private void traverseTree(Deque<Node> q, List<List<Integer>> response) {

        // Create an empty list of nodes at the same level
        List<Integer> level = new LinkedList<Integer>();

        // repeat for all nodes
        while (q.size() > 0) {
            // get the head of the queue
            Node n = q.removeFirst();
            // null marks the end of the nodes at a given level
            if (n == null) {
                response.add(level);    // add a list of nodes at the same level to the response
                // note: the following two lines are crucial
                if (q.size() > 0) {     // are there more nodes to process?
                    q.add(null);        // yes, mark the end of the most recent level
                }
                level = new LinkedList<Integer>();  // start a new level
            } else {
                level.add(n.val);       // add another node to the level
                // note: these lines are important!
                if (n.children != null && !n.children.isEmpty()) {
                    q.addAll(n.children);   // queue up its children
                }
            }
        }
    }
}
