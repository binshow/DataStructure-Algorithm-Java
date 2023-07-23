package monotone_array;


// https://leetcode.cn/problems/sliding-window-maximum/comments/

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class _239滑动窗口最大值 {


    // 自定义实现双端队列
    class MyQueue {
        Deque<Integer> deque = new LinkedList<>();

        //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
        //保证队列元素单调递减
        //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
        void add(int val){
           while (deque.size() > 0 && deque.peekLast() < val) deque.pollLast();
           deque.addLast(val);
        }

        //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
        //同时判断队列当前是否为空
        void poll(int val){
            if (deque.size() > 0 && val == deque.peekFirst()) deque.pollFirst();
        }

        int max(){
            if (deque.size() > 0) return deque.peekFirst();
            return -1;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return nums;

        int[] res = new int[n - k + 1];
        int index = 0;

        MyQueue queue = new MyQueue();
        //1. 先塞前面k个数
        for (int i = 0; i < k; i++) queue.add(nums[i]);

        res[index++] = queue.max();

        //2. 开始遍历，poll、push、记录max
        for (int i = k; i < n; i++) {
            queue.poll(nums[i-k]); //滑动窗口移除最前面的元素，移除是判断该元素是否放入队列
            queue.add(nums[i]);
            res[index++] = queue.max();
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        //System.out.println(Arrays.toString(maxSlidingWindowV2(nums, 3)));
        System.out.println(Arrays.toString(minSlidingWindow(nums, 3)));

    }


    // 用一个单调队列来存储下标
    public static int[] maxSlidingWindowV2(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return nums;

        int[] res = new int[n - k + 1];
        int idx = 0;

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            while (deque.size() > 0 && i - deque.peekFirst() + 1 > k) deque.pollFirst(); // 队列长度超过k了，弹出队首
            while (deque.size() > 0 && deque.peekLast() < nums[i]) deque.pollLast(); // 队列中小于当前值的也全部弹出
            deque.addLast(i); // 入队

            //System.out.println(deque.toString());

            // 开始取数
            if (i - k + 1  >= 0) res[idx++] = nums[deque.peekFirst()];
        }
        return res;

    }



    // 滑动窗口最小值
    public static int[] minSlidingWindow(int[] nums , int k){
        int n = nums.length;
        if (n == 1) return nums;
        int[] res = new int[n-k+1];
        int index = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while (deque.size() >  0 && i - deque.peekFirst() + 1 > k) deque.pollFirst();
            while (deque.size() > 0 && deque.peekLast() > nums[i]) deque.pollLast();
            deque.addLast(i);
            if (i - k + 1 >= 0) res[index++] = nums[deque.peekFirst()];
        }
        return res;
    }
}
