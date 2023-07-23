package monotone_array;

// https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/


// 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
//
//若队列为空，pop_front 和 max_value 需要返回 -1

import java.util.Deque;
import java.util.LinkedList;

public class _剑指offer_59最大队列 {


    public static void main(String[] args) {
        MaxQueue q = new MaxQueue();
        q.push_back(3);
        q.push_back(5);
        q.push_back(1);
        q.push_back(2);

        System.out.println(q.max_value());
    }

}

class MaxQueue {

    Deque<Integer> res , max;

    public MaxQueue() {
        res = new LinkedList<>();
        max = new LinkedList<>();
    }

    public int max_value() {
        if (max.size() == 0) return -1;
        return max.peekFirst();
    }

    public void push_back(int value) {
        res.addLast(value);
        while (max.size() > 0 && max.peekLast() < value) max.pollLast();
        max.addLast(value);
    }

    public int pop_front() {
        if (res.size() == 0) return -1;
        Integer num = res.pollFirst();
        if ( max.size() > 0 && num.equals(max.peekFirst())) max.pollFirst();
        return num;
    }
}
