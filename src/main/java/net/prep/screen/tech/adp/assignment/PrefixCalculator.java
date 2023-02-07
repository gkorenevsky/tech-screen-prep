package net.prep.screen.tech.adp.assignment;

 /* evaluate expressions such as
 ( + 3 2 ) = 5
         ( / 4 2 )  = 2
         ( * 4 2 )  = 8
         ( - 10 2 )  = 8

  */

public class PrefixCalculator {

    public int evaluateExpr(String expr) {
        String[] tokenizedExpr = expr.split(" ");
        String operation = tokenizedExpr[1];

        int result = Integer.parseInt(tokenizedExpr[2]);

        for (int i = 3; !tokenizedExpr[i].equals(")"); i++) {
            int operand = Integer.parseInt(tokenizedExpr[i]);
            switch (operation) {
                case "+" -> result += operand;
                case "-" -> result -= operand;
                case "*" -> result *= operand;
                case "/" -> result /= operand;
                default -> {
                }
            }
        }

        return result;
    }
}

