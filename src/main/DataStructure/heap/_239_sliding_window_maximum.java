package DataStructure.heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class _239_sliding_window_maximum {


    //https://leetcode.cn/problems/sliding-window-maximum/description/

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

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        Queue<Integer> heap = new PriorityQueue<>((a , b) -> b - a);
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }

        int index = 0;
        res[index++] = heap.peek();
        for (int i = k  ; i < n ; i++) {
            // 先删除元素，再添加元素，这里直接调用 remove 代码会超时！！！
            heap.remove(nums[i-k]);
            heap.add(nums[i]);
            res[index++] = heap.peek();
        }
        //System.out.println(Arrays.toString(res));
        return res;
    }


    // 优化一下，堆中保存元素 和 下标
    public int[] maxSlidingWindowV2(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        Queue<int[]> heap = new PriorityQueue<>((a , b) -> b[0] - a[0]);
        for (int i = 0; i < k; i++) {
            heap.add(new int[]{nums[i] , i});
        }

        int index = 0;
        res[index++] = heap.peek()[0];
        for (int i = k  ; i < n ; i++) {

            heap.add(new int[]{nums[i] , i});
            //判断当前堆顶元素是否在当前的滑动窗口中
            while (heap.peek()[1] < i - k + 1) heap.poll();
            res[index++] = heap.peek()[0];
        }
        //System.out.println(Arrays.toString(res));
        return res;
    }

}
