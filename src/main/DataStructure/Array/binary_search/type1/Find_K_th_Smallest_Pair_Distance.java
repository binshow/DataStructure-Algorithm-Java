package DataStructure.Array.binary_search.type1;

import java.util.Arrays;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
 * @date 2022/6/159:39 AM
 */
public class Find_K_th_Smallest_Pair_Distance {

    // 找出第K小的数对距离
    // 值域二分
    // 1 1 3 5 6 7
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        // 数对距离的取值范围
        int l = 0 , r = nums[n-1] - nums[0];
        int res = r;
        while (l < r){
            int mid = l + r >> 1;

            //找到数对距离小于mid的有几个
            int count = 0;
            int i = 0;
            for (int j = 0; j < n; j++) {
                while (nums[j] - nums[i] > mid) i++;
                count += (j - i);
            }

            if (count < k) {
                l = mid + 1;
            } else {
                res = mid;
                r = mid;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1 , 6 , 1};

    }
}
