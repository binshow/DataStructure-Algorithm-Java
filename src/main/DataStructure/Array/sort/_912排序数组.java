package DataStructure.Array.sort;

import java.util.Arrays;

// https://leetcode.cn/problems/sort-an-array/
public class _912排序数组 {

    public static void main(String[] args) {
        int[] nums = {1,5,2,4,3,7,9,8 ,8, 4,3};
        partition(nums , 0 ,  nums.length-1);

        quickSort(nums , 0 , nums.length-1);
        System.out.println(Arrays.toString(nums));

    }


    public static int[] sortArray(int[] nums) {
        quickSort(nums , 0 , nums.length-1);
        return nums;
    }

    private static void quickSort(int[] nums , int l , int r) {
        if (l >= r ) return;
        int[] tem = partition(nums , l , r);
        quickSort(nums , l , tem[0] - 1);
        quickSort(nums , tem[1] + 1 , r);
    }

    // partition 返回左边界 和 右边界
    private static int[] partition(int[] nums , int l , int r) {
        int less = l - 1;
        int more = r;

        int cur = l;
        while(cur < more){
            if(nums[cur] < nums[r]) swap(nums , ++less , cur++);
            else if(nums[cur] > nums[r]) swap(nums , --more , cur);
            else cur++;
        }

        swap(nums , r,  more);
       // System.out.println("less :" + less + ", more: " + more);
       // System.out.println(Arrays.toString(nums));
        return new int[]{less+1 , more};
    }

    private static void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}
