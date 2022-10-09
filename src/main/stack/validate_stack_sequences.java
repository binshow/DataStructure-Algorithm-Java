package stack;

import java.util.Stack;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/validate-stack-sequences/
 * @date 2022/8/319:59 AM
 */
public class validate_stack_sequences {

    // 验证 栈的压入弹出序列
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) return false;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int num : pushed){
            stack.push(num);
            while (index < popped.length && !stack.isEmpty() && stack.peek() == popped[index]){
                stack.pop();
                index++;
            }
        }
        return index == popped.length;
    }
}
