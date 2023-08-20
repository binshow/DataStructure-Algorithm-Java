package DataStructure.String._字符串计算;

import java.util.Stack;

public class _224基本计算器 {

    // s 由数字、'+'、'-'、'('、')'、和 ' ' 组成

    // https://leetcode.cn/problems/basic-calculator/


    int index = 0;
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char operator = '+';
        while(index < s.length()){
            char c = s.charAt(index++);
            if(c >= '0' && c <= '9') num = num * 10 + c - '0';
            // 开始递归
            if(c == '(') num = calculate(s);

            // 实际计算，当碰到 ')' 或者到了最后一个字符时，也应该计算
            if(index == s.length() || c == '+' || c == '-' || c == ')'){
                if(operator == '+') stack.push(num);
                else if(operator == '-') stack.push(-num);

                num = 0;
                operator = c;
            }
            // 结束递归，返回 括号里的算式计算值
            if(c == ')') break;
        }

        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
}
