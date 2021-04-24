package stack;

import java.util.Stack;

public class InsertAtEndOfStack {
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        stack.push(44);
        System.out.println(stack);
        insertAtEnd(55);
        System.out.println(stack);
    }

    // Add at end hold element in stack and inserts given element after emptying the stack in its recursion stack.

    /*
        ->add@End(1)
            ---> stack not empty
                  go in else
                 - pop element 3
                   add@End (1)
                       stack not empty
                       go in else
                     * pop element 2
                       add@End (1)
                        ---> stack empty -> push 1 [1]
                     * push the popped [2,1]
                 - push the popped [3,2,1]
    */

    private static void insertAtEnd(int x) {
        if (stack.isEmpty()) stack.push(x);
        else {
            Integer popped = stack.pop();
            insertAtEnd(x);
            stack.push(popped);
        }
    }
}
