package DataStructure.Array._双指针._左右指针;


//https://leetcode.cn/problems/3sum-closest/

import java.util.Arrays;

public class _16最接近的三数之和 {

    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) return 0;
        int res = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length; i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int L = i + 1;
            int R = nums.length-1;
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == target) return target;
                else if (sum < target) L++;
                else R--;

                // 更新结果集
                if (Math.abs(target - res) > Math.abs(target - sum)){
                    res = sum;
                }
            }
        }
        return res;
    }
}
