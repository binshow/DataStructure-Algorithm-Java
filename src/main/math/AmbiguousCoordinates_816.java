package math;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2022/11/711:00 PM
 */
public class AmbiguousCoordinates_816 {

    //https://leetcode.cn/problems/ambiguous-coordinates/

    //思路：暴力枚举
    //Input: s = "(123)"
    //Output: ["(1, 2.3)","(1, 23)","(1.2, 3)","(12, 3)"]
    public static List<String> ambiguousCoordinates(String s) {
        s = s.substring(1 , s.length()-1);
        List<String> res = new ArrayList<>();
        // 第一层for，枚举 逗号
        for (int i = 0; i < s.length() - 1; i++) {
            List<String> a = search(s , 0 , i);
            List<String> b = search(s , i+1 , s.length()-1);
            for (String x : a) {
                for (String y : b){
                    res.add("(" + x + ", " + y + ")");
                }
            }
        }
        return res;
    }

    // 枚举 s[l , r]的组合
    private static List<String> search(String s, int l, int r) {
        List<String> ans = new ArrayList<>();
        if (l == r || s.charAt(l) != '0') ans.add(s.substring(l , r + 1));
        // 枚举小数点
        for (int i = l; i < r; i++) {
            String a = s.substring(l , i+1);
            String b = s.substring(i+1 , r+1);
            if (a.length() > 1 && a.charAt(0) == '0') continue; // 剪支
            if (b.charAt(b.length()-1) == '0') continue;
            ans.add(a + "." + b);
        }
        return ans;
    }

    public static void main(String[] args) {
//        String s = "(012345)";
//        System.out.println(ambiguousCoordinates(s));
//        System.out.println(search(s, 1, 4));

        double a = 3;
        int b = 2;

        System.out.println( a/ b );


    }


}
