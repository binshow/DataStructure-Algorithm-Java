package backtracking.combination;

// https://leetcode.cn/problems/combination-sum-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40组合总和v2 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        if (nums.length == 0) return res;
        List<Integer> list = new ArrayList<>();

        Arrays.sort(nums);
        dfs(nums , 0 , list , target  );
        return res;
    }

    private void dfs(int[] nums, int start, List<Integer> list, int target ) {
        if (target < 0) return;
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // 排序去重
            if(i > start && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            dfs(nums , i+1 , list , target - nums[i] );
            list.remove(list.size()-1);

        }
    }
}
