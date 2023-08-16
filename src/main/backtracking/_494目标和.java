package backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// https://leetcode.cn/problems/target-sum/
public class _494目标和 {



    @Test
    void test(){
        Assertions.assertEquals(findTargetSumWays(new int[]{1,1,1,1,1} , 3) , 5);
        Assertions.assertEquals(findTargetSumWays(new int[]{1} , 1) , 1);
    }

    int res = 0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums , 0 , target);
        return res;
    }

    private void dfs(int[] nums, int start, int target) {
        if (start == nums.length){
            if (target == 0) res++;
            return;
        }

        // 加或者减
        dfs(nums , start+1 , target - nums[start]);
        dfs(nums , start+1 , target + nums[start]);
    }
}
