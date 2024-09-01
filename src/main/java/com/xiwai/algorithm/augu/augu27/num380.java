package com.xiwai.algorithm.augu.augu27;

import java.util.*;

public class num380 {
}

class RandomizedSet {
    Random random = new Random();
    HashMap<Integer, Integer> map = new HashMap();
    int index = 0;
    List<Integer> list = new ArrayList<>();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            map.put(val, map.size());
            list.add(val);
            return true;
        } else {
            return false;
        }
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            map.remove(val);
            list.remove(val);
            return true;
        } else {
            return false;
        }
    }

    public int getRandom() {

        int num = random.nextInt(list.size());

        return list.get(num);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */