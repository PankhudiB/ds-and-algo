package stack;

import java.util.Stack;

public class IsBalancedParenthesis {

    public static void main(String[] args) {
        System.out.println("{([])} - isBalanced : " + isBalanced("{([])}"));
        System.out.println("{([])}{} - isBalanced : " + isBalanced("{([])}{}"));
        System.out.println("([] - isBalanced : " + isBalanced("([]"));
        System.out.println("[])} - isBalanced : " + isBalanced("[])}"));
    }

    private static boolean isBalanced(String input) {
        Stack<Character> stack = new Stack<>();
        for (Character c : input.toCharArray()) {
            switch (c) {
                case '{':
                case '(':
                case '[':
                    stack.push(c);
                    break;
                case ']': {
                    if (stack.isEmpty()) return false;
                    if (stack.peek() == '[') stack.pop();
                    else return false;
                    break;
                }
                case ')': {
                    if (stack.isEmpty()) return false;
                    if (stack.peek() == '(') stack.pop();
                    else return false;
                    break;
                }
                case '}': {
                    if (stack.isEmpty()) return false;
                    if (stack.peek() == '{') stack.pop();
                    else return false;
                    break;
                }
            }
        }
        return stack.isEmpty();
    }
}
