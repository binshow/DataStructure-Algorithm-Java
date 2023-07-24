package Array.sort;


import java.util.PriorityQueue;
import java.util.Queue;

// https://leetcode.cn/problems/kth-largest-element-in-an-array/
public class _215第K个最大的元素 {


    //1. 堆排序
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> heap = new PriorityQueue<>();
        for (int num : nums){
            heap.add(num);
            if (heap.size() > k) heap.poll();
        }
        if (heap.size() > 0) return heap.poll();
        return -1;
    }


    //2. 快排
    public int findKthLargestV2(int[] nums, int k) {
        quickSort(nums , 0 , nums.length-1);
        return nums[nums.length - k];
    }

    void quickSort(int[] nums , int l , int r){
        if (l > r) return;
        int[] p = partition(nums , l , r);
        quickSort(nums , l , p[0] - 1);
        quickSort(nums , p[1] + 1 , r);
    }

    private int[] partition(int[] nums, int l, int r) {
        int base = nums[r];
        int less = l - 1 , more = r;
        int cur = l;
        while (cur < more){
            if (nums[cur] < base) swap(nums , ++less , cur++);
            else if (nums[cur] > base) swap(nums , --more , cur);
            else cur++;
        }
        swap(nums , r , more);
        return new int[]{less+1 , more};
    }

    private void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }


}
