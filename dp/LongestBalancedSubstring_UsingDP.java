package dp;

import java.util.Stack;

public class LongestBalancedSubstring_UsingDP {

    public static void main(String[] args) {
        System.out.println("()(())( - longestValidParanthesis : " + longestValidParenthesis("()(())("));
        System.out.println("(()( - longestValidParanthesis : " + longestValidParenthesis("(()("));
        System.out.println("))()(() - longestValidParanthesis : " + longestValidParenthesis("))()(()"));
        System.out.println("(((() - longestValidParanthesis : " + longestValidParenthesis("(((()"));
        System.out.println("((())) - longestValidParanthesis : " + longestValidParenthesis("((()))"));
    }

    private static int longestValidParenthesis(String input) {
        int[] dp = new int[input.length()];
        int longestValidParenthesis = 0;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == ')') {
                if (input.charAt(i - 1) == '(') {
                    // found an immediate pair ().
                    // add 2 to dp[i-2] considering it valid/invalid till just before this pair ()
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else {
                    // must be wrapping a valid substring ....))
                    if (i - dp[i - 1] > 0 && input.charAt(i - dp[i - 1] - 1) == '(') {
                        // adjacentValidStringEndsHere + 2 (current wrapper) + 1 place before our wrapper starts could also be valid string
                        dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                    }
                }
                longestValidParenthesis = Math.max(longestValidParenthesis, dp[i]);
            }
        }
        return longestValidParenthesis;
    }
}
