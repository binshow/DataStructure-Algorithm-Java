package Array;

import java.util.Arrays;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/orderly-queue/
 * @date 2022/8/31:35 PM
 */
public class Orderly_Queue {

    // 有序队列

    public String orderlyQueue(String s, int k) {
        // k = 1 字典序排序
        if (k == 1) {
            // 模拟往后移动一个元素
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < s.length(); i++) {
                sb.append(sb.charAt(0)).deleteCharAt(0);
                // compareTo 比较的就是字典序
                if (sb.toString().compareTo(s) < 0) s = sb.toString();
            }
            return s;
        }else {
            // k >= 2 ,可以实现任意排序，因为可以交换相邻两个字母，这不就可以实现冒泡排序了吗？
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }


}
