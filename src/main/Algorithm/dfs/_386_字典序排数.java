package Algorithm.dfs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _386_字典序排数 {


    //https://leetcode.cn/problems/lexicographical-numbers/description/

    //给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
    //
    //你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
    //
    //
    //
    //示例 1：
    //
    //输入：n = 13
    //输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
    //示例 2：
    //
    //输入：n = 2
    //输出：[1,2]

    @Test
    void test(){
        Assertions.assertEquals(lexicalOrder(13).toString() , "[1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]");
        Assertions.assertEquals(lexicalOrder(2).toString() , "[1, 2]");
    }



    /*
    *  思路： 字典序排数 可以看做一棵树 , 从第二层开始递归遍历
    *                       0
    *         1        2       3     ... 9
    *      10 11..   20 21..  30 31..
    *
    * */

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(res , i , n);
        }
        return res;
    }

    private void dfs(List<Integer> res, int index, int limit) {
        // 超过限制, 截止
        if (index > limit) return;

        // 加入结果集
        res.add(index);

        // 开始递归
        for (int i = 0; i < 10; i++) {
            dfs(res , index * 10 + i , limit);
        }
    }

}
