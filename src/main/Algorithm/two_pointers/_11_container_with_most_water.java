package Algorithm.two_pointers;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.cn/problems/container-with-most-water/
public class _11_container_with_most_water {

    /*
    *   给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
        找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
        返回容器可以储存的最大水量。
        说明：你不能倾斜容器。

示例 1：

输入：[1,8,6,2,5,4,8,3,7]
输出：49
解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
* */

    @Test
    void test(){
        Assertions.assertEquals(maxArea(new int[]{1,8,6,2,5,4,8,3,7}) , 49);
        Assertions.assertEquals(maxArea(new int[]{1,1}) , 1);
    }



    // 思路：
    // 两个点之间存的水容量为 (j - i) * min(nums[j] , nums[i])
    // 双指针 分别从 头尾 和 尾部 向中间汇合，每次移动 nums[i] 和 nums[j] 中其中元素较小的那个
    //

    public int maxArea(int[] height) {
        if (height == null || height.length < 1) return 0;
        int n = height.length;
        int l = 0 , r = n-1;
        int res = 0;
        while (l < r){
            int cur = (r - l) * Math.min(height[l] , height[r]);
            System.out.println("left: " + l + " right: " + r + " height: " + Math.min(height[l] , height[r]) + " area: " + cur);
            res = Math.max(res , cur);
            if (height[l] < height[r]) l++;
            else r--;
        }
        return res;
    }


}
