package Algorithm.binarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class _315CountOfSmallerNumAfterSelf {


    // Given an integer array nums,
    // return an integer array counts where counts[i] is the number of smaller elements to the right of nums[i].
    //
    //Example 1:
    //
    //Input: nums = [5,2,6,1]
    //Output: [2,1,1,0]
    //Explanation:
    //To the right of 5 there are 2 smaller elements (2 and 1).
    //To the right of 2 there is only 1 smaller element (1).
    //To the right of 6 there is 1 smaller element (1).
    //To the right of 1 there is 0 smaller element.
    //Example 2:
    //
    //Input: nums = [-1]
    //Output: [0]
    //Example 3:
    //
    //Input: nums = [-1,-1]
    //Output: [0,0]


    @Test
    void test(){
        Assertions.assertEquals(countSmaller(new int[]{5,2,6,1}) , Arrays.asList(2,1,1,0));
        Assertions.assertEquals(countSmaller(new int[]{-1}) , Arrays.asList(0));
        Assertions.assertEquals(countSmaller(new int[]{-1,-1}) , Arrays.asList(0,0));
    }


    // 将原数组逆序插入形成新数组，每次二分查找的位置 就是 比他小的个数
    // 1 6

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new LinkedList<>();

        List<Integer> list = new LinkedList<>();
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            int index = find(nums[i] , list);
           // list.add(nums[i]);
          //  System.out.println("cur list = " + list + "nums[i] " + nums[i] + " 存放的位置是 " + index);
           // list.add(nums[i]);
            list.add(index , nums[i]);
            res.add(index);
        }
       // System.out.println(list);
        Collections.reverse(res);
        return res;
    }

    // 寻找插入位置
    private int find(int num, List<Integer> list) {
        int n = list.size();
        if (n == 0) return 0;
        if (list.get(n-1) < num) return n;

        int l = 0 , r = list.size()-1;
        while (l < r){
            int mid = l + r >> 1;
            if (list.get(mid) < num) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
