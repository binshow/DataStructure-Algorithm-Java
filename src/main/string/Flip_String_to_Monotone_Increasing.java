package string;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/flip-string-to-monotone-increasing/
 * @date 2022/6/114:17 PM
 */
public class Flip_String_to_Monotone_Increasing {

    public static void main(String[] args) {
        String s = "000110001111111100000010101001010";
        String s2 = "10011111110010111011";
        System.out.println(minFlipsMonoIncr(s2));
    }

    // 将字符串翻转到 单调递增  所需的最小次数

    // 解法1： 将问题等价于 字符串s的长度为n , 找到字符串s中的最长不下降子序列，其长度为ans，那么结果 n-ans 就是本题的答案
    // 见题：https://leetcode.cn/problems/longest-increasing-subsequence/
    private static int minFlipsMonoIncr(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length, res = 0;
        int[] tail = new int[n];
        for (int i = 0; i < n; i++) {
            int t = s.charAt(i) - '0';
            int l = 0, r = res;
            while (l < r) {
                int mid = l + r >> 1;
                if (tail[mid] > t) r = mid;
                else l = mid + 1;
            }
            tail[l] = t;
            if (res == l) res++;
        }
        return n - res;
    }
}
