package stack;

import java.util.Stack;

/**
 * @author shengbinbin
 * @description: 括号有关的算法题
 * @date 2022/10/99:34 PM
 */
/*
*
*
* */
public class Parentheses {




    //https://leetcode.cn/problems/score-of-parentheses/
    //2022-10-9
    //The score of a balanced parentheses string is based on the following rule:
    //
    // "()" has score 1.
    // AB has score A + B, where A and B are balanced parentheses strings.
    // (A) has score 2 * A, where A is a balanced parentheses string.
    // () = 1  (()) = 2  ()() = 2
    public static int scoreOfParentheses(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push("(");
            else {
                // ()
                if (s.charAt(i-1) == '('){
                    stack.pop();
                    stack.push("1");
                }else {
                    //  ((1)) (11)
                    String a = stack.pop();
                    int tem = 0;
                    while (!a.equals("(")){
                        tem = tem + Integer.parseInt(a);
                        a = stack.pop();
                    }
                    tem = tem * 2;
                    stack.push(tem + "");
                }
            }
        }

        int res = 0;
        for (String num : stack) res += Integer.parseInt(num);
        return res;
    }







    public static void main(String[] args) {

        String s = "((())())";  // (3)
        System.out.println(scoreOfParentheses(s));

    }



}
