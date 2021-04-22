package stack;

import java.util.Stack;

public class RunningMinInStack {
    Stack<Integer> mainStack;
    Stack<Integer> auxiliaryStack;

    public RunningMinInStack() {
        mainStack = new Stack<>();
        auxiliaryStack = new Stack<>();
    }

    public static void main(String[] args) {
        RunningMinInStack stack = new RunningMinInStack();
        stack.push(18);
        stack.push(19);
        stack.push(29);
        stack.push(15);
        stack.push(16);
        stack.push(14);
        stack.getMin();

        stack.pop();
        System.out.println("min in stack : " +stack.getMin());

        stack.pop();
        System.out.println("min in stack : " +stack.getMin());

        stack.pop();
        System.out.println("min in stack : " +stack.getMin());
    }

    private void pop() {
        if (mainStack.isEmpty()) {
            System.out.println("underflow");
            return;
        }
        System.out.println("popping " + mainStack.peek());
        mainStack.pop();
        auxiliaryStack.pop();
    }

    private int getMin() {
        return auxiliaryStack.peek();
    }

    private void push(int val) {
        mainStack.push(val);

        if (auxiliaryStack.isEmpty()) auxiliaryStack.push(val);
        else {
            Integer minSoFar = auxiliaryStack.peek();
            if (val < minSoFar) {
                auxiliaryStack.push(val);
            } else {
                auxiliaryStack.push(minSoFar);
            }
        }
    }
}
