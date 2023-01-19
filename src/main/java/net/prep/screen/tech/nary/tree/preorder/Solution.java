package net.prep.screen.tech.nary.tree.preorder;


import java.util.LinkedList;
import java.util.List;

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
};

class Solution {
    public List<Integer> preorder(Node root) {

        List<Integer> result = new LinkedList<Integer>();

        if (root != null) {

            var children = root.children;
            int value = root.val;

            result.add(value);

            if (children != null && children.size() > 0) {
                for (Node n : children) {
                    result.addAll(preorder(n));
                }
            }
        }

        return result;
    }

}
