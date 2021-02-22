package stack;

import java.util.Scanner;
import java.util.Stack;

public class DeleteAdjacentPairInString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(input + " ---> " + deleteAdjacentPairInString(input));
    }

    private static String deleteAdjacentPairInString(String input) {
        if (input.length() <= 1) return input;
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        String output = "";
        for (Character c : input.toCharArray()) {
            stack1.push(c);
        }
        Character first;
        Character second;
        while (!stack1.isEmpty()) {
            if (stack2.isEmpty()) {
                first = stack1.pop();
                second = stack1.pop();
            } else {
                first = stack2.pop();
                second = stack1.pop();
            }
            if (first != second) {
                stack2.push(first);
                stack2.push(second);
            }
        }

        while (!stack2.isEmpty()) {
            output += stack2.pop();
        }
        return output;
    }
}
