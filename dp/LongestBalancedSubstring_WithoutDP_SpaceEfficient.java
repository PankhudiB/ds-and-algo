package dp;

public class LongestBalancedSubstring_WithoutDP_SpaceEfficient {

    public static void main(String[] args) {
        System.out.println("()(())( - longestValidParanthesis : " + longestValidParenthesis("()(())("));
        System.out.println("(()( - longestValidParanthesis : " + longestValidParenthesis("(()("));
        System.out.println("))()(() - longestValidParanthesis : " + longestValidParenthesis("))()(()"));
        System.out.println("(((() - longestValidParanthesis : " + longestValidParenthesis("(((()"));
        System.out.println("((())) - longestValidParanthesis : " + longestValidParenthesis("((()))"));
    }

    /*
    There are only three cases for a string:

    '(' are more than ')'
    '(' are less than ')'
    '(' and ')' are the same
    Now, when you scan from left to right, you can only find the correct maxLength for cases 2 and 3,
    because if it is case 1, where '(' are more than ')'
    (e.g., "((()"), then left is always greater than right and maxLength does not have the chance to be updated.

    Similarly, when you scan from right to left, you can only find the maxLength for cases 1 and 3.

    Therefore, a two-pass scan covers all the cases and is guaranteed to find the correct maxLength
     */
    private static int longestValidParenthesis(String input) {
        int longestValidParenthesis = 0;
        int left = 0;
        int right = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') left++;
            else right++;
            if (left == right) {
                longestValidParenthesis = Math.max(longestValidParenthesis, (2 * right));
            } else if (right > left) {
                left = right = 0;
            }
        }
        left = right = 0;

        for (int i = input.length() - 1; i >= 0; i--) {
            if (input.charAt(i) == '(') left++;
            else right++;
            if (left == right) {
                longestValidParenthesis = Math.max(longestValidParenthesis, (2 * right));
            } else if (left > right) {
                left = right = 0;
            }
        }
        return longestValidParenthesis;
    }
}
