package DataStructure.stack.parentheses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class _20_valid_parentheses {



    @Test
    void test(){
        Assertions.assertEquals(isValid("()") , true);
        Assertions.assertEquals(isValid("()[]{}") , true);
        Assertions.assertEquals(isValid("(]") , false);

    }

    // 判断是否是有效的括号
    // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    // determine if the input string is valid.
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else {
                if (stack.empty()) return false;
                else if (stack.pop() != c) return false;
            }
        }
        return stack.empty();
    }
}
