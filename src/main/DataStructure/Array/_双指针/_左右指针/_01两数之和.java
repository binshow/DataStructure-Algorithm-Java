package DataStructure.Array._双指针._左右指针;

import java.util.HashMap;
import java.util.Map;

public class _01两数之和 {

    //https://leetcode.cn/problems/two-sum/
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[2];
        int[] res = new int[2];
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if (map.containsKey(target - nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i] , i);
        }
        return new int[]{-1,-1};
    }
}
