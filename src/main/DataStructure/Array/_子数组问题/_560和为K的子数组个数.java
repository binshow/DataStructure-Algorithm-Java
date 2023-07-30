package DataStructure.Array._子数组问题;

// 为什么这题不可以用双指针/滑动窗口：因为nums[i]可以小于0，也就是说右指针i向后移1位不能保证区间会增大，左指针j向后移1位也不能保证区间和会减小。给定j，i的位置没有二段性

import java.util.HashMap;
import java.util.Map;

public class _560和为K的子数组个数 {

    // https://leetcode.cn/problems/subarray-sum-equals-k/


    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // key 为前缀和 ， value 为出现的次数
        Map<Integer , Integer> map = new HashMap<>();
        map.put(0 , 1);
        int sum = 0 ;
        int res = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (map.containsKey(k - sum)) res += map.get(k - sum);
            map.put(sum , map.getOrDefault(sum , 0) + 1);
        }
        System.out.println(map);
        return res;

    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subarraySum(nums, 3));

    }
}
