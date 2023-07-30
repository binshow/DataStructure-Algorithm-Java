package DataStructure.Array;

import java.util.Arrays;

// https://leetcode.cn/problems/candy/
public class _135分发糖果 {

    public static void main(String[] args) {
        int[] nums = {1,0,3,1,2};
        candy(nums);
    }

    public static int candy(int[] nums) {
        int n = nums.length;
        //1. 先给每个人都发一个
        int[] ans = new int[n];
        Arrays.fill(ans , 1);

        //2. 从左到右遍历，如果左边的比右边的高，则左边的就多发一个
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i-1]) ans[i] = ans[i-1] + 1;
        }

        System.out.println(Arrays.toString(ans));

        //3. 从右往左遍历，如果左边的比右边的高，则右边的就多发一个
        // 然后再看满足右边的糖果数，这里满足右边的同时又必须满足左边，因此在当前满足左边和右边的条件上取最大值
        for(int i = n - 1 ; i > 0 ; i--){
           if (nums[i-1] > nums[i]) ans[i-1] = Math.max(ans[i-1] , ans[i] + 1);
        }


        System.out.println(Arrays.toString(ans));

        int res = 0;
        for (int num : ans) res += num;
        return res;
    }

}
