package DataStructure.Array._子数组问题;

import java.util.HashMap;
import java.util.Map;

public class _525连续子数组 {

    public static void main(String[] args) {
        System.out.println("");
    }


    // 思路：将 0 换成 -1
    // 问题转换成 和为0最长子数组的长度
    // 可以用前缀和解决
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        for(int i = 0 ; i < n ; i++) nums[i] = nums[i] == 0 ? -1 : nums[i];

        // key 存前缀和 ，value 存位置
        Map<Integer, Integer> map = new HashMap<>();
        ////把0看做-1，那么在计算前缀和的时候如果有两个相邻的前缀和值相同，则说明这段连续数组的满足0,1个数相同的；
        //需要用哈希表来存储前缀和，直接判断之前出没出现过
        map.put(0 , -1); //
        int sum = 0;
        int res = 0;
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
            if(map.containsKey(sum)){
                //System.out.println("sum:" + sum + ", l: " + map.get(sum) + " , r: " + i);
                res = Math.max(res , i - map.get(sum));
            } else map.put(sum , i); // 这里不能覆盖，要保留 sum 的第一个来维护最长子数组，如果是最短
        }
        return res;
    }
}
