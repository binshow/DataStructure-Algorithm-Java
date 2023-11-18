package Algorithm.two_pointers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.cn/problems/4sum/description/
public class _18_4sum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) return res;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = nums.length-1; j >= 0; j--) {
                if (j < nums.length-1 && nums[j] == nums[j+1]) continue;
                int L = i+1;
                int R = j-1;
                while (L < R){
                    long sum = nums[i] + nums[L] + nums[R] + nums[j];
                    if (sum == target){
                        res.add(Arrays.asList(nums[i] , nums[L] , nums[R] , nums[j]));
                        while (L < R && nums[L] == nums[L+1]) L++;
                        while (L < R && nums[R] == nums[R-1]) R--;
                        L++;
                        R--;
                    }else if (sum > target) R--;
                    else L++;
                }
            }
        }
        return res;
    }
}
