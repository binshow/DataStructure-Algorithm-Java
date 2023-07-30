package DataStructure.Array._子数组问题;

public class _152乘积最大子数组 {

    // https://leetcode.cn/problems/maximum-product-subarray/

    public static void main(String[] args) {
        System.out.println();
    }

    public int maxProduct(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int max = 1 , min = 1;
        int res = Integer.MIN_VALUE;
        for(int num : nums){
            if(num < 0) {
                int tem = max;
                max = min;
                min = tem;
            }

            max = Math.max(num , max * num);
            min = Math.min(num , min * num);
            res = Math.max(res , max);
        }
        return res;
    }
}
