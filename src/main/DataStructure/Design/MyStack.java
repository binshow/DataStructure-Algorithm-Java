package DataStructure.Design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.cn/problems/implement-stack-using-queues/
public class MyStack {

    public MyStack() {}


    // 队列实现栈

    Queue<Integer> queue = new LinkedList<>();

    public void push(int x) {
        int size = queue.size();
        queue.add(x);
        while (size > 0){
            queue.add(queue.poll());
            size--;
        }
    }

    public int pop() {
        if (queue.size() == 0) return -1;
        return queue.poll();
    }

    public int top() {
        if (queue.size() == 0) return -1;
        return queue.peek();
    }

    public boolean empty() {
        return queue.size() == 0;
    }


    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.top()); // 3
        System.out.println(stack.pop()); // 3
        System.out.println(stack.pop()); // 2
        System.out.println(stack.pop()); // 1


        Queue<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        System.out.println(list.poll()); // 1  队首
        System.out.println(list.peek()); // 2  队尾


    }
}
