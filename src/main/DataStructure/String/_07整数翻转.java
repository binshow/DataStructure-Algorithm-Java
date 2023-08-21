package DataStructure.String;

import java.util.ArrayList;
import java.util.List;

public class _07整数翻转 {

    public int reverse(int x) {
        List<Integer> list = new ArrayList<>();
        boolean flag = x < 0;
        x = Math.abs(x);
        while (x > 0){
            list.add(x % 10);
            x = x / 10;
        }

        long num = 0;
        for (int tem : list) num = num * 10 + tem;
        if (num >= Integer.MAX_VALUE) return 0;
        return flag ? -(int)num : (int)num;
    }
}
