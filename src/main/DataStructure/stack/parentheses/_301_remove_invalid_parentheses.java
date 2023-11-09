package DataStructure.stack.parentheses;

import java.util.*;


//https://leetcode.cn/problems/remove-invalid-parentheses/solutions/1068652/gong-shui-san-xie-jiang-gua-hao-de-shi-f-asu8/
public class _301_remove_invalid_parentheses {


    //给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
    //
    //返回所有可能的结果。答案可以按 任意顺序 返回。


    //示例 1：
    //
    //输入：s = "()())()"
    //输出：["(())()","()()()"]
    //示例 2：
    //
    //输入：s = "(a)())()"
    //输出：["(a())()","(a)()()"]
    //示例 3：
    //
    //输入：s = ")("
    //输出：[""]



    //首先我们令左括号的得分为 1；右括号的得分为 −1。则会有如下性质：
    //
    //对于一个合法的方案而言，必然有最终得分为 0；
    //搜索过程中不会出现得分值为 负数 的情况（当且仅当子串中某个前缀中「右括号的数量」大于「左括号的数量」时，会出现负数，此时不是合法方案）。
    //同时我们可以预处理出「爆搜」过程的最大得分： max = min(左括号的数量, 右括号的数量)


    // 思路：暴力搜索
    // 1.爆搜」过程的最大得分必然是：合法左括号先全部出现在左边，之后使用最多的合法右括号进行匹配。
    //
    //枚举过程中出现字符分三种情况：
    //
    // - 左括号：如果增加当前 ( 后，仍为合法子串（即 score+1<=max score + 1 <= maxscore+1<=max) 时，我们可以选择添加该左括号，也能选择不添加；
    // - 右括号：如果增加当前 ) 后，仍为合法子串（即 score−1>=0 score - 1 >= 0score−1>=0) 时，我们可以选择添加该右括号，也能选择不添加；
    // - 普通字符：直接添加。
    //使用 Set 进行方案去重，lenlenlen 记录「爆搜」过程中的最大子串，然后只保留长度等于 lenlenlen 的子串。
    //




    int len = 0;
    Set<String> set = new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int n = s.length();

        // 记录左括号 和 右括号 出现的次数
        int l = 0 , r = 0;
        for (char c : s.toCharArray()){
            if (c == '(') l++;
            else if (c == ')') r++;
        }

        // 最多存在 max 对括号
        int max = Math.min(l , r);


        dfs( 0 , "" , s , 0 , max);
        return new ArrayList<>(set);

    }


    // start 起始位置
    // score 字符串的最终得分
    // max 最多多少对括号
    private void dfs(int start, String cur ,  String s, int score, int max) {
        if (score < 0 || score > max) return;
        if (start == s.length()){
            if (score == 0 && cur.length() >= len){
                if (cur.length() > len) set.clear();
                len = cur.length();
                set.add(cur);
            }
            return;
        }

        char c = s.charAt(start);
        if (c == '('){
            dfs(start + 1 , cur + "(" , s , score + 1 , max);
            dfs(start + 1 , cur  , s , score , max);
        }else if (c == ')'){
            dfs(start + 1 , cur + ")" , s , score - 1 , max);
            dfs(start + 1 , cur  , s , score , max);
        }else {
            dfs(start + 1 , cur + c , s , score , max);
        }


    }
}
