package com.xiwai.algorithm.augu30;

import java.util.HashMap;

public class num146 {
}
class LRUCache {
    private HashMap<Integer,Integer> map;
    private int size;
    public LRUCache(int capacity) {
        this.map=new HashMap<>();
        this.size=capacity;
    }

    public int get(int key) {
        if(map.containsKey(key))
        {
            return map.get(key);
        }
        else
            return -1;
    }

    public void put(int key, int value) {

        if(map.containsKey(key))
        {

        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
