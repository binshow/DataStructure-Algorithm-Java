package DataStructure.Math;

import java.util.HashSet;
import java.util.Set;

public class _202快乐数 {


    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(true){
            int tem = getNum(n);
            System.out.println(tem);
            if(tem == 1) return true;
            if(set.contains(tem)) return false;
            set.add(tem);
            n = tem;
        }
    }


    int getNum(int n){
        int tem = 0;
        while(n > 0){
            int mod = n % 10;
            tem += mod * mod;
            n = n / 10;
        }
        return tem;

    }
}
