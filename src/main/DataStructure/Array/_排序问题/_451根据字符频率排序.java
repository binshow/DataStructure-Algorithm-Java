package DataStructure.Array._排序问题;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.cn/problems/sort-characters-by-frequency/
public class _451根据字符频率排序 {

    public String frequencySort(String s) {
        Map<Character , Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) map.put(c , map.getOrDefault(c , 0) + 1);

        Queue<Character> heap = new PriorityQueue<>((a, b) -> map.get(b)-map.get(a));

        for(char c : map.keySet()){
            heap.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while(heap.size() > 0){
            char c = heap.poll();
            for(int i = 0 ; i < map.get(c) ;i++) sb.append(c);
        }

        return sb.toString();

    }
}
