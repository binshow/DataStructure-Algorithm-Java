package Array.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.cn/problems/top-k-frequent-elements/
public class _347前K个高频元素 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int num : nums) map.put(num , map.getOrDefault(num,0) + 1);

        Queue<Integer> pq = new PriorityQueue<>((a , b) -> map.get(a) - map.get(b));
        for (int num : map.keySet()){
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }

        int[] res = new int[k];
        int index = 0;
        while (pq.size() > 0) res[index++] = pq.poll();
        return res;
    }
}
