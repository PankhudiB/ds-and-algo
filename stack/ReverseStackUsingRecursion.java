package stack;

import java.util.Stack;

public class ReverseStackUsingRecursion {
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        reverse();
        System.out.println(stack);
    }

    // 2 recursive calls -> 1 is just ~ to iterator . stacks elements 1 ,2 , 3 and calls add at end.
    // Add at end hold element in stack and inserts given element after emptying the stack in its recursion stack.

    /*
    //reverse
        r(1)
              -> r(2)
                    -> r(3)
                    -> add@End (3)
                         ---> stack empty -> push 3 [3]
              -> add@End (2)
                   ---> stack not empty
                          go in else
                           pop element 3
                           add@End (2)
                             ---> stack empty -> push 2 [2]
                           push the popped [3,2]
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

    private static void reverse() {
        if (stack.size() > 0) {
            Integer popped = stack.peek();
            stack.pop();
            reverse();
            insertAtEnd(popped);
        }
    }

    private static void insertAtEnd(int x) {
        if (stack.isEmpty())
            stack.push(x);
        else {
            Integer popped = stack.peek();
            stack.pop();
            insertAtEnd(x);
            stack.push(popped);
        }
    }

}
