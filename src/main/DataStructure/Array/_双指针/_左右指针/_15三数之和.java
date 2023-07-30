package DataStructure.Array._双指针._左右指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/3sum/
public class _15三数之和 {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
               // System.out.println("i = " + nums[i] + ",L = " + nums[L] + ",R = " + nums[R]);
               // System.out.println(sum);
                if (sum == 0){
                    res.add(Arrays.asList(nums[i] , nums[L] , nums[R]));
                    while (L < R && nums[L] == nums[L+1]) L++;
                    while (L < R && nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                }else if (sum > 0) R--;
                else L++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1 , 0 , 1, 2 , -1, -4};
        System.out.println(threeSum(nums));
    }
}
