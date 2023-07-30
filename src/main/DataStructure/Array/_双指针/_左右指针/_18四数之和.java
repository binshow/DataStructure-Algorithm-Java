package DataStructure.Array._双指针._左右指针;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/4sum/
public class _18四数之和 {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 4) return res;
        Arrays.sort(nums);
        int n = nums.length;
        System.out.println(Arrays.toString(nums));
        for(int i = 0 ; i < n ; i++){
            if (i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = n-1; j >= 0; j--) {
                if (j < n-1 && nums[j] == nums[j+1]) continue;
                int L = i + 1;
                int R = j - 1;
                while (L < R){
                    int sum = nums[i] + nums[j] + nums[L] + nums[R];
                    System.out.println(sum);
                    if (sum == target){
                        res.add(Arrays.asList(nums[i] , nums[j] , nums[L] , nums[R]));
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


    public static void main(String[] args) {
        int[] nums = {1,0,-1,0, -2,2};
        List<List<Integer>> res = fourSum(nums, 0);
        System.out.println(res);
    }

}
