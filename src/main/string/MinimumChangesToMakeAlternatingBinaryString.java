package string;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2022/11/2910:40 AM
 */
public class MinimumChangesToMakeAlternatingBinaryString {

    //https://leetcode.cn/problems/minimum-changes-to-make-alternating-binary-string/description/

    //Input: s = "1111"
    //Output: 2
    //Explanation: You need two operations to reach "0101" or "1010".
    public int minOperations(String s) {
        int n = s.length();
        int res = 0;
        char c = s.charAt(0);
        for (int i = 1; i < n; i++) {
            if (c == '1' && s.charAt(i) == '1'){
                res++;
                c = '0';
            }else if (c == '0' && s.charAt(i) == '0'){
                res++;
                c = '1';
            }else c = s.charAt(i);
        }

        // 10开头 和 01开头的两种可能取较小值
        return Math.min(res , n -  res);

    }

}
