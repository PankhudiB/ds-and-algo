package stack;

import java.util.Stack;

public class LongestBalancedSubstring_Efficient {

    public static void main(String[] args) {
        System.out.println("()(())( - longestValidParanthesis : " + longestValidParenthesis("()(())("));
        System.out.println("(()( - longestValidParanthesis : " + longestValidParenthesis("(()("));
        System.out.println("))()(() - longestValidParanthesis : " + longestValidParenthesis("))()(()"));
        System.out.println("(((() - longestValidParanthesis : " + longestValidParenthesis("(((()"));
        System.out.println("((())) - longestValidParanthesis : " + longestValidParenthesis("((()))"));
    }

    private static int longestValidParenthesis(String input) {
        Stack<Integer> stack = new Stack<>();
        char[] charArray = input.toCharArray();
        int longestSoFar = 0;
        stack.push(-1);
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(')
                stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    longestSoFar = Math.max(longestSoFar, i - stack.peek());
                }
            }
        }
        return longestSoFar;
    }
}
