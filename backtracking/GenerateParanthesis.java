package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParanthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));
    }

    static String[] possibleParanthesis = new String[]{"(", ")"};
    static int targetSequenceLength = 0;
    static List<String> result = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        targetSequenceLength = 2 * n;
        result = new ArrayList<>();
        backtrack("");
        return result;
    }

    private static void backtrack(String stringSoFar) {
        if (stringSoFar.length() > targetSequenceLength) return;
        if (stringSoFar.length() == targetSequenceLength && validParenthesisSequence(stringSoFar)) {
            result.add(stringSoFar);
            return;
        }

        for (String paranthesis : possibleParanthesis) {
            backtrack(stringSoFar + paranthesis);
        }
    }

    private static boolean validParenthesisSequence(String sequence) {
        Stack<Character> stack = new Stack<>();

        for (Character ch : sequence.toCharArray()) {
            if (ch == ')') {
                if (stack.isEmpty()) return false;
                if (stack.peek() == '(') stack.pop();
            } else if (ch == '(') {
                stack.push('(');
            }
        }
        return (stack.isEmpty()) ? true : false;
    }
}

