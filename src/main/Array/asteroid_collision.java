package Array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author shengbinbin
 * @description:  https://leetcode.cn/problems/asteroid-collision/
 * @date 2022/7/139:59 AM
 */
public class asteroid_collision {

    //Input: asteroids = [10,2,-5]
    //Output: [10]
    //Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
    //

    // 利用栈来模拟行星碰撞
    public static int[] asteroidCollision(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        Stack<Integer> stack = new Stack<>();
        for(int num : nums){
            boolean flag = false; // flag 来标记当前 num 是否被抵消了
            if (num < 0){
                while (stack.size() > 0){
                    int tem = stack.pop();
                    if (tem < 0){
                        stack.push(tem); // 如果前面一个数也是小于0的，就将num放入栈中，这两个不会碰撞
                        break;
                    }
                    if (Math.abs(tem) == Math.abs(num)){    // num 和 tem 都没了
                        flag = true;
                        break;
                    }else if (Math.abs(tem) > Math.abs(num)){   // num 没了
                        stack.push(tem);
                        flag = true;
                        break;
                    }
                }
                if (!flag) stack.push(num); // num 没有被抵消，即使是负数也可以放入栈中
            }else stack.push(num);      // num 是正数就直接加入
        }

        int[] res = new int[stack.size()];
        for (int i = res.length-1; i >= 0; i--) res[i] = stack.pop();
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2 , -1 , 1 , 2};
        System.out.println(Arrays.toString(asteroidCollision(nums)));
    }
}
