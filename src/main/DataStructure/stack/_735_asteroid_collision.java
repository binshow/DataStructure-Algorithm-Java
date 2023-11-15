package DataStructure.stack;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

// https://leetcode.cn/problems/asteroid-collision/
public class _735_asteroid_collision {

    //给定一个整数数组 asteroids，表示在同一行的小行星。
    //对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
    //找出碰撞后剩下的所有小行星。碰撞规则：两个小行星相互碰撞，较小的小行星会爆炸。如果两颗小行星大小相同，则两颗小行星都会爆炸。两颗移动方向相同的小行星，永远不会发生碰撞。
    //
    //
    //
    //示例 1：
    //
    //输入：asteroids = [5,10,-5]
    //输出：[5,10]
    //解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
    //示例 2：
    //
    //输入：asteroids = [8,-8]
    //输出：[]
    //解释：8 和 -8 碰撞后，两者都发生爆炸。
    //示例 3：
    //
    //输入：asteroids = [10,2,-5]
    //输出：[10]
    //解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。

    @Test
    void test(){
        Assertions.assertEquals(Arrays.toString(asteroidCollision(new int[]{5, 10, -5})), "[5, 10]" );
        Assertions.assertEquals(Arrays.toString(asteroidCollision(new int[]{8,-8})), "[]" );
        Assertions.assertEquals(Arrays.toString(asteroidCollision(new int[]{10,2,-5})), "[10]" );
        Assertions.assertEquals(Arrays.toString(asteroidCollision(new int[]{-2,-2,1,-2})), "[-2, -2, -2]" );
        Assertions.assertEquals(Arrays.toString(asteroidCollision(new int[]{-2,-1,1,-2})), "[-2, -1, -2]" );
        Assertions.assertEquals(Arrays.toString(asteroidCollision(new int[]{-2,2,1,-2})), "[-2]" );
        Assertions.assertEquals(Arrays.toString(asteroidCollision(new int[]{5,-1,3,-6,1,23,-6,12,-11,23,-4,1,10,-5})),
                "[-6, 1, 23, 12, 23, 1, 10]" );
    }


    //-2,2,1,-2

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            // stack empty  or 两个数同向 or 前面一个数<0 , 后面一个数>0
            if (stack.empty() || stack.peek() * asteroids[i] > 0 || (stack.peek() < 0 && asteroids[i] > 0) ) stack.push(asteroids[i]);
            else {

                // 前面一个数 > 0  当前数 < 0

                if (stack.peek() > -asteroids[i]){
                    continue;
                }

                if (stack.peek() == -asteroids[i]){
                    stack.pop();
                    continue;
                }

                // 一路弹出绝对值小的数
                // //-2,2,1,-2
                while (!stack.empty() && stack.peek() > 0 &&  stack.peek() < -asteroids[i]) stack.pop();

                if (!stack.empty() && stack.peek() == -asteroids[i]){
                    stack.pop();
                    continue;
                }

                if (stack.empty() || stack.peek() < 0 ) stack.push(asteroids[i]);

            }
        }

        int[] res = new int[stack.size()];
        for (int i = res.length-1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }

}
