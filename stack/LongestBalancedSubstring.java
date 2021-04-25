package stack;

import java.util.Stack;

public class LongestBalancedSubstring {

    public static void main(String[] args) {
        System.out.println("()(())( - longestValidParanthesis : " + longestValidParanthesis("()(())("));
        System.out.println("(()( - longestValidParanthesis : " + longestValidParanthesis("(()("));
        System.out.println("))()(() - longestValidParanthesis : " + longestValidParanthesis("))()(()"));
        System.out.println("(((() - longestValidParanthesis : " + longestValidParanthesis("(((()"));
    }

    private static int longestValidParanthesis(String input) {
        int longestValidParanthesis = 0;
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (isValid(input.substring(i, j + 1)))
                    longestValidParanthesis = Math.max(longestValidParanthesis, (j + 1) - i);
            }
        }
        return longestValidParanthesis;
    }

    private static boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();
        for (Character c : input.toCharArray()) {
            if (c == '(') stack.push(c);
            else if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
            else return false;
        }
        return stack.isEmpty();
    }
}
