package DataStructure.Array;

public class _849到最近的人的最大距离 {

    //https://leetcode.cn/problems/maximize-distance-to-closest-person/description/

    // 找到一个0，与相邻的1最远
    // 1. 开头连续0的个数
    // 2. 结尾连续0的个数
    // 3. 中间连续0的个数
    public int maxDistToClosest(int[] seats) {
        int count1 = 0;
        int count2 = 0;
        int l = 0 , r = seats.length-1;
        while(l < seats.length){
            if(seats[l] == 0) {
                l++;
                count1++;
            }
            else break;
        }

        while(r >= 0){
            if(seats[r] == 0) {
                r--;
                count2++;
            }
            else break;
        }

        int count3 = 0;
        int tmp = 0;
        for(int i = l ; i < r ; i++){
            if(seats[i] == 0){
                tmp++;
                count3 = Math.max(count3 , tmp);
            }else tmp = 0;
        }


        return Math.max( (count3 + 1) / 2 , Math.max(count1 , count2));

    }
}
