package Algorithm.slide_windows;


//https://leetcode.cn/problems/fruit-into-baskets/description/

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _904_水果成篮 {

    //你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
    //
    //你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
    //
    //你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
    //你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
    //一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
    //给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
    //
    //
    //
    //示例 1：
    //
    //输入：fruits = [1,2,1]
    //输出：3
    //解释：可以采摘全部 3 棵树。
    //示例 2：
    //
    //输入：fruits = [0,1,2,2]
    //输出：3
    //解释：可以采摘 [1,2,2] 这三棵树。
    //如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
    //示例 3：
    //
    //输入：fruits = [1,2,3,2,2]
    //输出：4
    //解释：可以采摘 [2,3,2,2] 这四棵树。
    //如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
    //示例 4：
    //
    //输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
    //输出：5
    //解释：可以采摘 [1,2,1,1,2] 这五棵树。



    @Test
    void test(){
        Assertions.assertEquals(totalFruit(new int[]{1,2,1}) , 3);
        Assertions.assertEquals(totalFruit(new int[]{0,1,2,2}) , 3);
        Assertions.assertEquals(totalFruit(new int[]{1,2,3,2,2}) , 4);
        Assertions.assertEquals(totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}) , 5);
    }



    /*
    * 思路: 题目可以理解为 只有两个不同数字的 最长子数组
    *       属于 窗口外满足条件
    *
    * */
    public int totalFruit(int[] nums) {
        int n = nums.length;
        Map<Integer , Integer> map = new HashMap<>();
        int res = 0;
        int l = 0 , r = 0;
        while (r < n){
            map.put(nums[r] , map.getOrDefault(nums[r] , 0) + 1);
            while (map.size() > 2){
                map.put(nums[l] , map.getOrDefault(nums[l] , 0) - 1);
                if (map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
            }
            // 满足条件的 l - r
            System.out.println("nums[l] " + nums[l] + " - nums[r]" + nums[r]);
            res = Math.max(res , r - l + 1);
            r++;
        }
        return res;
    }
}
