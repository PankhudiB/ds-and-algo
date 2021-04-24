package stack;

import java.util.Stack;

public class SortStackUsingRecursion {
//    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        SortStackUsingRecursion s = new SortStackUsingRecursion();
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(4);
        stack.push(1);
        System.out.println(stack);
        Stack<Integer> sorted = s.sort(stack);
        System.out.println(sorted);
    }

    /*
        3
            2
                4
                    1
                    i(1)
                    [1]
                i(4)
                  pop - 1
                  1 < 4
                  i(1)

     */
    private Stack<Integer> sort(Stack<Integer> stack) {
        if (stack.size() > 0) {
            Integer popped = stack.peek();
            stack.pop();
            sort(stack);
            compareAndPush(stack, popped);
        }
        return stack;
    }

    private void compareAndPush(Stack<Integer> stack, int x) {
        if (stack.isEmpty())
            stack.push(x);
        else {
            Integer popped = stack.peek();
            stack.pop();
            if (popped < x) {
                compareAndPush(stack, popped);
                stack.push(x);
            } else {
                compareAndPush(stack, x);
                stack.push(popped);
            }
        }
    }

}
