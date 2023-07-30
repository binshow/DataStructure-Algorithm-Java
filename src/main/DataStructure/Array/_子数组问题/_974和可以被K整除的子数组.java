package DataStructure.Array._子数组问题;

import java.util.HashMap;
import java.util.Map;

public class _974和可以被K整除的子数组 {

    // https://leetcode.cn/problems/subarray-sums-divisible-by-k/

    public int subarraysDivByK(int[] nums, int k) {
        // key 存余数， value 存个数
        Map<Integer , Integer> map = new HashMap<>();
        map.put(0 , 1);
        int n = nums.length;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];

            // (sum - x) % k == 0
            int mod = (sum % k + k) % k;
            res += map.getOrDefault(mod , 0);
            map.put(mod , map.getOrDefault(sum , 0) + 1);
        }
        return res;
    }
}
