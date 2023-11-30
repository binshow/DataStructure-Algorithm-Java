package Algorithm.slide_windows;

// https://leetcode.cn/problems/replace-the-substring-for-balanced-string/description/
public class _1234_替换子串得到平衡字符串 {


    //有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
    //假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
    //
    //
    //给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
    //
    //你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
    //
    //请返回待替换子串的最小可能长度。
    //
    //如果原字符串自身就是一个平衡字符串，则返回 0。
    //
    //
    //
    //示例 1：
    //
    //输入：s = "QWER"
    //输出：0
    //解释：s 已经是平衡的了。
    //示例 2：
    //
    //输入：s = "QQWE"
    //输出：1
    //解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
    //示例 3：
    //
    //输入：s = "QQQW"
    //输出：2
    //解释：我们可以把前面的 "QQ" 替换成 "ER"。
    //示例 4：
    //
    //输入：s = "QQQQ"
    //输出：3
    //解释：我们可以替换后 3 个 'Q'，使 s = "QWER"。



    /*
    *  思路：反向思维 如果在待替换子串之外的任意字符的出现次数超过 m = (n / 4),那么无论怎么替换，都无法使这个字符的出现次数等于 m
    * 反过来说，如果在待替换子串之外的任意字符的出现次数都不超过 m，那么可以通过替换，使 s 为平衡字符串，即每个字符的出现次数均为 m
    * */

    public int balancedString(String s) {
        int n = s.length();
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'A']++;
        int m = n / 4;
        if (count['Q'-'A'] == m && count['W'-'A'] == m && count['E'-'A'] == m && count['R'-'A'] == m) return 0;

        // 开始滑动
        int l = 0 , r = 0;
        int res = s.length();
        while (r < s.length()){
            count[s.charAt(r) - 'A']--;
            while (check(count , m)){ // 此时窗口内的子串都可以替换
                res = Math.min(res , r - l + 1); // 更新结果
                count[s.charAt(l) - 'A']++;
                l++;
            }
            r++;
        }
        return res;

    }


    // 判断 nums 是否符合条件：
    // 1. 所有的 Q、W、E、R 出现都小于 m 次
    private boolean check(int[] nums , int limit) {
        return nums['Q' - 'A'] <= limit && nums['W' - 'A'] <= limit && nums['E' - 'A'] <= limit && nums['R' - 'A'] <= limit;
    }

}
