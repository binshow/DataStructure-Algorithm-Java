package Algorithm.backtracking._集合划分问题;


import org.junit.jupiter.api.Test;

public class _473火柴拼正方形 {

    //https://leetcode.cn/problems/matchsticks-to-square/

    @Test
    void test(){

    }

    // 能否分为 和为 sum / 4 的四个 子序列
    public boolean makesquare(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 4 != 0) return false;

        int[] bucket = new int[4];
        return dfs(nums , 0 , sum / 4 , bucket);
    }


    boolean dfs(int[] nums , int start , int target , int[] bucket){
        if(start == nums.length){
            for(int tem : bucket){
                if(tem != target) return false;
            }
            return true;
        }

        for(int i = 0 ; i < bucket.length ; i++){
            if(bucket[i] + nums[start] > target) continue;
            if(i > 0 && bucket[i] == bucket[i-1]) continue;

            bucket[i] += nums[start];
            if(dfs(nums , start+1 , target , bucket)) return true;
            bucket[i] -= nums[start];
        }
        return false;
    }


}
