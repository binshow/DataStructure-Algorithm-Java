package DataStructure.Design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.cn/problems/implement-stack-using-queues/
public class MyStack_01 {

    public MyStack_01() {}


    // list 实现
    List<Integer> list = new ArrayList<>();
    public void push(int x) {
        list.add(x);
    }

    public int pop() {
        if (list.size() == 0) return -1;
        int res =  list.get(list.size()-1);
        list.remove(list.size()-1);
        return res;
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public boolean empty() {
        return list.size() == 0;
    }


}
