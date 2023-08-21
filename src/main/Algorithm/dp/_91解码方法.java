package Algorithm.dp;

public class _91解码方法 {

    // https://leetcode.cn/problems/decode-ways/

    public int numDecodings(String s) {
        int n = s.length();
        // Algorithm.dp[i] 表示 以 s[i] 结尾的字符串的编码方法
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1 ; i <= n ; i++){
            //1. 如果最后一个字母不是0 ， 说明方法数 和 i-1 相同
            if (s.charAt(i-1) != '0') dp[i] = dp[i-1];
            //2. 判断最后两个数是不是在 10 - 26 之间
            if (i >= 2){
                String tem = s.substring(i-2 , i);
                int num = Integer.parseInt(tem);
                if ( num >= 10 && num <= 26) dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

}
