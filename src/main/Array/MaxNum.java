package Array;

import java.util.*;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/3/263:04 PM
 */
public class MaxNum {

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));
    }

    // 12  345
   void quickSort(int[] nums , int l , int r){
        if(l >= r) return;
        int pivot = nums[l];
        int index = l;
       for (int i = l + 1; i < r; i++) {

       }
    }

    // 1 4 3 3 2 1 0
    public static String removeKdigits(String num, int k) {
        if(num.length() == k)       return "0";

        StringBuilder stack = new StringBuilder();
        int remains = num.length() - k;

        for(int i = 0; i < num.length(); i++){
            char ch = num.charAt(i);
            while(k > 0 && stack.length() != 0 && stack.charAt(stack.length() - 1) > ch){
                stack.deleteCharAt(stack.length()-1);
                k--;
            }
            if(ch == '0' && stack.length() == 0)    continue;

            stack.append(ch);
        }
        String res = stack.substring(0, stack.length() - k).toString();
        return res.length() == 0 ? "0" : res;
    }
}
