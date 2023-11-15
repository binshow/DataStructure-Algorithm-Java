package DataStructure.heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _264_ugly_number_v2 {

    //https://leetcode.cn/problems/ugly-number-ii/description/




    @Test
    void test(){
        Assertions.assertEquals(nthUglyNumber(10),12);
        Assertions.assertEquals(nthUglyNumber(11),15);
        Assertions.assertEquals(nthUglyNumber(12),16);
        Assertions.assertEquals(nthUglyNumber(13),18);
        Assertions.assertEquals(nthUglyNumber(100),1536);
    }

    /*
    *  思路：每个丑数都可以由其他较小的丑数通过乘以 222 或 333 或 555 得到
    * 可以考虑使用一个优先队列保存所有的丑数，每次取出最小的那个，然后乘以 222 , 333 , 555 后放回队列。
    * 然而，这样做会出现重复的丑数
    *
    * 初始化丑数列表 [1]
第一轮： 1 -> 2, 3, 5 ，丑数列表变为 [1, 2, 3, 5]
第二轮： 2 -> 4, 6, 10 ，丑数列表变为 [1, 2, 3, 4, 6, 10]
第三轮： 3 -> 6, 9, 15 ，出现重复的丑数 6
为了避免重复，我们可以用三个指针 aaa , bbb, ccc ，分别表示下一个丑数是当前指针指向的丑数乘以 222 , 333 , 555 。

    *
    * */

    public int nthUglyNumber(int n) {

        int[] res = new int[n];
        res[0] = 1;
        int l1 = 0 , l2 = 0 , l3 = 0;
        for (int i = 1; i < n; i++) {
            int n1 = res[l1] * 2;
            int n2 = res[l2] * 3;
            int n3 = res[l3] * 5;

            res[i] = Math.min(Math.min(n1 , n2) , n3);

            // 最小的指针才能++
            if (res[i] == n1) l1++;
            if (res[i] == n2) l2++;
            if (res[i] == n3) l3++;
        }

        return res[n-1];
    }
}
