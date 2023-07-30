package DataStructure.Array;

import java.util.*;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/k-diff-pairs-in-an-array/
 * @date 2022/6/169:25 AM
 */
public class K_diff_Pairs_in_an_Array {

    //Input: nums = [3,1,4,1,5], k = 2
    //Output: 2
    //Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
    //Although we have two 1s in the input, we should only return the number of unique pairs.
    public int findPairs(int[] nums, int k) {
        //1. map 记录 数组中每个数出现的次数
        Map<Integer , Integer> map= new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }

        int res = 0;
        for(int i : map.keySet()){
            if(k == 0) {
                if (map.get(i) > 1) res++; // i 数组中必须超过1个
            }
            else if (map.containsKey(i + k)) res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,4,1,5};
        int k = 2;
//        System.out.println(findPairs(nums, k));
    }
}
