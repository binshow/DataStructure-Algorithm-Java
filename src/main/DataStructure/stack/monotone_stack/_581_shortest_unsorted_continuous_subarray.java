package DataStructure.stack.monotone_stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class _581_shortest_unsorted_continuous_subarray {


    //https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/description/


    //给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
    //
    //请你找出符合题意的 最短 子数组，并输出它的长度。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [2,6,4,8,10,9,15]
    //输出：5
    //解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
    //示例 2：
    //
    //输入：nums = [1,2,3,4]
    //输出：0
    //示例 3：
    //
    //输入：nums = [1]
    //输出：0


    /*
    *  思路： 将 数组 分为三个部分： 左边递增， 中间无序， 右边递增
    *  因此：
    *       1. 从左往右遍历，第一个破坏递增性质的为起点
    *       2. 从右往左遍历，第一个破坏递减性质的为终点
    *
    * */

    @Test
    void test(){
        Assertions.assertEquals(findUnsortedSubarray(new int[]{2,6,4,8,10,9,15}) , 5);
        Assertions.assertEquals(findUnsortedSubarray(new int[]{1,2,3,4}) , 0);
    }


    public int findUnsortedSubarray(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int l = nums.length;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[stack.peek()] > nums[i]){
                l = Math.min(l , stack.pop());
            }
            stack.push(i);
        }

        stack.clear();
        int r = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            while (!stack.empty() && nums[stack.peek()] < nums[i]){
                r = Math.max(r , stack.pop());
            }
            stack.push(i);
        }
        return r > l ?  r - l + 1 : 0;
    }

}
