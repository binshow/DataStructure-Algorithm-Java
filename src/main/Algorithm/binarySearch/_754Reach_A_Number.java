package Algorithm.binarySearch;

public class _754Reach_A_Number {

    public int reachNumber(int target) {

        // 处理 target 为负
        target = Math.abs(target);

        // 一直往前走 1+2+..+n = (1 + n) * n / 2;
        // 寻找第一个 n 使得 sum >= target
        int l = 0 , r = target;
        while(l < r){
            int mid = l + r >> 1;
            if( (1 + (long)mid) * mid / 2  < target) l = mid + 1;
            else r = mid;
        }

        // 此时  sum - target 为多走的步骤
        // 当 sum - target 为偶数时， 可以让前面的 某一个步长为 (sum - target) / 2 改为向左走
        // 当 sum - target 为奇数时，那么再前进 一步或者两步 就可以 让 sum - target 变为偶数
        //             n 为偶数时， n+1 为奇数，再前进一步
        //             n 为奇数时， n+1 为偶数，得前进两步

        int sum = (1 + l) * l / 2;
        if( (sum - target) % 2 == 0) return l;

        return l % 2 == 0 ? l+1 : l+2;

    }
}
