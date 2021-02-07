package linked_list.doubly;

import java.util.HashMap;
import java.util.Map;

public class LRUUsingDLL {
    private DLL dll = new DLL();
    private Map<Integer, DListNode> cache = new HashMap<>();
    private int CACHE_CAPACITY;

    public LRUUsingDLL(int CACHE_CAPACITY) {
        this.CACHE_CAPACITY = CACHE_CAPACITY;
    }

    public static void main(String[] args) {
        LRUUsingDLL lru = new LRUUsingDLL(3);
        lru.put(1, 1);
        lru.display();
        lru.put(2, 2);
        lru.display();
        lru.put(3, 3);
        lru.display();
        lru.put(4, 4);
        lru.display();
        System.out.print("\n get :" + lru.get(2));
        lru.display();
        System.out.print("\n get :" + lru.get(2));
        lru.display();
        lru.put(5, 5);
        lru.display();
    }

    private void display() {
        System.out.print("\n lru cache : ");
        dll.forward();
    }

    private void put(int key, int value) {
        DListNode foundNode = cache.get(key);
        if (foundNode == null) { //not in cache
            DListNode new_node = new DListNode(key, value);
            if (dll.size() == CACHE_CAPACITY) {
                cache.remove(dll.tail.key);
                dll.delete(dll.tail);
            }
            cache.put(key, new_node);
            dll.addAtFront(new_node);
        } else {
            dll.delete(dll.tail);
            dll.addAtFront(foundNode);
        }
    }

    private int get(int key) {
        DListNode node = cache.get(key);
        if (node == null) return -1;
        dll.delete(node);
//        System.out.println(" inside get : ");dll.forwardAndBackward();
        dll.addAtFront(node);
//        System.out.println(" inside get : ");dll.forwardAndBackward();
        return node.val;
    }
}
