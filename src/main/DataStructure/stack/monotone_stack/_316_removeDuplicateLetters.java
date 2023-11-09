package DataStructure.stack.monotone_stack;

import java.util.Stack;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/2/2810:13 PM
 */
public class _316_removeDuplicateLetters {

    // 去除重复字母
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int[] count = new int[256];
        for (char c : chars){
            count[c]++;
        }
        // 记录栈中存在哪些元素
        boolean[] inStack = new boolean[256];

        // 类似于单调栈
        for (char c : chars){
            count[c]--;
            if (inStack[c]) continue; // 栈中已经存在了
            while (!stack.isEmpty() && c < stack.peek()){
                if (count[stack.peek()] == 0) break; // 只有一个，不能pop
                inStack[stack.pop()] = false;
            }
            inStack[c] = true;
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c); // 顺序遍历
        return sb.toString();
    }
}
