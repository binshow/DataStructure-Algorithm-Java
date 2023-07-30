package DataStructure.Array._子数组问题;

import java.util.Arrays;

// https://leetcode.cn/problems/maximum-length-of-repeated-subarray/
public class _718最长重复子数组 {

    public int findLength(int[] nums1, int[] nums2) {

        int l1 = nums1.length;
        int l2 = nums2.length;
        if(l1 == 0 || l2 == 0) return 0;
        //dp[i][j] 表示以A[i] 和 B[j] 结尾时的最长公共子数组
        int[][] dp = new int[l1+1][l2+1];
        int res = 0;
        for(int i = 1 ; i <= l1 ; i++){
            for(int j = 1 ; j <= l2 ; j++){
                if(nums1[i-1] == nums2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = 0;

                res = Math.max(res , dp[i][j]);
            }
        }

        // for(int[] tem : dp) System.out.println(Arrays.toString(tem));

        return res;

    }
}
