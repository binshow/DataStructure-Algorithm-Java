package DataStructure.stack.monotone_stack;

import java.util.Stack;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/2/289:47 PM
 */
public class _84_largestRectangleArea {

    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){

                int bottom = stack.pop();
                if (stack.isEmpty()){
                    break;
                }
                int l = stack.peek();
                System.out.println( "i=" + i + "l=" +  l  + "h =" + heights[bottom]);
                res = Math.max(res , (i - l - 1) * heights[bottom]);
            }
            stack.push(i);
        }


        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,5,6,3};

        System.out.println(largestRectangleArea(nums));
    }
}
