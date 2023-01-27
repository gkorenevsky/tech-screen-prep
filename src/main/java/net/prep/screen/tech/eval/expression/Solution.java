package net.prep.screen.tech.eval.expression;

import java.util.*;

import static java.util.Objects.isNull;

public class Solution {

    private String expression;
    private List<String> inputTokens;

    private ListIterator<String> inputIter;

    private enum TokenType {
        PLUS,
        MINUS,
        MULT,
        LPAREN,
        RPAREN,
        NUMBER,
        NULL,
        UNKNOWN,
        EOD
    }

    private final EnumSet<TokenType> operations = EnumSet.of(TokenType.PLUS, TokenType.MINUS, TokenType.MULT, TokenType.LPAREN, TokenType.RPAREN);
    private final Deque<TokenType> operatorQ = new LinkedList<>();
    private final Deque<Integer> valueQ = new LinkedList<>();

    private record Token(TokenType type, String value) {}

    public Solution(String expression) {
        this.expression = expression;
    }

    public Solution() {
        this.expression = "";
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(args + " = " + sol.evalString());
    }

    public int evalString() {
        inputTokens = Arrays.asList(expression.split(" "));
        inputIter = inputTokens.listIterator();

        return evalExpr();
    }

    private Token getToken() {
        if (this.hasTokens()) {
            String t = inputIter.next();
            return generateToken(t);
        } else {
            return new Token(TokenType.EOD, null);
        }
    }

    private boolean hasTokens() {
        return inputIter.hasNext();
    }

    private Token checkToken() {
        if (this.hasTokens()) {
            String t = inputTokens.get(inputIter.nextIndex());
            return generateToken(t);
        } else {
            return new Token(TokenType.EOD, null);
        }
    }

    private Token generateToken(String t) {
        TokenType tt = (isNull(t)) ? TokenType.NULL
                : switch (t) {
            case "+":
                yield TokenType.PLUS;
            case "-":
                yield TokenType.MINUS;
            case "*":
                yield TokenType.MULT;
            case "(":
                yield TokenType.LPAREN;
            case ")":
                yield TokenType.RPAREN;
            default:
                yield (t.matches("\\d+")) ? TokenType.NUMBER : TokenType.UNKNOWN;
        };
        return new Token(tt, t);
    }

    private int evalExpr() {

        while (this.hasTokens()) {
            Token t = getToken();

            if (t.type() == TokenType.NUMBER) {
                pushValue(t);
                if (checkLastOperator() == TokenType.MULT) {
                    evalTop();
                }
            } else if (isOperation(t)) {
                pushOperator(t);
                if (t.type == TokenType.RPAREN) {
                    evalTop();
                    if (checkLastOperator() == TokenType.MULT) {
                        evalTop();
                    }
                }
            }
        }

        while (hasOperations()) {
            evalTop();
        }

        return lastValue();
    }

    private void evalTop() {
        switch (getLastOperator()) {
            case PLUS -> valueQ.addLast(valueQ.removeLast() + valueQ.removeLast());
            case MINUS -> valueQ.addLast(-1 * valueQ.removeLast() + valueQ.removeLast());
            case MULT -> valueQ.addLast(valueQ.removeLast() * valueQ.removeLast());
            case LPAREN -> {}
            case RPAREN -> { do {
                                    evalTop();
                             }
                             while (checkLastOperator() != TokenType.LPAREN && checkLastOperator() != TokenType.NULL);
                             if (checkLastOperator() == TokenType.LPAREN) { getLastOperator(); }
                           }
            default -> {}
        }
    }

    private TokenType getLastOperator() {
        return (hasOperations()) ? operatorQ.removeLast() : TokenType.NULL;
    }

    private int lastValue() {
        return valueQ.removeLast();
    }

    private void pushValue(Token t) {
        valueQ.addLast(Integer.parseInt(t.value()));
    }

    private boolean hasOperations() {
        return !operatorQ.isEmpty();
    }

    private void pushOperator(Token t) {
        operatorQ.addLast(t.type());
    }

    private TokenType checkLastOperator() {
        return (hasOperations()) ? operatorQ.getLast() : TokenType.NULL;
    }

    private boolean isOperation(Token t) {
        return operations.contains(t.type());
    }


}
