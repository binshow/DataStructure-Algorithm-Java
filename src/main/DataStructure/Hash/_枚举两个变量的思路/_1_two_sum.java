package DataStructure.Hash._枚举两个变量的思路;

import java.util.HashMap;
import java.util.Map;


// https://leetcode.cn/problems/two-sum/
public class _1_two_sum {


    // 对于有两个变量的题目，通常可以枚举其中一个变量，把它视作常量，从而转化成只有一个变量的问题 !!!!


    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0 ; i < nums.length ; i++){
            if(map.containsKey(target - nums[i])){
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }
            map.put(nums[i] , i);
        }
        return res;

    }
}
