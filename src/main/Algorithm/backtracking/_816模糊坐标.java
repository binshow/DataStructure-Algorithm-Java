package Algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

public class _816模糊坐标 {


    public List<String> ambiguousCoordinates(String s) {
        List<String> res = new ArrayList<>();
        s = s.substring(1 , s.length()-1);
        for(int i = 1 ; i < s.length() ; i++){

            // i 划分x和y
            for (String x : generate(s.substring(0 , i))){
                for (String y : generate(s.substring(i))){
                    res.add("(" + x + ", " + y + ")");
                }
            }
        }
        return res;
    }

    // 划分小数点
    private List<String> generate(String num) {
        List<String> res =  new ArrayList<>();
        if (num.length() == 1 || num.charAt(0) != '0') {
            res.add(num);
        }
        for(int i = 0; i < num.length() - 1 ; i++){
            String a = num.substring(0 , i+1);
            String b = num.substring(i+1 , num.length());
            if (a.length() > 1 && a.charAt(0) == '0') continue;
            if (b.charAt(b.length()-1) == '0') continue;
            res.add(a + "." + b);
        }
        return res;
    }
}
