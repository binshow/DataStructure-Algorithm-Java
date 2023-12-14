package Algorithm.binarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class _354_俄罗斯套娃信封问题 {

    //You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
    //
    //One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
    //
    //Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
    //
    //Note: You cannot rotate an envelope.
    //
    //Example 1:
    //
    //Input: envelopes = [[5,4],[6,4],[6,7],[2,3]]
    //Output: 3
    //Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
    //Example 2:
    //
    //Input: envelopes = [[1,1],[1,1],[1,1]]
    //Output: 1

    @Test
    void test(){
        Assertions.assertEquals(maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}}) , 3);
        Assertions.assertEquals(maxEnvelopes(new int[][]{{1,1},{1,1},{1,1},{1,1}}) , 1);
        Assertions.assertEquals(maxEnvelopes(new int[][]{{4,5},{4,6},{6,7},{2,3},{1,1}}) , 4);
        //[4,5],[4,6],[6,7],[2,3],[1,1]
    }


    // 2,3 | 5,4 | 6,4 | 6,7

    // 1,1||2,3||4,5||4,6||6,7

    public int maxEnvelopes(int[][] envelopes) {
        // 先根据第一个数字排序, 第一个数字相同就根据第二个数字倒序排序！！！
        Arrays.sort(envelopes , (a , b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

       // System.out.println(Arrays.toString(envelopes));


        int[] nums = new int[envelopes.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = envelopes[i][1];
        }

       // System.out.println(Arrays.toString(nums));

        // 最长递增子序列就是 答案
        return maxSubsequence(nums);
    }

    private int maxSubsequence(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp , 1);

        int res = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i] , dp[j] + 1);
            }
            res = Math.max(res , dp[i]);
        }

        return res;
    }


}
