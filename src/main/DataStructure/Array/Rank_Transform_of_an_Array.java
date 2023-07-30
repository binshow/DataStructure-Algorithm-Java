package DataStructure.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/rank-transform-of-an-array/
 * @date 2022/7/289:32 AM
 */
public class Rank_Transform_of_an_Array {

    //Input: arr = [37,12,28,9,100,56,80,5,12]
    //Output: [5,3,4,2,8,6,7,1,3]

    // 数组序号转换
    public static int[] arrayRankTransform(int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        int[] clone = arr.clone();
        Arrays.sort(clone);
        //System.out.println(Arrays.toString(clone));
        Map<Integer , Integer> map = new HashMap<>();
        int index = 1;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(clone[i])) continue;
            else map.put(clone[i] , index++);
        }
        //System.out.println(map); // {80=8, 100=9, 5=1, 37=6, 56=7, 9=2, 12=3, 28=5}
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = map.get(arr[i]);
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {37,12,28,9,100,56,80,5,12};
        arrayRankTransform(arr);
    }
}
