package monotone_array;


// https://leetcode.cn/problems/shortest-subarray-with-sum-at-least-k/

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _862和至少为k的子数组 {


    //给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 -1 。
    //
    //子数组 是数组中 连续 的一部分。
    //
    //输入：nums = [1], k = 1
    //输出：1

    // 因为 nums 中存在负数，破坏了 滑动窗口的单调性，所以不能用滑动窗口来解决


    //输入：nums = [2,-1,2], k = 3
    //输出：3

    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        System.out.println(Arrays.toString(preSum));

        long res = n + 1;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i <= n; i++) {
            while (deque.size() > 0 && preSum[i] - preSum[deque.peekFirst()] >= k) {
                res = Math.min(res , i - deque.pollFirst());
            }
            while (deque.size() > 0 && preSum[i] <= preSum[deque.peekLast()]) deque.pollLast();

            deque.addLast(i);
        }

        return res == n + 1 ? - 1: (int) res;
    }



}
