package DataStructure.String._回文串;

public class _680验证回文串v2 {

    public boolean validPalindrome(String s) {
        int l = 0 , r = s.length()-1;
        while (l < r){
            if (s.charAt(l) != s.charAt(r)) return isValid(s , l+1 , r) || isValid(s , l , r-1);
            l++;
            r--;
        }
        return true;
    }

    boolean isValid(String s , int l , int r){
        while (l < r){
            char a = s.charAt(l);
            char b = s.charAt(r);
            if (a != b) return false;
            l++;
            r--;
        }
        return true;
    }
}
