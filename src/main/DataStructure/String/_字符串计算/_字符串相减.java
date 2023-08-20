package DataStructure.String._字符串计算;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _字符串相减 {


    @Test
    void test(){
        Assertions.assertEquals(subString("123" , "456") , "-333");
        Assertions.assertEquals(subString("456" , "123") , "333");
        Assertions.assertEquals(subString("456" , "432") , "24");
        Assertions.assertEquals(subString("456" , "456") , "0");
    }


    String subString(String num1 , String num2){
        if (num1.equals(num2)) return "0";
        String res = "0";
        if (num1.compareTo(num2) > 0) res = sub(num1 , num2);
        else res = "-" + sub(num2 , num1);
        return res;
    }

    // 字符串相减
    // 4 5 6
    // 1 2 3
    String sub(String num1 , String num2){
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int l1 = num1.length()-1 , l2 = num2.length()-1;
        while (l1 >= 0 || l2 >= 0){
            int a = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
            int b = l2 >= 0 ? num2.charAt(l2) - '0' : 0;
            int sum = (a - b - carry + 10) % 10; // a - b - carry 可能为负数
            sb.append(sum);
            carry = a - b - carry >= 0 ? 0 : 1;
            l1--;
            l2--;
        }
        String res = sb.reverse().toString();
       // System.out.println("num1: " + num1 + " num2: " + num2 + " res: " +res);
        // 删除前导0
        for(int i = 0 ; i < res.length() ; i++){
            if (res.charAt(i) != '0') return res.substring(i);
        }
        return res;
    }
}
