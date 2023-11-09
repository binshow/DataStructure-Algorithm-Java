package DataStructure.stack.parentheses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class _856_score_of_parentheses {


//Given a balanced parentheses string s, return the score of the string.
//The score of a balanced parentheses string is based on the following rule:

// "()" has score 1.
// AB has score A + B, where A and B are balanced parentheses strings.
// (A) has score 2 * A, where A is a balanced parentheses string.

    @Test
    void test(){
        Assertions.assertEquals(scoreOfParentheses("()") , 1);
        Assertions.assertEquals(scoreOfParentheses("(())") , 2);
        Assertions.assertEquals(scoreOfParentheses("()((()()()))") , 13);
    }

    public int scoreOfParentheses(String s) {
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(') stack.push("(");
            else if (c == ')'){
                // ()
                if (stack.peek().equals("(")){
                    stack.pop();
                    stack.push("1");
                } else {
                    // 51)
                 int num = 0;
                 while (!stack.peek().equals("(")){
                    num = num  + Integer.parseInt(stack.pop());
                 }
                  stack.pop();
                  stack.push((num * 2) + "" );
                }
            }
        }

        System.out.println(stack);

        int res = 0;
        while(!stack.empty()) res += Integer.parseInt(stack.pop());

        return res;
    }


}
