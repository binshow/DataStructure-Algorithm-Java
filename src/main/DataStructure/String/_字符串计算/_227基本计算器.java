package DataStructure.String._字符串计算;

import java.util.Stack;

public class _227基本计算器 {

    // 只有 + - * /
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char operator = '+';
        int num = 0;
        int index = 0;
        while(index < s.length()){
            char c = s.charAt(index++);
            if(c >= '0' && c <= '9') num = num * 10 + c - '0';
            if(index == s.length() || c == '+' || c =='-' || c == '*' || c == '/'){
                if(operator == '+') stack.push(num);
                else if(operator == '-') stack.push(-num);
                else if(operator == '*') stack.push(stack.pop() * num);
                else if(operator == '/') stack.push(stack.pop() / num);

                operator = c;
                num = 0;
            }
        }

        int res = 0;
        while(stack.size() > 0) res += stack.pop();
        return res;
    }
}
