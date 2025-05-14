import java.util.*;
// https://neetcode.io/problems/minimum-stack
class MinStack {

    Stack<Integer> minStack;
    Stack<Integer> actualStack;

    public MinStack() {
        minStack = new Stack<Integer>();
        actualStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        actualStack.push(val);
        if (!minStack.empty()){
            int currentMin = minStack.peek() ;
            if( val < currentMin){
                minStack.push(val);
            } else {
                minStack.push(currentMin);
            }
        } else {
            minStack.push(val);
        }
    }
    
    public void pop() {
        if (!minStack.empty()){
            actualStack.pop();
            minStack.pop();
        }
    }
    
    public int top() {
        return actualStack.peek();
    }
    
    public int getMin() {
        if (!minStack.empty()){
            return minStack.peek();
        }
        else
            return Integer.MAX_VALUE;
    }
}
