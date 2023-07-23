package monotone_array;

// https://leetcode.cn/problems/max-value-of-equation/


//给你一个数组 points 和一个整数 k 。数组中每个元素都表示二维平面上的点的坐标，并按照横坐标 x 的值从小到大排序。也就是说 points[i] = [xi, yi] ，并且在 1 <= i < j <= points.length 的前提下， xi < xj 总成立。
//
//请你找出 yi + yj + |xi - xj| 的 最大值，其中 |xi - xj| <= k 且 1 <= i < j <= points.length。
//
//题目测试数据保证至少存在一对能够满足 |xi - xj| <= k 的点。
//


//输入：points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
//输出：4
//解释：前两个点满足 |xi - xj| <= 1 ，代入方程计算，则得到值 3 + 0 + |1 - 2| = 4 。第三个和第四个点也满足条件，得到值 10 + -10 + |5 - 6| = 1 。
//没有其他满足条件的点，所以返回 4 和 1 中最大的那个。

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class _1499满足不等式的最大值 {


    // 公式优化： yi + yj + | Xi - Xj | =  Yi + Yj + Xj - Xi = (Xj + Yj)  + (Yi - Xi)
    // 也就是 遍历 j 找到
    // 同时需要满足 Xj - Xi <= k

    public int findMaxValueOfEquation(int[][] points, int k) {
        int res = Integer.MIN_VALUE;
        Deque<int[]> queue = new LinkedList<int[]>();
        for (int[] point : points){
            int x = point[0] , y = point[1];
            while (queue.size() > 0 && queue.peekFirst()[0] + k < x ) queue.pollFirst(); // 队首超出范围
            if (queue.size() > 0) res = Math.max(res , x + y + queue.peekFirst()[1]);   // 加上最大的 yi-xi
            while (queue.size() > 0 && queue.peekLast()[1] <= y - x) queue.pollLast();
            queue.addLast(new int[]{x , y - x});
        }
        return res;
    }


}
