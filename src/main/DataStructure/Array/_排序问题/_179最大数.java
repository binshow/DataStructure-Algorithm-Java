package DataStructure.Array._排序问题;

import java.util.Arrays;

// https://leetcode.cn/problems/largest-number/description/
public class _179最大数 {

    //给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
    //
    //注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。

    //输入：nums = [3,30,34,5,9]
    //输出："9534330"


    public String largestNumber(int[] nums) {
        // 1 将int数组转出string数组

        String[] tmp = new String[nums.length];
        for(int i = 0 ; i < tmp.length ; i++) tmp[i] = nums[i] + "";

        // 2. String 数组排序
        Arrays.sort(tmp , (a , b) -> (b + a).compareTo(a + b));


        StringBuilder sb = new StringBuilder();
        for(String t : tmp) sb.append(t);

        // 3. 去除前导0的情况
        if(sb.charAt(0) == '0') return "0";
        else return sb.toString();
    }


}
