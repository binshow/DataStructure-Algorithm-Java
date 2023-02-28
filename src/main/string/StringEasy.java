package string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2022/12/611:17 PM
 */
public class StringEasy {


    // 12.06 : https://leetcode.cn/problems/number-of-different-integers-in-a-string/description/
    public int numDifferentIntegers(String word) {
        int n =  word.length();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (word.charAt(i) >= '0' && word.charAt(i) <= '9'){
                int j = i;
                while (j < n && word.charAt(j) >= '0' && word.charAt(j) <= '9') j++;
                String tem = word.substring(i , j);
                // 去除前导0
                if (tem.charAt(0) == '0'){
                    int index = 1;
                    while (index < tem.length() && tem.charAt(index) == '0') index++;
                    tem = tem.substring(index , tem.length());
                }
                set.add(tem);
                i = j;
            }
        }

        return set.size();

    }
}
