package DataStructure.String;

// https://leetcode.cn/problems/string-to-integer-atoi/description/
public class _08字符串转整数 {

    public int myAtoi(String s) {
        //1. 去除空格
        s = s.trim();
        if(s.length() == 0) return 0;
        int index = 0;
        boolean isN = false;

        //2. 第一个数字不是 数字，也不是空格
        if (s.charAt(index) != '+' && s.charAt(index) != '-' && !(s.charAt(index) >= '0' && s.charAt(index) <= '9')) return 0;


        //3. 判断是不是负数
        if(s.charAt(index) == '-'){
            isN = true;
            index++;
        }else if(s.charAt(index) == '+') index++;


        long res = 0;
        while(index < s.length() && (s.charAt(index) >= '0' && s.charAt(index) <= '9') ){
            res = res * 10 + s.charAt(index) - '0';
            index++;
            if(res > Integer.MAX_VALUE) return isN ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        return isN ? -(int) res : (int) res;

    }
}
