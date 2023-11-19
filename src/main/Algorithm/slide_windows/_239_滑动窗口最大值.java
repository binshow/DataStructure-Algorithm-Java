package Algorithm.slide_windows;


// https://leetcode.cn/problems/sliding-window-maximum/description/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class _239_滑动窗口最大值 {

    //给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
    //
    //返回 滑动窗口中的最大值 。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
    //输出：[3,3,5,5,6,7]
    //解释：
    //滑动窗口的位置                最大值
    //---------------               -----
    //[1  3  -1] -3  5  3  6  7       3
    // 1 [3  -1  -3] 5  3  6  7       3
    // 1  3 [-1  -3  5] 3  6  7       5
    // 1  3  -1 [-3  5  3] 6  7       5
    // 1  3  -1  -3 [5  3  6] 7       6
    // 1  3  -1  -3  5 [3  6  7]      7
    //示例 2：
    //
    //输入：nums = [1], k = 1
    //输出：[1]


    /*
    *  思路： 固定大小的滑动窗口，重点是如何保存窗口内的最大值？
    *   1. 可以用 堆
    *   2. 可以用 单调队列
    * */

    @Test
    void test(){
        Assertions.assertEquals(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)), "[3, 3, 5, 5, 6, 7]");
        Assertions.assertEquals(Arrays.toString(maxSlidingWindow(new int[]{1}, 1)), "[1]");
        Assertions.assertEquals(Arrays.toString(maxSlidingWindow(new int[]{1,-1}, 1)), "[1, -1]");
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];

        Queue<int[]> heap = new PriorityQueue<>((a , b) -> b[0] - a[0]);
        for (int i = 0; i < k; i++) {
            heap.add(new int[]{nums[i] , i});
        }

        res[0] = heap.peek()[0];
        int index = 1;

        for (int i = k; i < n; i++) {
            heap.add(new int[]{nums[i] , i}); // 先加入元素
            while (heap.peek()[1] + k - 1 < i ) {
                System.out.println(heap.poll()[0]);
                //heap.poll(); // 弹出不在窗口内的元素
            }

            //for (int[] tmp : heap) System.out.println(Arrays.toString(tmp));
            res[index++] = heap.peek()[0];
        }
        return res;

    }


    // 单调队列的方式


}
