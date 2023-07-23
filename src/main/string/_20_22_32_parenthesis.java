package string;


// 括号问题

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _20_22_32_parenthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));

        System.out.println(longestValidParentheses(")()())"));
    }


    //https://leetcode.cn/problems/valid-parentheses/
    //输入：s = "()[]{}"
    //输出：true
    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }


    // 22. https://leetcode.cn/problems/generate-parentheses/
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res , n , n , "");
        return res;
    }

    private static void dfs(List<String> res, int l, int r , String cur) {
        if (l == r && l == 0) res.add(new String(cur));

        if (l > 0) dfs(res , l - 1 , r  , cur + "(");
        if (r > l) dfs(res , l , r - 1 , cur + ")");
    }


    // https://leetcode.cn/problems/longest-valid-parentheses/
    public static int longestValidParentheses(String s) {
        if (s.length() == 0) return 0;
        int[] res = new int[s.length()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0 ; i < s.length() ; i++){
            if (s.charAt(i) == '(') stack.push(i);
            else if (s.charAt(i) == ')' && !stack.isEmpty()){
                res[i] = 1;
                res[stack.pop()] = 1;
            }
        }

        System.out.println(Arrays.toString(res));

        // 最长连续1的长度
        int ans = 0;
        int count = 0;
        for (int i = 0; i < res.length; i++) {
            if (res[i] == 1) count++;
            else count = 0;
            ans = Math.max(ans , count);
        }
        return ans;
    }
}
