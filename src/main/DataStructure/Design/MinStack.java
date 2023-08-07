package DataStructure.Design;

import java.util.Stack;

// https://leetcode.cn/problems/min-stack/
public class MinStack {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public MinStack() {}

    public void push(int val) {
        stack.push(val);
        // 如果加入的元素比 最小值栈的 栈顶还小
        if (min.isEmpty() || val <= min.peek()) min.push(val);
    }

    public void pop() {
        int temp = stack.pop();
        // 如果弹出的元素 就是最小值，最小值栈也弹出
        if (temp == min.peek()) min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
