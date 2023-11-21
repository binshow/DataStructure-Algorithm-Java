package Algorithm.slide_windows;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

// https://leetcode.cn/problems/grumpy-bookstore-owner/
public class _1052_爱生气的书店老板 {

    // 有一个书店老板，他的书店开了 n 分钟。每分钟都有一些顾客进入这家商店。
    // 给定一个长度为 n 的整数数组 customers ，其中 customers[i] 是在第 i 分钟开始时进入商店的顾客数量，所有这些顾客在第 i 分钟结束后离开。
    //
    //在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
    //
    //当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。
    //
    //书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 minutes 分钟不生气，但却只能使用一次。
    //
    //请你返回 这一天营业下来，最多有多少客户能够感到满意 。
    //
    //
    //示例 1：
    //
    //输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
    //输出：16
    //解释：书店老板在最后 3 分钟保持冷静。
    //感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
    //示例 2：
    //
    //输入：customers = [1], grumpy = [0], minutes = 1
    //输出：1


    @Test
    void test(){
        Assertions.assertEquals(maxSatisfied (new int[]{1,0,1,2,1,1,7,5} , new int[]{0,1,0,1,0,1,0,1} , 3), 16);
        Assertions.assertEquals(maxSatisfied (new int[]{2,6,6,9} , new int[]{0,0,1,1} , 1), 17);
    }

    // 只会将情绪将「生气」变为「不生气」，不生气仍然是不生气
    // 也就是说 将 grumpy[i] 已经为 0 再变成0的收益就是 0
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int res = 0;

        for(int i = 0 ; i < n ; i++){
            if(grumpy[i] == 0) {
                res += customers[i];
                customers[i] = 0;   // 已经是0了，再变成0 没什么意义了
            }
        }

        //System.out.println("转换换之后为:" + Arrays.toString(customers));

        // 计算长度为 minutes 的最长子数组和
        int cur = 0 , max = 0;
        for(int i = 0 ; i < n ; i++){
            cur += customers[i];
            if(i >= minutes) cur -= customers[i - minutes];
            max = Math.max(max , cur);
        }
        return res + max;

    }



}
