package com.xiwai.algorithm.augu.augu23;

import java.util.*;

public class num332 {
}
//

class Solution {
    public List<String> ans = new ArrayList<>();
    public TreeMap<String, TreeMap<String, Integer>> map = new TreeMap<>();
//
//    主函数的功能：第一，存映射。映射存放在哈希表的数据结构中，哈希表的键值代表出发机场，v值是另一个哈希表，
//    v值表的k是到达机场，v是到达机场可以飞的次数，同一张机票就累加，这样可以让搜索条件不必为了vv=0的时候变成null
//    存映射流程：1.从ticketsList中抽取ticket，ticketlist.get(0)和get(1)分别代表出发和到达机场
//    for循环取ticket，如果map中存在出发机场，则检查是否存在到达机场，用getordefault取到值，
//    无论是否取到都有结果，取到就是已经存好的可以飞的次数，没取到就直接put，次数加1就是temp的kv。
//    然后将temp加入map中这个键对应的value
//    如果连出发机场也没有，那么直接将temp定为到达机场，次数设为一
//    最后统一put到map中。

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String dep = ticket.get(0);
            String arr = ticket.get(1);
            TreeMap<String, Integer> temp = new TreeMap<>();
            if (map.containsKey(dep)) {
                temp = map.get(dep);
                temp.put(arr, temp.getOrDefault(arr, 0) + 1);
            } else {
                temp.put(arr, 1);
            }
            map.put(dep, temp);
        }
        ans.add("JFK");
        backTracing(tickets.size());


        return new ArrayList<>(ans);
    }

//    大致流程：首先，分两个函数，一个回溯函数，一个主函数。各自的功能不同，
//    回溯函数负责按照当前答案的结尾进行深度搜索，因此传参只需要带有终止条件的边数
//    回溯函数负责做什么事？回溯函数首先取得全局变量中的路径最后值（指代当前出发机场）
//    根据出发机场，进入全局变量中的map按照出发机场搜索可以抵达的到达机场（此步要体现出有序，因此用treemap）
//    根据映射中存的到达机场数据，判断是否存在这个到达机场，如果存在，判断能否继续飞，如果可以，深入再回溯
//    判断条件，下层是否返回true，再返回true的过程中，res会同步记录当前路径。

    public boolean backTracing(int ticketsNum) {
        if (ans.size() == ticketsNum + 1) {
            return true;
        }

        String LastDepart = ans.get(ans.size() - 1);
        if (map.containsKey(LastDepart)) {
            for (Map.Entry<String, Integer> target : map.get(LastDepart).entrySet()) {
                int countNum = target.getValue();//此步用来初始化可到达的次数，用以回溯
                if (countNum > 0) {
                    ans.add(target.getKey());
                    target.setValue(countNum - 1);
                    if (backTracing(ticketsNum)) return true;
                    target.setValue(countNum);
                    ans.remove(ans.size() - 1);
                }
            }
        }

        return false;
    }

}
