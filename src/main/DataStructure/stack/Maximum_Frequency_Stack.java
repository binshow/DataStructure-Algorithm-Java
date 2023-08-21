package DataStructure.stack;

import java.util.*;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/maximum-frequency-DataStructure.stack/
 * @date 2022/11/3012:54 PM
 */

// 最大频率栈
public class Maximum_Frequency_Stack {

    // key 为值，val 为对应的频率
    Map<Integer,Integer> map = new HashMap<>();
    // key 为频率，val 为对应的链表
    Map<Integer , List<Integer>> mlist = new HashMap<>();
    int max; // 记录最大频率

    public Maximum_Frequency_Stack() {}

    public void push(int val) {
        map.put(val , map.getOrDefault(val , 0) + 1);
        int c = map.get(val);

        List<Integer> list = mlist.getOrDefault(c, new ArrayList<>());
        list.add(val);
        mlist.put(c , list);

        max = Math.max(max , c);
    }


    public int pop() {
        List<Integer> list = mlist.get(max);
        // 拿到最后一个元素
        int res = list.remove(list.size()-1);
        map.put(res , map.get(res)-1);
        if (list.size() == 0) max--;
        return res;
    }


}
