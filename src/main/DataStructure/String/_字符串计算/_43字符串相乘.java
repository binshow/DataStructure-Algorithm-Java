package DataStructure.String._字符串计算;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// https://leetcode.cn/problems/multiply-strings/
public class _43字符串相乘 {


    @Test
    void test(){
        Assertions.assertEquals(multiply("123" , "456") , "56088");
        Assertions.assertEquals(multiply("1" , "456") , "456");
        Assertions.assertEquals(multiply("123" , "4") , "492");
    }

    // 1 2 3
    // 4 5 6

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        String res = "0";
        for(int i = num2.length()-1 ; i >= 0 ; i--){
            StringBuilder sb = new StringBuilder();
            for(int j = num2.length()-1 ; j > i ; j--) sb.append("0");

            int carry = 0;
            for(int k = num1.length()-1 ; k >= 0 ; k--){
                int a = num1.charAt(k) - '0';
                int b = num2.charAt(i) - '0';
                int sum =  a * b + carry;
                carry = sum / 10;
                sb.append(sum % 10);
            }
            if (carry > 0) sb.append(carry);

            res = addString(res , sb.reverse().toString());
           // System.out.println("num1:" + res  + " num2: " + sb.reverse().toString() + " res: " + res);
        }

        return res;
    }

    private String addString(String num1, String num2) {
        if (num1.length() == 0) return num2;
        if (num2.length() == 0) return num1;
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int l1 = num1.length()-1 , l2 = num2.length()-1;
        while (l1 >= 0 || l2 >= 0){
            int a = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
            int b = l2 >= 0 ? num2.charAt(l2) - '0' : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            res.append(sum % 10);
            l1--;
            l2--;
        }
        if (carry == 1) res.append(carry);
        return res.reverse().toString();
    }
}
