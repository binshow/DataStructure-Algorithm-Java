package design;

import java.util.Arrays;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/6/1510:13 AM
 */
//["MyCircularQueue","enQueue","Rear","Front","deQueue","Front","deQueue","Front","enQueue","enQueue","enQueue","enQueue"]
//[[3],[2],[],[],[],[],[],[],[4],[2],[2],[3]]
public class MyCircularQueue {

    int[] nums;
    int size = 0;
    int start = 0;
    int end = 0;
    public MyCircularQueue(int k) {
        this.nums = new int[k];
        Arrays.fill(nums , -1);
    }

    // 插入元素
    public boolean enQueue(int value) {
        if (nums[end] != -1) return false;
        nums[end] = value;
        end++;
        if (end == nums.length) end = 0;
        size++;
        return true;
    }

    // 删除元素
    public boolean deQueue() {
        if (nums[start] == -1) return false;
        nums[start] = -1;
        start++;
        if (start == nums.length) start = 0;
        size--;
        return true;
    }

    public int Front() {
        return nums[start];
    }

    public int Rear() {
        if (end == 0) return nums[nums.length-1];
        return nums[end-1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == nums.length;
    }
}
