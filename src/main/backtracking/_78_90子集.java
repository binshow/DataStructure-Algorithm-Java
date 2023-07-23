package backtracking;

import java.util.ArrayList;
import java.util.List;

public class _78_90子集 {


    // https://leetcode.cn/problems/subsets/
    // 不含重复数字
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        dfs(nums , 0 , list , res);
        return res;

    }

    private void dfs(int[] nums, int start, List<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums , i + 1 , list , res);
            list.remove(list.size()-1);
        }
    }


}
