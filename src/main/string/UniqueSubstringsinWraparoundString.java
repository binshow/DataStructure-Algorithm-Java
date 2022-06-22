package string;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/unique-substrings-in-wraparound-string/
 * @date 2022/5/2511:10 PM
 */
public class UniqueSubstringsinWraparoundString {

    // 环绕字符串中唯一的子字符串个数
    // https://leetcode.cn/problems/unique-substrings-in-wraparound-string/solution/wei-rao-li-lun-by-wfnuser-mhg2/
    public int findSubstringInWraproundString(String p) {

        int n = p.length();
        int[] cnt = new int[26];  // 每个数代表以当前字符结尾的子串个数

        int temp = 1;
        char[] ps = p.toCharArray();
        cnt[ps[0] - 'a'] = 1 ; // 第一个字符结尾的子串只能为它一个

        // 无限环绕字符串任意两个相邻字符都满足字典序上的相邻。也就是s[i] == (s[i-1] + 1) % 26。
        // 比如：abc ， 那么以c结尾的子串就是 以b结尾的子串
        /*
        * 统计以每个字符作为结尾的最长连续序列(可以覆盖掉重复的短序列的情况), 他们的和即为所求
        例如:abcdbcd, 对于以d结尾的有abcd, bcd, cd和d, 而bcd产生的序列都会被abcd所覆盖
        总和即以a、b、c和d结尾的所有连续最长序列1 + 2 + 3 + 4 = 10
        * */
        for (int i = 1; i < n; i++) {
            if ( (ps[i] - ps[i-1] + 26) % 26 == 1) {   // 判断 i 前面的字符是否满足 无限环绕子串的的特点 ， 比如 abc， 那么以a结尾的是a ， 以b结尾的有a，ab ， c也同理
                temp++;
                cnt[ps[i] - 'a'] = Math.max(cnt[ps[i] - 'a'], temp);
            }else{
                temp = 1;       // 不满足 说明需要重头开始了    abcf  那么以f结尾的子串 只能是 f
                cnt[ps[i] - 'a'] = Math.max(cnt[ps[i] - 'a'], 1);
            }
        }


        // cnt 所有元素之和即为结果
        int res = 0;
        for(int num : cnt) res += num;
        return res;
    }
}
