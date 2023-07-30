package DataStructure.Array;

import java.util.Arrays;

// https://leetcode.cn/problems/trapping-rain-water/
public class _42接雨水 {

    // 每个格子的雨水 = min(left ， right) - cur
    public static int trap(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        int[] maxL = new int[n];
        int[] maxR = new int[n];

        for(int i = 1 ; i < n ; i++) maxL[i] = Math.max(maxL[i-1] , nums[i-1]);
        for(int i = n-2 ; i >= 0 ; i--) maxR[i] = Math.max(maxR[i+1]  , nums[i+1]);

        System.out.println("max left: " + Arrays.toString(maxL) + " max right: " + Arrays.toString(maxR));

        int res = 0;
        for (int i = 0; i < n; i++) {
            int cur = Math.min(maxL[i] , maxR[i]);
            if (cur > nums[i]) res += cur - nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{4,2,0,3,2,5}));
    }


}
