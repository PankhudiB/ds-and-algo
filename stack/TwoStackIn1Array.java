package stack;


public class TwoStackIn1Array {
    int size;
    int top1, top2;
    int arr[];

    public TwoStackIn1Array(int size) {
        this.size = size;
        top1 = 0;
        top2 = size;
        arr = new int[this.size];
    }


    public static void main(String[] args) {
        TwoStackIn1Array stack = new TwoStackIn1Array(5);
        stack.push1(5);
        stack.push2(10);
        stack.push2(15);
        stack.push1(11);
        stack.push2(7);
        System.out.println("Popped element from"
                + " stack1 is " + stack.pop1());
        stack.push2(40);
        System.out.println("Popped element from"
                + " stack2 is " + stack.pop2());
    }

    private int pop2() {
        if (top2 < size) {
            int popped = arr[top2];
            top2++;
            return popped;
        } else {
            System.out.println("underflow");
            return -1;
        }
    }

    private int pop1() {
        if (top1 >= 0) {
            int popped = arr[top1];
            top1--;
            return popped;
        } else {
            System.out.println("underflow");
            return -1;
        }
    }

    private void push2(int val) {
        System.out.println("pushing " + val);
        if (top1 < top2 - 1) {
            top2--;
            arr[top2] = val;
        } else {
            System.out.println("overflow");
        }
    }

    private void push1(int val) {
        System.out.println("pushing " + val);
        if (top1 < top2 - 1) {
            top1++;
            arr[top1] = val;
        } else {
            System.out.println("overflow");
        }
    }
}