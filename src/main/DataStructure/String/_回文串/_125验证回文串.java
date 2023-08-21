package DataStructure.String._回文串;

public class _125验证回文串 {
    //https://leetcode.cn/problems/valid-palindrome/description/
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        // System.out.println(s);
        int l = 0 , r = s.length()-1;
        while (l <= r){
            char a = s.charAt(l);
            char b = s.charAt(r);
            // 不是数字 or 字母就跳过
            if (!check(a)){
                l++;
                continue;
            }
            if (!check(b)){
                r--;
                continue;
            }
            if (a != b) return false;
            l++;
            r--;
        }
        return true;

    }

    boolean check(char a){
        if (a >= '0' && a <= '9') return true;
        if (a >= 'a' && a <= 'z') return true;
        return false;
    }
}
