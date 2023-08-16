package backtracking._排列问题;

import java.util.ArrayList;
import java.util.List;

public class _784字母大小写全排列 {

    // https://leetcode.cn/problems/letter-case-permutation/

    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(s , 0 , sb , res);
        return res;
    }

    private void dfs(String s, int start, StringBuilder sb, List<String> res) {
        if (start == s.length()){
            res.add(new String(sb));
            return;
        }



        for (int i = start; i < s.length(); i++) {

            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
                continue;
            }

            sb.append(c ^= 32);
            dfs(s , i+1 , sb , res);
            sb.deleteCharAt(sb.length()-1);
            sb.delete(3 , sb.length());

        }
    }


}
