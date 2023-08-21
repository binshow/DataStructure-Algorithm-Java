package Algorithm.backtracking._分割问题;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class _131分割回文串 {


    @Test
    public void test(){
        Assertions.assertEquals(partition("aab").toString() , "[[a, a, b], [aa, b]]");
    }


    // https://leetcode.cn/problems/palindrome-partitioning/
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        dfs(s , 0 , list , res);
        return res;
    }

    private void dfs(String s, int start, List<String> list, List<List<String>> res) {
        if (start == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = start ; i < s.length() ; i++){
            String temp = s.substring(start , i+1);
           /// System.out.println("temp : "  + temp);
            if (isValid(temp)){
                list.add(temp);
                dfs(s , i+1 , list , res);
                list.remove(list.size()-1);
            }
        }
    }

    // 判断是不是回文
    private boolean isValid(String s) {
        int l = 0 , r = s.length()-1;
        while (l < r){
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }

}
