package Algorithm.backtracking._子集问题;

import java.util.ArrayList;
import java.util.List;


// https://leetcode.cn/problems/combinations/
public class _77组合 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < 1 || k == 0) return res;
        List<Integer> list = new ArrayList<>();
        dfs(1 , n , k , list , res);
        return res;
    }

    private void dfs(int start, int n, int k, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(i + 1 , n , k , list , res);
            list.remove(list.size()-1);
        }
    }
}
