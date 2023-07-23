package backtracking;

import java.util.ArrayList;
import java.util.List;

public class _93复原IP地址 {

    // https://leetcode.cn/problems/restore-ip-addresses/

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() == 0) return res;
        List<String> segment = new ArrayList<>();
        dfs(s , 0 , segment , res);
        return res;
    }

    private static void dfs(String s, int start, List<String> segment, List<String> res) {
        if (start == s.length()){
            if (segment.size() == 4){
                StringBuilder sb = new StringBuilder();
                for(String tem : segment) sb.append(tem).append(".");
                sb.deleteCharAt(sb.length()-1);
                res.add(sb.toString());
                return;
            }
        }

        if (segment.size() > 4) return;

        for (int i = start; i <= start + 2  && i < s.length(); i++) {
            String tem = s.substring(start , i + 1);
            if (tem.charAt(0) == '0' && tem.length() > 1) continue;
            int num = Integer.parseInt(tem);
            if (num >= 0 && num <= 255){
                segment.add(tem);
                dfs(s , i+1 , segment, res);
                segment.remove(segment.size()-1);
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("101023"));
    }
}
