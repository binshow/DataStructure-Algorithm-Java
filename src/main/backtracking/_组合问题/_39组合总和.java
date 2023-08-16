package backtracking._组合问题;

// https://leetcode.cn/problems/combination-sum/

import java.util.ArrayList;
import java.util.List;

public class _39组合总和 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        if (nums.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        dfs(nums , 0 , target , list);
        return res;
    }

    private void dfs(int[] nums, int start, int target, List<Integer> list) {
        if (target < 0) return;
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums , i  , target - nums[i] , list);
            list.remove(list.size()-1);
        }
    }
}
