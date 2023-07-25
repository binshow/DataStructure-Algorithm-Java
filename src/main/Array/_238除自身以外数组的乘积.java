package Array;

import java.util.Arrays;

// https://leetcode.cn/problems/product-of-array-except-self/
public class _238除自身以外数组的乘积 {

    //输入: nums = [1,2,3,4]
    //输出: [24,12,8,6]
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        int l = 1 , r = 1;
        for(int i = 0 ; i < n ; i++){
            res[i] = l;
            l *= nums[i];
        }

        System.out.println(Arrays.toString(res));

        // 1 1 2 6

        for(int i = n-1 ; i >= 0 ; i--){
            res[i] *= r;
            r *= nums[i];
        }

        return res;
    }

}
