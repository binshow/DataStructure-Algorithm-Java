package DataStructure.String._字符串计算;

import java.util.Stack;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/4/119:42 AM
 */
public class Calculator {

    public static void main(String[] args) {
        String s1 = "5 + 12 - 3 + 4 - 6";
        System.out.println(calculator1(s1));

        String s2 = "5 + 12 * 2 - 8 / 4";
        System.out.println(calculator2(s2));


    }


    // ============ 1. 只包含加减符号 ============
    // 5 + 12 - 7
    // 可以拆成 +5 , + 12 , -7 塞入栈中相加
    static int calculator1(String s){
        Stack<Integer> stack = new Stack<>();
        char operator = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // 遇到数字，加起来
            if (c >= '0' && c <= '9') num = num * 10 + (c - '0');

            // 遇到符号 或者最后一位，进行计算
            if (i == s.length()-1 || c == '+' || c == '-'){
                if (operator == '+') stack.push(num);
                else stack.push(-num);

                // 重置
                num = 0;
                operator = c; // 如果 i == s.length()-1， operator 变成数字，但也无所谓了
            }
        }

       // for (int tem : DataStructure.stack) System.out.println(tem);

        // 将栈中的数字加起来
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }


    // 2. 包含 + / - / * / \
    static int calculator2(String s){
        Stack<Integer> stack = new Stack<>();
        char operator = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') num = num * 10 + c - '0';

            if (i == s.length()-1 || c == '+' || c == '-' || c == '*' || c == '/'){
                if (operator == '+') stack.push(num);
                else if (operator == '-') stack.push(-num);
                else if (operator == '*') stack.push(stack.pop() * num);
                else if (operator == '/') stack.push(stack.pop() / num);

                operator = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }


    // 3. 包含 + / - / * / \ / ()
    int index = 0;
    int calculator3(String s){
        Stack<Integer> stack = new Stack<>();
        char operator = '+';
        int num = 0;
        while (index < s.length()){
            char c = s.charAt(index++);
            if (c >= '0' && c <= '9') num = num * 10 + c - '0';
            if (c == '(') num = calculator3(s);
            if (index == s.length() || c == '+' || c == '-' || c == '*' || c == '/' || c == ')'){
                if (operator == '+') stack.push(num);
                else if (operator == '-') stack.push(-num);
                else if (operator == '*') stack.push(stack.pop() * num);
                else if (operator == '/') stack.push(stack.pop() / num);

                operator = c;
                num = 0;
            }

            if (c == ')') break;
        }
        int res = 0;
        while (!stack.isEmpty()) res += stack.pop();
        return res;
    }
}
