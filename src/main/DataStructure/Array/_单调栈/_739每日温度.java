package DataStructure.Array._单调栈;

import java.util.Stack;

public class _739每日温度 {

    //https://leetcode.cn/problems/daily-temperatures/
    public int[] dailyTemperatures(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < n ; i++){
            while(stack.size() > 0 && nums[stack.peek()] < nums[i]){
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }

        return res;
    }
}
