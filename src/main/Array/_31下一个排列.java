package Array;


import java.util.Arrays;

// https://leetcode.cn/problems/next-permutation/
public class _31下一个排列 {

    //输入：nums = [1,2,3]
    //输出：[1,3,2]

    public static void nextPermutation(int[] nums) {

        if (nums.length == 0) return;
        int n = nums.length;
        for (int i = n-2; i >= 0; i--) {
            for (int j = n-1; j > i; j--) {
                if (nums[i] < nums[j]){
                    int tem = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tem;
                    Arrays.sort(nums ,  i + 1 , nums.length);
                    System.out.println(Arrays.toString(nums));
                    return;
                }
            }
        }

        Arrays.sort(nums);
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,4,2,1};
        nextPermutation(nums);
    }
}
