package string;

public class _318最大单词长度乘积 {


    // https://leetcode.cn/problems/maximum-product-of-word-lengths/

    // 判断两个字符串是否有重复字符
    public int maxProduct(String[] words) {
        int res = 0;
        int n = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (check(words[i] , words[j])) res = Math.max(words[i].length() * words[j].length() , res);
            }
        }
        return res;
    }

    // 判断两个字符串是否有重复字符！！
    private boolean check(String s, String p) {
        int[] chars = new int[26];
        for(char c : s.toCharArray()) chars[c - 'a']++;

        for (char c : p.toCharArray()){
            if (chars[c - 'a'] != 0) return false;
        }
        return true;
    }


}
