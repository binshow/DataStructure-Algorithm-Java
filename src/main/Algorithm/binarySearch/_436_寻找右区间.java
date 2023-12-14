package Algorithm.binarySearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/find-right-interval/
public class _436_寻找右区间 {

    public int[] findRightInterval(int[][] intervals) {
        int m = intervals.length;

        //1. map 记录 start 在 数组中的位置
        Map<Integer , Integer> map = new HashMap<>();
        for(int i = 0 ; i < m ; i++) map.put(intervals[i][0] , i);

        //System.out.println( "map : " + map);

        //2. 根据start排序, 收集成一个有序数组
        int[] nums = new int[m];
        for(int i = 0 ; i < m ; i++) nums[i] = intervals[i][0];
        Arrays.sort(nums);

        //System.out.println( "nums " + Arrays.toString(nums));

        //3. 依次遍历，找到每个区间的 end 的 下一个较大数（二分），即为起点
        int[] res = new int[m];
        for(int i = 0 ; i < m ; i++){
            int index = find(intervals[i][1] , nums);
            //System.out.println("比 " + intervals[i][1] + " 大的数 " + index);
            if(index == Integer.MAX_VALUE) res[i] = -1;
            else res[i] = map.getOrDefault(index, -1);
        }
        return res;
    }

    // 二分查找第一个 比 target 大于等于的数
    int find(int target , int[] nums){
        int n = nums.length;
        if(nums[n-1] < target) return Integer.MAX_VALUE; // 没有比他大的数
        int l = 0 , r = nums.length;
        while(l < r){
            int mid = l + r >> 1;
            if(nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return nums[l];
    }
}
