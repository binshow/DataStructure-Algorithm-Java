package string;

/**
 * @author shengbinbin
 * @description: 移除最外层的括号：https://leetcode.cn/problems/remove-outermost-parentheses/
 * @date 2022/5/2810:53 AM
 */
/*
* Input: s = "(()())(())(()(()))"
Output: "()()()()(())"
Explanation:
The input string is "(()()) (()) (()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
* */
public class Remove_Outermost_Parentheses {

    public static void main(String[] args) {
        String s = "(()())(())";
       // String s = "(()())(())(()(()))";
        System.out.println(removeOuterParentheses(s)); // ()()()()(())
    }

    public static String removeOuterParentheses(String s) {
        int n = s.length();
        int[] nums = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') sum -= 1;
            else sum += 1;
            if (sum == 0) nums[i] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n-1; i++) {
            if (nums[i] == 1) {
                i++;
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

}
