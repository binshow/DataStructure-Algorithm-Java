package DataStructure.Hash._枚举两个变量的思路;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.cn/problems/max-sum-of-a-pair-with-equal-sum-of-digits/?envType=daily-question&envId=2023-11-18
public class _2342_maximum_sum {


    //给你一个下标从 0 开始的数组 nums ，数组中的元素都是 正 整数。请你选出两个下标 i 和 j（i != j），且 nums[i] 的数位和 与  nums[j] 的数位和相等。
    //
    //请你找出所有满足条件的下标 i 和 j ，找出并返回 nums[i] + nums[j] 可以得到的 最大值 。
    //
    //
    //
    //示例 1：
    //
    //输入：nums = [18,43,36,13,7]
    //输出：54
    //解释：满足条件的数对 (i, j) 为：
    //- (0, 2) ，两个数字的数位和都是 9 ，相加得到 18 + 36 = 54 。
    //- (1, 4) ，两个数字的数位和都是 7 ，相加得到 43 + 7 = 50 。
    //所以可以获得的最大和是 54 。
    //示例 2：
    //
    //输入：nums = [10,12,19,14]
    //输出：-1
    //解释：不存在满足条件的数对，返回 -1 。


    @Test
    void test(){
        Assertions.assertEquals(maximumSum(new int[]{18,43,36,13,7}) , 54);
        Assertions.assertEquals(maximumSum(new int[]{10,12,19,14}) , -1);
    }


    public int maximumSum(int[] nums) {
        int res = -1;
        // key 为数位和 ，value 为最大的数
        Map<Integer , Integer> map = new HashMap<>();
        for(int num : nums){
            int bitSum = help(num);
            if (map.containsKey(bitSum)) res = Math.max(res , num + map.get(bitSum));
            map.put(bitSum , Math.max(map.getOrDefault(bitSum , 0) , num));
        }
        return res;
    }

    private int help(int num) {
        int res = 0;
        while (num > 0){
            res += (num % 10);
            num = num / 10;
        }
        return res;
    }
}
