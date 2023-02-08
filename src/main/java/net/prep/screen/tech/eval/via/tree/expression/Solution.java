package net.prep.screen.tech.eval.via.tree.expression;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    final String operations = "+-x/";
    final String multiplications = "x/";

    private String formula;

    public Solution(String formula) {
        this.formula = formula;
    }

    public String getFormula() {
        return this.formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public float evaluate(String formula) {

        float result = 0f;

        var tokens = Arrays.asList(formula.split(" "));
        var tokenIt = tokens.iterator();

        while (tokenIt.hasNext()) {
            String nextToken = tokenIt.next();

            // if this is an operator
            if (operations.indexOf(nextToken) >= 0) {
                OperatorNode newOperator = new OperatorNode(nextToken);
                pushOperator(newOperator);
            } else {
                // the token must be a number
                float newValue = Float.parseFloat(nextToken);
                OperandNode newOperand = new OperandNode(newValue);
                pushOperand(newOperand);

                // If the last operator is a multiply or a divide,
                // reduce both stacks
                OperatorNode lastOper = (OperatorNode) checkLastOperator();
                if (lastOper != null && multiplications.indexOf(lastOper.getOperator()) >= 0) {
                    reduceStacks();
                }
            }
        }

        // complete the expression tree
        while (!operatorStack.isEmpty()) {
            consoliodateStacks();
        }

        result = evalTree(checkLastOperand());

        return result;
    }

    private float evalTree(TreeNode node) {

        float result = 0f;
        if (node.getType().equals(NodeType.OPERAND)) {
            result = ((OperandNode) node).getValue();
        } else {
            float leftValue = evalTree(node.getLeft());
            float rightValue = evalTree(node.getRight());
            String operation = ((OperatorNode) node).getOperator();

            switch (operation) {
                case "+" -> result = leftValue + rightValue;
                case "-" -> result = leftValue - rightValue;
                case "x" -> result = leftValue * rightValue;
                case "/" -> result = leftValue / rightValue;
                default -> {}
            }
        }

        return result;
    }


    private void reduceStacks() {
        OperatorNode lastOper = (OperatorNode) popOperator();
        lastOper.setRight(popOperand());
        lastOper.setLeft(popOperand());
        pushOperand(lastOper);
    }

    private void consoliodateStacks() {
        OperatorNode lastOper = (OperatorNode) popFrontOperator();
        lastOper.setLeft(popFrontOperand());
        lastOper.setRight(popFrontOperand());
        pushFrontOperand(lastOper);
    }

    private enum NodeType {
        OPERATOR,
        OPERAND
    }

    private abstract static class TreeNode {
        private NodeType type;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(NodeType type) {
            this.type = type;
            left = null;
            right = null;
        }

        public NodeType getType() {
            return this.type;
        }

        public void setLeft(TreeNode node) {
            this.left = node;
        }

        public void setRight(TreeNode node) {
            this.right = node;
        }

        public TreeNode getLeft() {
            return this.left;
        }

        public TreeNode getRight() {
            return this.right;
        }

    }

    private static class OperatorNode extends TreeNode {

        private String operator;

        public OperatorNode(String operator) {
            super(NodeType.OPERATOR);
            this.operator = operator;
        }

        public String getOperator() {
            return this.operator;
        }
    }

    private static class OperandNode extends TreeNode {

        private float value;

        public OperandNode(float value) {
            super(NodeType.OPERAND);
            this.value = value;
        }

        public float getValue() {
            return this.value;
        }
    }

    private final Deque<TreeNode> operatorStack = new LinkedList<>();
    private final Deque<TreeNode> operandStack = new LinkedList<>();

    private void pushOperator(OperatorNode node) {
        operatorStack.addLast(node);
    }

    private void pushOperand(TreeNode node) {
        operandStack.addLast(node);
    }

    private void pushFrontOperand(TreeNode node) {
        operandStack.addFirst(node);
    }

    private TreeNode checkLastOperator() {
        return (operatorStack.isEmpty()) ? null : operatorStack.getLast();
    }

    private TreeNode checkLastOperand() {
        return (operandStack.isEmpty()) ? null : operandStack.getLast();
    }

    private TreeNode popOperator() {
        return operatorStack.removeLast();
    }

    private TreeNode popFrontOperator() {
        return operatorStack.removeFirst();
    }


    private TreeNode popOperand() {
        return operandStack.removeLast();
    }

     private TreeNode popFrontOperand() {
        return operandStack.removeFirst();
    }

    // Main driver method
    public static void main(String[] args) {

        String[] formulas = new String[] {"3 + 5 x 10", "8 - 2 + 3", "4 + 4 x 3 x 2 / 5", "2.5 x 2 + 3.5"};

        for (String formula : formulas) {
            System.out.println("Evaluating formula: " + formula);
            Solution sol = new Solution(formula);
            float result = sol.evaluate(formula);
            System.out.println("Formula: " + formula + " evaluaates to: " + result);
        }
    }


}
