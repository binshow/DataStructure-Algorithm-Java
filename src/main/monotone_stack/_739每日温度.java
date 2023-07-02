package monotone_stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/daily-temperatures/
 * @date 2023/6/269:52 AM
 */
public class _739每日温度 {

    public static void main(String[] args) {
        int[] res = dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(res));
    }


    //  找下一个更大的元素
    //  [73,74,75,71,69,72,76,73]
    //  [1,1,4,2,1,1,0,0]
    public static int[] dailyTemperatures(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                //弹出栈顶元素，栈顶元素的 下一个 更大的元素就是 nums[i]
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }

}
