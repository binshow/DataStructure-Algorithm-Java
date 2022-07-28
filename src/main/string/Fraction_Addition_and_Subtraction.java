package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/fraction-addition-and-subtraction/
 * @date 2022/7/2710:11 AM
 */
public class Fraction_Addition_and_Subtraction {


    //Input: expression = "-1/2+1/2+1/3"
    //Output: "1/3"

    // 分数加减法
    private static String fractionAddition(String expression) {
        List<String> list = new ArrayList<>();
        int j = 0;
        for (int i = 0  ; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-'){
               list.add(expression.substring(j , i));
                j = i;
            }
        }
        list.add(expression.substring(j));
        //System.out.println(list);

        // 收集每个分数的分母
        List<Integer> mu = new ArrayList<>();
        List<Integer> zi = new ArrayList<>();
        for (String s : list){
            int index = s.indexOf("/");
            if (index == -1) continue;
            mu.add(Integer.parseInt(s.substring(index+1)));
            zi.add(Integer.parseInt(s.substring(0,index)));
        }
        //System.out.println(nums);

        // 找到分母的最小公倍数
        int num = getMinCommonMultiple(mu);

        // 遍历每个分子，累加求和
        int res = 0;
        for (int i = 0; i < zi.size(); i++) {
            int tem = zi.get(i) * (num / mu.get(i));
            res += tem;
        }

        int gcd = getGCD(new int[]{res, num});

        // 结果还要约分
        //System.out.println(num / gcd);
        if (num / gcd < 0) return "-" + res / gcd + "" + "/" + Math.abs(num / gcd);
        return res / gcd + "" + "/" + num / gcd;
    }

    // 获取最小公倍数
    private static int getMinCommonMultiple(List<Integer> set){
        int max = Integer.MIN_VALUE;
        for (int num : set) max = Math.max(num , max);
        while (true){
            if (canChu(max , set)) break;
            max++;
        }
        return max;
    }

    private static boolean canChu(int max, List<Integer> nums) {
        for (int num : nums){
            if (max % num != 0) return false;
        }
        return true;
    }

    private static int getGCD(int[] nums){
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
            min = Math.min(min , nums[i]);
        }

        while (min != 0){
            int tmp = max % min;
            max = min;
            min = tmp;
        }
        return max;

    }

    public static void main(String[] args) {
        String s = "-1/2+1/2+1/3";
        System.out.println(fractionAddition(s));

        s =  "1/3-1/2";
        System.out.println(fractionAddition(s));

    }
}
