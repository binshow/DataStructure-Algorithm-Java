package backtracking;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _46_47全排列 {

    //https://leetcode.cn/problems/permutations/      // 不含重复数字
    //https://leetcode.cn/problems/permutations-ii/   //包含重复数字


    @Test
    void testPermute(){
        Assertions.assertEquals(permute(new int[]{1, 2, 3}).toString() , "[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]");
        Assertions.assertEquals(permute(new int[]{1, 0}).toString() , "[[1, 0], [0, 1]]");
    }



    @Test
    void testPermuteUnique(){
        Assertions.assertEquals(permuteUnique(new int[]{1,1,2}).toString() , "[[1, 1, 2], [1, 2, 1], [2, 1, 1]]");
        Assertions.assertEquals(permuteUnique(new int[]{1,2,3}).toString() , "[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]");
    }








    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        List<Integer> list = new ArrayList<>();
        boolean[] isv = new boolean[nums.length];
        dfs(nums , list , res , isv);
        return res;
    }

    private static void dfs(int[] nums, List<Integer> list, List<List<Integer>> res , boolean[] isv) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isv[i]) continue;
            list.add(nums[i]);
            isv[i] = true;
            dfs(nums , list , res , isv);
            list.remove(list.size()-1);
            isv[i] = false;
        }
    }








    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;
        Arrays.sort(nums);
        boolean[] isv = new boolean[nums.length];
        List<Integer> list = new ArrayList<>();
        dfsV2(nums , list , res , isv);
        return res;
    }

    private void dfsV2(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] isv) {
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && isv[i-1]) continue;
            if (isv[i]) continue;

            list.add(nums[i]);
            isv[i] = true;
            dfsV2(nums , list , res , isv);
            list.remove(list.size()-1);
            isv[i] = false;
        }
    }

}
