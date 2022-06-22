package Array;

import javax.xml.bind.annotation.XmlID;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/koko-eating-bananas/
 * 此题是典型的二分猜答案模板题，类似的题目或可以用这个方法求解的题目还有
 * 275. H 指数 II，611. 有效三角形的个数，1011. 在 D 天内送达包裹的能力，1482. 制作 m 束花所需的最少天数等
 * @date 2022/6/79:55 AM
 */
public class Koko_Eating_Bananas {

    // 二分法：
    //Input: piles = [30,11,23,4,20], h = 5
    //Output: 30
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int num : piles) max = Math.max(max , num);

        // 一次最少吃l个，最多吃r个
        int l = 1 , r = max;
        while (l < r){
            int mid = l + r  >> 1;
            if (check(mid , piles) <= h) r = mid;  // 判断一次吃mid个，耗时如果 <= h，说明吃多了，可以吃的更少一点一次
            else l = mid + 1 ;
        }
        return l;
    }

    // 判断一次吃num个，需要几小时吃完
    private int check(int num, int[] piles) {
        int res = 0;
        for (int pile : piles){
            int a = pile / num;
            int b = pile % num;
            res = res + a + (b == 0 ? 0 : 1);
        }
        return res;
    }
}
