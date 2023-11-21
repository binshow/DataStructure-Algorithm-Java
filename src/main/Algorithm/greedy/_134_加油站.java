package Algorithm.greedy;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// https://leetcode.cn/problems/gas-station/description/
public class _134_加油站 {


    //在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
    //你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
    //给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
    //
    //示例 1:
    //
    //输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
    //输出: 3
    //解释:
    //从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
    //开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
    //开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
    //开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
    //开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
    //开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
    //因此，3 可为起始索引。
    //示例 2:
    //
    //输入: gas = [2,3,4], cost = [3,4,3]
    //输出: -1
    //解释:
    //你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
    //我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
    //开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
    //开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
    //你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
    //因此，无论怎样，你都不可能绕环路行驶一周。



    @Test
    void test(){
        Assertions.assertEquals(canCompleteCircuit(new int[]{1,2,3,4,5} , new int[]{3,4,5,1,2}) , 3);
    }


    /* 题目：就是每到达一个站点 i，可以加 gas[i] 升油，但离开站点 i 需要消耗 cost[i] 升油，问你从哪个站点出发，可以兜一圈回来
    * 贪心思想： 如果选择站点 i 作为起点「恰好」无法走到站点 j，那么 i 和 j 中间的任意站点 k 都不可能作为起点。
    *           如果我发现从 i 出发无法走到 j，那么 i 以及 i, j 之间的所有站点都不可能作为起点。
    *
    * */

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += (gas[i] - cost[i]);
        }
        if (res < 0) return -1; // 总油量 小于 总消耗量 ， 无解

        int tank = 0; // 记录邮箱中的油量
        int start = 0; // 枚举起点
        for (int i = 0; i < n; i++) {
            tank += (gas[i] - cost[i]);
            System.out.println(" 走到位置: " + i + " 剩余油量: " + tank);
            if (tank < 0){
                // 无法从 start 到达 i + 1
                // 所以站点 i + 1 应该是起点
                tank = 0;
                start = i + 1;
            }
        }

        return start; // 题目说了保证唯一
    }


}
