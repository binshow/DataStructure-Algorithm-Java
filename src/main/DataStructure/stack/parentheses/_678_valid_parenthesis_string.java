package DataStructure.stack.parentheses;

import java.util.Stack;


//https://leetcode.cn/problems/valid-parenthesis-string/description/
public class _678_valid_parenthesis_string {

    //Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.
    //
    //The following rules define a valid string:
    //
    //Any left parenthesis '(' must have a corresponding right parenthesis ')'.
    //Any right parenthesis ')' must have a corresponding left parenthesis '('.
    //Left parenthesis '(' must go before the corresponding right parenthesis ')'.
    //'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".


    // 双栈
    public boolean checkValidString(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> help = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push(i);
            else if (c == '*') help.push(i);
            else {
                if (!stack.empty()) stack.pop();   // 要么弹出 ( , 要么弹出 * , 要么就不合理
                else if (!help.empty()) help.pop();
                else return false;
            }
        }

        // ( 要在 * 前
        while (!stack.empty() && !help.empty()){
            int l = stack.pop();
            int r = help.pop();
            if (l > r) return false;
        }
        // 所有左括号都匹配完成
        return stack.empty();
    }
}
