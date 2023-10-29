package Algorithm.binarySearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class _275HIndexV2 {

    //Given an array of integers citations where citations[i] is the number of
    // citations a researcher received for their ith paper and citations is sorted in ascending order,
    // return the researcher's h-index.
    //
    //According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
    //
    //You must write an algorithm that runs in logarithmic time.
    //
    //Example 1:
    //
    //Input: citations = [0,1,3,5,6]
    //Output: 3
    //Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had received 0, 1, 3, 5, 6 citations respectively.
    //Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
    //Example 2:
    //
    //Input: citations = [1,2,100]
    //Output: 2

    @Test
    void test(){
        Assertions.assertEquals(hIndex(new int[]{0,1,3,5,6}) , 3);
        Assertions.assertEquals(hIndex(new int[]{1,2,100}) , 2);
        Assertions.assertEquals(hIndex(new int[]{0}) , 0);
    }


    // 二分猜答案

    public int hIndex(int[] citations) {
        int l = 0 , r = citations.length;
        while (l < r){
            int mid = l + r + 1 >> 1;
            if (check(mid , citations)) l = mid;
            else r = mid-1;
        }
        return l;
    }

    private boolean check(int num, int[] citations) {
        int count = 0;
        for(int n : citations){
            if (n >= num) count++;
        }
        return num <= count;
    }
}


