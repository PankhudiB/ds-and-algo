package stack;


public class StackAsDLL {
    DLLNode head;
    DLLNode mid;
    int count;

    class DLLNode {
        int data;
        DLLNode prev;
        DLLNode next;

        DLLNode(int d) {
            data = d;
        }
    }

    public StackAsDLL() {
        count = 0;
    }

    boolean isEmpty() {
        return (this.head == null);
    }

    public void push(int val) {
        DLLNode newNode = new DLLNode(val);
        newNode.prev = null;
        newNode.next = head;
        count++;
        if (count == 1) {
            mid = newNode;
        } else {
            head.prev = newNode;
            if (count % 2 != 0) {
                mid = mid.prev;
            }
        }
        head = newNode;
    }

    public int pop() {
        if (count == 0) {
            return -1;
        }
        int poppedData = head.data;
        if (count % 2 != 0) {
            mid = mid.next;
        }
        head = head.next;
        count--;
        return poppedData;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return head.data;
    }

    public int findMiddle() {
        if (count == 0) {
            return -1;
        }
        return mid.data;
    }

    public void deleteMiddle() {
        System.out.println("deleting " + mid.data);
        if (count == 1) {
            head = null;
            mid = null;
            return;
        }
        DLLNode nextOfMid = mid.next;
        mid.prev.next = nextOfMid;
        if (nextOfMid != null) nextOfMid.prev = mid.prev;
        if (count % 2 != 0) {
            mid = mid.next;
        } else {
            mid = mid.prev;
        }
        count--;
    }

    public void printStack() {
        DLLNode crawler = head;
        System.out.print("stack : ");
        while (crawler != null) {
            System.out.print(crawler.data + " ");
            crawler = crawler.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackAsDLL stack = new StackAsDLL();
        stack.push(1);
        System.out.println("peek: " + stack.peek() + " middle: " + stack.findMiddle());
        stack.push(2);
        System.out.println("peek: " + stack.peek() + " middle: " + stack.findMiddle());
        stack.push(3);
        System.out.println("peek: " + stack.peek() + " middle: " + stack.findMiddle());
        stack.push(4);
        System.out.println("peek: " + stack.peek() + " middle: " + stack.findMiddle());
        stack.push(5);
        System.out.println("peek: " + stack.peek() + " middle: " + stack.findMiddle());

        String s = "popping: " + stack.peek();
        stack.pop();
        System.out.println(s + " middle: " + stack.findMiddle());

        s = "popping: " + stack.peek();
        stack.pop();
        System.out.println(s + " middle: " + stack.findMiddle());

        s = "popping: " + stack.peek();
        stack.pop();
        System.out.println(s + " middle: " + stack.findMiddle());

        s = "popping: " + stack.peek();
        stack.pop();
        System.out.println(s + " middle: " + stack.findMiddle());

        s = "popping: " + stack.peek();
        stack.pop();
        System.out.println(s + " middle: " + stack.findMiddle());

        stack.push(1);
        System.out.println("pushed: " + stack.peek() + " middle: " + stack.findMiddle());
        stack.push(2);
        System.out.println("pushed: " + stack.peek() + " middle: " + stack.findMiddle());
        stack.push(3);
        System.out.println("pushed: " + stack.peek() + " middle: " + stack.findMiddle());
        stack.push(4);
        System.out.println("pushed: " + stack.peek() + " middle: " + stack.findMiddle());
        stack.push(5);
        System.out.println("pushed: " + stack.peek() + " middle: " + stack.findMiddle());

        stack.deleteMiddle();
        stack.printStack();

        stack.deleteMiddle();
        stack.printStack();

        stack.deleteMiddle();
        stack.printStack();

        stack.deleteMiddle();
        stack.printStack();

        stack.deleteMiddle();
        stack.printStack();
    }
}