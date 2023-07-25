package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39_40_216组合总和 {


    // https://leetcode.cn/problems/combination-sum/

    //输入：candidates = [2,3,6,7], target = 7
    //输出：[[2,2,3],[7]]
    //解释：
    //2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
    //7 也是一个候选， 7 = 7 。
    //仅有这两种组合。

    // 数字可以重复用
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        dfs(nums , 0 , target , list , res);
        return res;
    }

    private void dfs(int[] nums, int start, int target, List<Integer> list, List<List<Integer>> res) {
        if (target < 0) return;
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums , i , target - nums[i] , list , res);
            list.remove(list.size()-1);
        }
    }


    // https://leetcode.cn/problems/combination-sum-ii/
    // 一个数字只能用一次
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfsV2(nums , 0 , target , list , res);
        return res;

    }

    private void dfsV2(int[] nums, int start, int target, List<Integer> list, List<List<Integer>> res) {
        if (target < 0) return;
        if (target == 0){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            dfsV2(nums , i +1 ,  target - nums[i] , list , res);
            list.remove(list.size()-1);
        }
    }


    // https://leetcode.cn/problems/combination-sum-iii/
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0 || n == 0) return res;
        int[] nums = {1,2,3,4,5,6,7,8,9};
        List<Integer> list = new ArrayList<>();
        dfs3(nums , 0 , k , n , list , res);
        return res;

    }

    private void dfs3(int[] nums, int start, int k , int target, List<Integer> list, List<List<Integer>> res) {
        if (target < 0 || list.size() > k) return;
        if (target == 0) {
            if (list.size() == k) res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs3(nums , i + 1 , k , target - nums[i] , list , res);
            list.remove(list.size()-1);
        }
    }


}
