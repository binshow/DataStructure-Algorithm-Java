package DataStructure.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _基本计算器实现 {

    // 题解：https://leetcode.cn/problems/basic-calculator-ii/solutions/91271/chai-jie-fu-za-wen-ti-shi-xian-yi-ge-wan-zheng-ji-/


    // 1. 将一个字符串转换成数字
    int transToNum(String s){
        int num = 0;
        for(int i = 0 ; i < s.length() ; i++) num = num * 10 + (s.charAt(i) - '0');
        List<Integer> list = new ArrayList<>();
        return num;
    }


    @Test
    void test(){
        Assertions.assertEquals(cal1("5+3-3") , 5);
        Assertions.assertEquals(cal1("5+2 - 3") , 4);
        Assertions.assertEquals(cal1("5- 3- 3") , -1);

        Assertions.assertEquals(cal2("5- 3* 3") , -4);
        Assertions.assertEquals(cal2("5- 3/ 3") , 4);
        Assertions.assertEquals(cal2("5 + 1 + 3 * 3 -  3/ 3") , 14);
        Assertions.assertEquals(cal2(" 3/2 ") , 1);


        Assertions.assertEquals(cal3(" 3/(2+1) + 2 * 5 ") , 11);

        System.out.println(cal2("3-4*5+62*37*4+9*0"));

    }

    // 2. 处理只有加减法的算法： example: 5+4 - 3
    // 思路： 拆分成 +5 、+4 、 -3 压入栈中，累加栈中数字即可
    int cal1(String s){
        Stack<Integer> stack = new Stack<>();
        char op = '+';

        int num = 0; // 表示当前遍历到的数字
        for (int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);

            // 遇到空格跳过，这样会有问题！！！
            // if (c == ' ') continue;

            // 遇到数字累加
            if (c >= '0' && c <= '9') num = num * 10 + (c - '0');
            // 遇到 符号 或者 最后一个字符 压栈
            if (c == '+' || c == '-' || i == s.length()-1){

                if (op == '+') stack.push(num);
                else if (op == '-') stack.push(-num);

                // 更新符号 和 数字
                op = c;
                num = 0;
            }
        }
        //System.out.println(stack);

        // 栈中数字相加
        int res = 0;
        while (!stack.empty()) res += stack.pop();
        return res;
    }


    // 3. 算法中加入了乘除： example: 5+4 / 3

    // 和上一步的区别就是 遇到 * 、/ 的时候先计算再 压栈
    int cal2(String s){
        Stack<Integer> stack = new Stack<>();
        char op = '+';

        int num = 0; // 表示当前遍历到的数字
        for (int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);

            // 遇到空格跳过,下面这么写会有问题！！， 最后一个字符为空格的话就直接不计算了！！！
            //if (c == ' ') continue;

            // 遇到数字累加
            if (c >= '0' && c <= '9') num = num * 10 + (c - '0');
            // 遇到 符号 或者 最后一个字符 压栈
            if (c == '+' || c == '-' || c == '*' || c == '/' || i == s.length()-1){

                if (op == '+') stack.push(num);
                else if (op == '-') stack.push(-num);
                else if (op == '*') stack.push(num * stack.pop());
                else if (op == '/') stack.push(stack.pop() / num);

                // 更新符号 和 数字
                op = c;
                num = 0;
            }
        }

        //System.out.println(stack);

        // 栈中数字相加
        int res = 0;
        while (!stack.empty()) res += stack.pop();
        return res;
    }



    // 4. 算法中加入了 括号： example ： 5 + 3 + (2 -1)
    // 思路：将 (***) 看做一个数字，进行递归调用，那么遇到 ( 就开始递归 ， 遇到 ) 就结束递归
    // 需要注意的时候 i 作为位置信息要不断的递归传入

    int index = 0;
    int cal3(String s){
        return solve(s);
    }

    private int solve(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char op = '+';
        while (index < s.length()){
            char c = s.charAt(index++);
            if (c >= '0' && c <= '9') num = num * 10 + (c - '0');
            // 开始递归
            if (c == '(') num = solve(s);

            if (c == '+' || c == '-' || c == '*' || c == '/' || c == ')' || index == s.length()){  // 遇到右括号也要计算
                if (op == '+') stack.push(num);
                else if (op == '-') stack.push(-num);
                else if (op == '*') stack.push(stack.pop() * num);
                else if (op == '/') stack.push(stack.pop() / num);

                op = c;
                num = 0;
            }

            // 结束递归
            if (c == ')') break;
        }


        // 栈中数字相加
        int res = 0;
        while (!stack.empty()) res += stack.pop();
        return res;
    }
}
