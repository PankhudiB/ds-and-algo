package stack;

import java.util.Scanner;
import java.util.Stack;

public class DeleteAdjacentPairInString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(input + " ---> " + deleteAdjacentPairInStringUsing1Stack(input));
    }

    private static String deleteAdjacentPairInStringUsing1Stack(String input) {
        if (input.length() <= 1) return input;
        Stack<Character> stack = new Stack<>();
        String output = "";
        int i = 0;
        while (i < input.length()) {
            if (stack.isEmpty() || input.charAt(i) != stack.peek()) {
                stack.push(input.charAt(i));
                i++;
            } else {
                stack.pop();
                i++;
            }
        }
        while (!stack.isEmpty()) {
            output = stack.peek() + output;
            stack.pop();
        }
        return output;
    }
}
