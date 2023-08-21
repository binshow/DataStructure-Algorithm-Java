package Algorithm.dp.string;

/**
 * @author shengbinbin
 * @description: 字符串类型的 Algorithm.dp 题
 * @date 2023/3/69:59 PM
 */
public class StringDPCode {

    //https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/
    //输入：s = "aababbab"
    //输出：2
    //解释：你可以选择以下任意一种方案：
    //下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
    //下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
    public int minimumDeletions(String s) {
        int count = 0;
        int res = 0;
        for(char c : s.toCharArray()){
            if (c == 'b') count++;
            else res = Math.min(res + 1 , count);
        }
        return res;
    }

}
