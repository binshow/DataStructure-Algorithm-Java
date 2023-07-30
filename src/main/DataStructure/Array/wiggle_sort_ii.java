package DataStructure.Array;

import java.util.Arrays;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/wiggle-sort-ii/
 * @date 2022/6/2810:11 AM
 */
public class wiggle_sort_ii {

    // 滚动排序 : nums[0] < nums[1] > nums[2] < nums[3]....
    //Input: nums = [1,5,1,1,6,4]
    //Output: [1,6,1,5,1,4]
    //Explanation: [1,4,1,5,1,6] is also accepted.

    // 解法1：排序双指针，时间复杂度 Onlogn ， 空间复杂度 On
    public void wiggleSort(int[] nums) {
        //  [1,5,1,1,6,4]
        //   1 1 1 4 5 6
        int[] copy = nums.clone();
        int n = nums.length;
        Arrays.sort(copy);
        int l = (n - 1) / 2,  r = n - 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) nums[i] = copy[l--];
            else nums[i] = copy[r--];
        }
    }



    // 找数组中第k大的元素
    int qselect(int[] nums , int l, int r, int k) {
        if (l == r) return nums[l];
        int x = nums[l + r >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) swap(nums , i, j);
        }
        int cnt = j - l + 1;
        if (k <= cnt) return qselect(nums , l, j, k);
        else return qselect(nums , j + 1, r, k - cnt);
    }

    void swap(int[] nums , int i , int j){
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }


}
