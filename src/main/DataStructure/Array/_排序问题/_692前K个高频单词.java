package DataStructure.Array._排序问题;

import java.util.*;

public class _692前K个高频单词 {

    // https://leetcode.cn/problems/top-k-frequent-words/
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if(words.length == 0) return res;

        Map<String,Integer> map = new HashMap<>();
        for(String s : words) map.put(s , map.getOrDefault(s , 0) + 1);

        // 重点还是重写排序规则
        Queue<String> queue = new PriorityQueue<>( (a, b)-> {
            int a1 = map.get(a);
            int b1 = map.get(b);
            if(a1 == b1) return b.compareTo(a);
            else return a1 - b1;
        });
        for(String s : map.keySet()){
            queue.add(s);
            if(queue.size() > k) queue.poll();
        }

        while(queue.size() > 0) res.add(queue.poll());
        Collections.reverse(res);
        return res;
    }
}
