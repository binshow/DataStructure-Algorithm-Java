package Algorithm.binarySearch;

import java.util.Arrays;


// https://leetcode.cn/problems/heaters/

public class _475供暖器 {

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int n = heaters.length;
        int l = 0 ,  r = Math.max( heaters[n-1] , houses[houses.length-1]);
        while(l < r){
            int mid = l + r >> 1;
            if(check(mid , houses , heaters)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    boolean check(int radius , int[] houses , int[] heaters){
        int i = 0 , j = 0;
        while(i < houses.length && j < heaters.length){
            if(Math.abs(houses[i] - heaters[j]) <= radius) i++;
            else j++;
        }
        return i == houses.length;

    }
}
