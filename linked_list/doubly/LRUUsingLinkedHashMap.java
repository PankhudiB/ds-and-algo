package linked_list.doubly;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUUsingLinkedHashMap extends LinkedHashMap<Integer, Integer> {
    private int capcacity;

    public LRUUsingLinkedHashMap(int capacity) {
        super(capacity, 0.75F, true);
        this.capcacity = capacity;
    }

    public static void main(String[] args) {
        LRUUsingLinkedHashMap lru = new LRUUsingLinkedHashMap(3);
        lru.put(1, 1);
        lru.display();
        lru.put(2, 2);
        lru.display();
        lru.put(3, 3);
        lru.display();
        lru.put(4, 4);
        lru.display();
        System.out.println("get :" + lru.get(2));
        lru.display();
        System.out.println("get :" + lru.get(2));
        lru.display();
        lru.put(5, 5);
        lru.display();
    }

    private void display() {
        System.out.println(super.toString());
    }

    private void put(int key, int value) {
        super.put(key, value);
    }

    private int get(int key) {
        return super.getOrDefault(key, -1);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capcacity;
    }
}
