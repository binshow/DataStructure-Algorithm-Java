package Algorithm.binarySearch.guessAnswer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// https://leetcode.cn/problems/koko-eating-bananas/description/
public class _875KoKo_eating_bananas {


    // Koko loves to eat bananas.
    // There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
    //
    //  Koko can decide her bananas-per-hour eating speed of k.
    //  Each hour, she chooses some pile of bananas and eats k bananas from that pile.
    //  If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
    //
    // Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
    //
    //Return the minimum integer k such that she can eat all the bananas within h hours.
    //

    //Example 1:
    //
    //Input: piles = [3,6,7,11], h = 8
    //Output: 4

    //Example 2:
    //
    //Input: piles = [30,11,23,4,20], h = 5
    //Output: 30

    //Example 3:
    //
    //Input: piles = [30,11,23,4,20], h = 6
    //Output: 23




    @Test
    void test(){
        Assertions.assertEquals( minEatingSpeed(new int[]{3, 6, 7, 11}, 8) , 4);
        Assertions.assertEquals( minEatingSpeed(new int[]{30,11,23,4,20}, 5) , 30);
        Assertions.assertEquals( minEatingSpeed(new int[]{30,11,23,4,20}, 6) , 23);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        int min = piles[0];
        for(int num : piles) {
            max = Math.max(num , max);
            min = Math.min(num , min);
        }

        int l = min , r = max;
        while (l < r){
            int mid = l + r >> 1;
            if (check(piles , mid , h)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    // 以每小时吃v个速度， h个小时后 是否能吃完
    boolean check(int[] piles , int v , int h){
        int count = 0;
        for (int num : piles){
            if (num <= v) count++;
            else count += (num / v) + (num % v == 0 ? 0 : 1);
        }
        return count <= h;
    }

}
