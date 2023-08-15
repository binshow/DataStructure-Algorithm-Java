package backtracking;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39_40_216组合总和 {


    // https://leetcode.cn/problems/combination-sum/
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
            dfs(nums , i , target - nums[i] , list , res); // 每个数字可以重复选取，因此还是从i开始
            list.remove(list.size()-1);
        }
    }

    @Test
    void testCombinationSum(){
        Assertions.assertEquals(combinationSum(new int[]{2,3,6,7}, 7).toString() , "[[2, 2, 3], [7]]");
        Assertions.assertEquals(combinationSum(new int[]{2,3,5}, 8).toString() , "[[2, 2, 2, 2], [2, 3, 3], [3, 5]]");
        Assertions.assertEquals(combinationSum(new int[]{2}, 1).toString() , "[]");
    }


    // https://leetcode.cn/problems/combination-sum-ii/
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);  // 排序去重
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
            if (i > start && nums[i] == nums[i-1]) continue;  // 取出重复数字带来的影响
            list.add(nums[i]);
            dfsV2(nums , i +1 ,  target - nums[i] , list , res);
            list.remove(list.size()-1);
        }
    }

    @Test
    void testCombinationSum2(){
        Assertions.assertEquals(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8).toString() , "[[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]");
        Assertions.assertEquals(combinationSum2(new int[]{2,5,2,1,2}, 5).toString() , "[[1, 2, 2], [5]]");
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


    @Test
    void testCombinationSum3(){
        Assertions.assertEquals(combinationSum3(3, 7).toString() , "[[1, 2, 4]]");
        Assertions.assertEquals(combinationSum3(3, 9).toString() , "[[1, 2, 6], [1, 3, 5], [2, 3, 4]]");
        Assertions.assertEquals(combinationSum3(4, 1).toString() , "[]");
    }


}
