package stack;

import java.util.Stack;

public class ReversePolishNotation {
    public static void main(String[] args) {
        String[] input1 = new String[]{"2", "1", "+", "3", "*"};
        String[] input2 = new String[]{"4", "13", "5", "/", "+"};
        String[] input3 = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        System.out.println(evalRPN(input1));
        System.out.println(evalRPN(input2));
        System.out.println(evalRPN(input3));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < tokens.length) {
            if (isOperator(tokens[i])) {
                int operand1;
                int operand2;
                String operator;
                operand2 = stack.pop();
                if (stack.isEmpty()) return operand2;
                operand1 = stack.pop();
                operator = tokens[i];
                int result = evaluate(operand1, operand2, operator);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
            i++;
        }
        return stack.peek();
    }

    private static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private static int evaluate(int operand1, int operand2, String operator) {
        int o1 = operand1;
        int o2 = operand2;

        switch (operator) {
            case "+":
                return o1 + o2;
            case "-":
                return o1 - o2;
            case "*":
                return o1 * o2;
            case "/":
                return o1 / o2;
        }
        return 0;
    }
}
