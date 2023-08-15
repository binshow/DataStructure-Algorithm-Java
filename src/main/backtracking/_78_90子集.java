package backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _78_90子集 {



    @Test
    public void test(){
        Assertions.assertEquals(subsets(new int[]{1,2,3}).toString() , "[[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]");
        Assertions.assertEquals(subsets(new int[]{0}).toString() , "[[], [0]]");
    }



    // https://leetcode.cn/problems/subsets/
    // 不含重复数字
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums , 0 , list, res);
        return res;
    }

    void dfs(int[] nums , int start , List<Integer> list , List<List<Integer>> res){
        res.add(new ArrayList<>(list));

        for(int i = start ; i < nums.length ; i++){
            list.add(nums[i]);
            dfs(nums , i + 1 , list , res);
            list.remove(list.size()-1);
        }
    }


    // https://leetcode.cn/problems/subsets-ii/ 包含重复数字

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfsV2(nums , 0 , list, res);
        return res;
    }

    void dfsV2(int[] nums , int start , List<Integer> list , List<List<Integer>> res){
        res.add(new ArrayList<>(list));

        for(int i = start ; i < nums.length ; i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            dfsV2(nums , i + 1 , list , res);
            list.remove(list.size()-1);
        }
    }

}
