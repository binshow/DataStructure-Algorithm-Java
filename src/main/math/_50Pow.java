package math;

public class _50Pow {
    //https://leetcode.cn/problems/powx-n/
    public double myPow(double x, int n) {
        double res = 1.0;
        int i = n;
        while (i != 0){
            if (i % 2 != 0) res *= x;
            x *= x;
            i = i / 2;
        }
        return  n < 0 ? 1/res : res;
    }
}
