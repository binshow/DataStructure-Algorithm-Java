package DataStructure.Array;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2022/7/2912:54 AM
 */
public class Valid_Square {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        double s1 = getDistance(p1 , p2);
        double s2 = getDistance(p1 , p3);
        double s3 = getDistance(p1 , p4);

        if(s1  == 0 || s2 == 0 || s3 == 0) return false;
        // 找出三个数之间距离的最大值
        double max = Math.max(Math.max(s1 , s2) , s3);
        if(max == s1){ // 1 2 对角线
            if(s2 != s3 || max != getDistance(p3 , p4)) return false;
            if (getDistance(p1 , p3) != getDistance(p2 , p4)) return false; // 还要判断另外两个边
            return true;
        }

        if(max == s2){  // 1 3
            if(s1 != s3 || max != getDistance(p2 , p4)) return false;
            if (getDistance(p1 , p4) != getDistance(p2 , p3)) return false;
            return true;
        }

        if(max == s3){  // 1 4
            if(s2 != s1 || max != getDistance(p3 , p2)) return false;
            if (getDistance(p1 , p2) != getDistance(p3 , p4)) return false;
            return true;
        }

        return false;

    }


    double getDistance(int[] p1 , int[] p2){
        int a = Math.abs(p1[0] - p2[0]);
        int b = Math.abs(p1[1] - p2[1]);
        return Math.sqrt(a * a + b * b);
    }
}
