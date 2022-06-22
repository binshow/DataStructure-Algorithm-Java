package design;

import java.util.Random;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/generate-random-point-in-a-circle/
 * @date 2022/6/510:51 PM
 */
// 在圆内随机产生点
public class Generate_Random_Point_in_Circle {

    // 圆内等概率随机采样
    class Solution {
        Random random = new Random();
        double x , y , r;
        public Solution(double radius, double x_center, double y_center) {
            this.r = radius;
            this.x = x_center;
            this.y = y_center;
        }

        // 随机的两个要素：
        // 1. 在 [0 , r] 之间随机一个 半径
        // 2. 随机一个 夹角 [0 , 2π] 之间
        // 然后根据 len 和 ang 直接计算对应的点的坐标，这样 可以确保随机出来的点一定在圆内，但并非「等概率」
        // 在不考虑夹角的情况下，我们本质是在 [0, r] 范围内随机，这在「一维」上「等概率」是成立的，因为满足「任意连续段中点被抽到的次数与总次数的比例」与「该连续段长度与总长度的比例」
        //但在圆中并非如此，不考虑夹角时，「任意连续段 len 与总长度 r 的比例」和「len 对应面积与总面积比例」并不相等。
        // 例如 len 有 1/2 的概率取到 <= r/2 的值 ， 而半径为 2/r 扫过的面积只占整个圆面积的 1/4
        // 因此我们的 len 不能直接在 [0, r] 范围内随机，为了消除这种一维转圆导致的「等概率」失效，我们可以从 [0, r^2] 内随机再开平方，从而确保距离与面积比例一致

        //https://leetcode.cn/problems/generate-random-point-in-a-circle/solution/zai-yuan-nei-by-jiang-hui-4-udsm/
        public double[] randPoint() {
            while (true) {
                // 随机生成 x 和 y , 需要注意这里！！！
                double xr = random.nextDouble() * 2 * r - r;
                double xy = random.nextDouble() * 2 * r - r;
                // 判断是否在圆内
                if (Math.sqrt( xr * xr + xy * xy) <= r){
                    return new double[]{xr + x , xy + y}; // 注意需要平移到 圆心所在的点相对的位置
                }
            }



        }
    }


}
