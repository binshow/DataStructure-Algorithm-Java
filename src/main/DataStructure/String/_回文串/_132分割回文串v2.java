package DataStructure.String._回文串;

public class _132分割回文串v2 {

    // https://leetcode.cn/problems/palindrome-partitioning-ii/
    // 求最少分割次数
    // 当切割次数最少使得切割后的所有字符串都是回文时，也正是这些回文子串最长的时候，那么如果说能找到以每个字符为中心的最长回文串，实际上就已经找到了答案。

    public int minCut(String s) {
        if (s.length() <= 1) return 0;
        int n = s.length();
        // dp[i] 表示0-i字符串最少分割次数为 dp[i]
        int[] dp = new int[n];

        // base case
        for (int i = 1; i < n; i++) dp[i] = i;


        for (int i = 0; i < n; i++) {
            helper(s , i , i , dp);  // 奇数回文串以1个字符为中心
            helper(s , i , i+1 , dp);  // 偶数回文串以2个字符为中心
        }
        return dp[n-1];
    }

    private void helper(String s, int l, int r, int[] dp) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            if (l == 0) dp[r] = 0;
            else  dp[r] = Math.min(dp[r], dp[l - 1] + 1);   // 否则， 当前切割次数 与 上一次切割次数 + 1 取最小值
            l--;
            r++;
        }
    }


    // 借助辅助dp
    public int minCutV2(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        // defination: dp[i] 表示 s[0-i]拆成回文的最小次数
        int[] dp = new int[n];
        // base case
        for(int i = 0 ; i < n ; i++) dp[i] = i;

        // 辅助 dp,  is[i][j] 表示 s[I-J]是否可以构成回文
        boolean[][] is = new boolean[n][n];
        for(int i = 0 ; i < n ; i++) is[i][i] = true;
        for(int i = n-2 ; i >= 0 ; i--){
            for(int j = i+1 ; j < n ; j++){
                if(s.charAt(i) != s.charAt(j)) is[i][j] = false;
                else {
                    if(j - i < 3) is[i][j] = true;
                    else is[i][j] = is[i+1][j-1];
                }
            }
        }


        //借助辅助dp开始遍历
        for(int i = 0 ; i < n ; i++){
            //如果已经构成回文了，则直接设置为1
            if(is[0][i]){
                dp[i] = 0;
                continue;
            }
            //往前找，一直找到能构成回文的
            for(int j = 0; j < i ; j++){
                if(is[j+1][i]) dp[i] = Math.min(dp[i] , dp[j]+1);
            }
        }

        return dp[n-1];

    }
}
