package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
public class _17电话号码的字母组合 {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    static  Map<Character , char[]> map = new HashMap<>();
    private static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;

        map.put('2' , new char[]{'a' , 'b' , 'c'});
        map.put('3' , new char[]{'d' , 'e' , 'f'});
        map.put('4' , new char[]{'g' , 'h' , 'i'});
        map.put('5' , new char[]{'j' , 'k' , 'l'});
        map.put('6' , new char[]{'m' , 'n' , 'o'});
        map.put('7' , new char[]{'p' , 'q' , 'r' , 's'});
        map.put('8' , new char[]{'t' , 'u' , 'v'});
        map.put('9' , new char[]{'w' , 'x' , 'y' , 'z'});

        StringBuilder sb = new StringBuilder();
        dfs(digits , 0 , sb ,  res);
        return res;
    }

    private static void dfs(String digits, int start, StringBuilder sb, List<String> res) {
        if (start == digits.length()){
            res.add(new String(sb));
            return;
        }

        char[] chars = map.get(digits.charAt(start));
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            dfs(digits , start + 1 , sb , res);
            sb.deleteCharAt(sb.length()-1);
        }
    }


}
