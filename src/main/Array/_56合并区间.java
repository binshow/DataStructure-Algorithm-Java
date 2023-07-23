package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.cn/problems/merge-intervals/
public class _56合并区间 {

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        if (intervals.length == 0) return new int[0][0];
        //1. 用第一个数组排序
        Arrays.sort(intervals , (a , b) -> a[0] - b[0]);

        for (int[] nums : intervals) System.out.println(Arrays.toString(nums));

        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (cur[1] < intervals[i][0]) {
                list.add(cur);
                cur = intervals[i];
            } else if (cur[1] >= intervals[i][0] && cur[1] < intervals[i][1]){
                cur[1] = intervals[i][1];
            }
        }
        list.add(cur);

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }



}
