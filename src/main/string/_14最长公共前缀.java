package string;


// https://leetcode.cn/problems/longest-common-prefix/
public class _14最长公共前缀 {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    //输入：strs = ["flower","flow","flight"]
    //输出："fl"
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {

            int j = 0;
            String tem = strs[i];
            while (j < tem.length() && j < res.length() && tem.charAt(j) == res.charAt(j)) j++;
            res = res.substring(0 , j);
        }
        return res;
    }
}
