package linked_list;

import linked_list.doubly.DListNode;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class LRUCache {
    private Deque<Integer> doublyEndedQueue;
    private HashSet<Integer> hashSet;
    private final int CACHE_CAPACITY;

    public LRUCache(int CACHE_CAPACITY) {
        doublyEndedQueue = new LinkedList<>();
        hashSet = new HashSet<>();
        this.CACHE_CAPACITY = CACHE_CAPACITY;
    }

    public void refer(int page) {
        if (!hashSet.contains(page)) {
            if (hashSet.size() == CACHE_CAPACITY) {
                Integer last = doublyEndedQueue.removeLast();
                hashSet.remove(last);
            }
        } else {
            doublyEndedQueue.remove(page);
        }
        doublyEndedQueue.push(page);
        hashSet.add(page);
    }

    public void display() {
        Iterator<Integer> iterator = doublyEndedQueue.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(3);
        lru.refer(1);
        lru.refer(2);
        lru.refer(3);
        lru.refer(4);
        lru.refer(1);
        lru.refer(2);
        lru.refer(5);
        lru.refer(1);
        lru.refer(2);
        lru.refer(3);
        lru.refer(4);
        lru.refer(5);
        lru.display();
    }
}
