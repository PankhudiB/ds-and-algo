package stack;


public class StackAsLinkedList {
    StackNode root;

    boolean isEmpty() {
        return (this.root == null);
    }

    public void push(int val) {
        StackNode newNode = new StackNode(val);
        newNode.next = root;
        this.root = newNode;
        System.out.println("pushed : " + val);
    }

    public int pop() {
        if (this.root == null) {
            System.out.println("stack empty");
        }
        int popped = root.val;
        root = root.next;
        return popped;
    }

    public int peek() {
        if (this.root == null) {
            System.out.println("stack empty");
        }
        return root.val;
    }

    public static void main(String[] args) {
        StackAsLinkedList stack = new StackAsLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("popped from stack : " + stack.pop());
        System.out.println("top element is : " + stack.peek());
    }
}
