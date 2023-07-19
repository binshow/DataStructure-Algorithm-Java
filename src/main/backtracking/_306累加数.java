package backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/additive-number/
public class _306累加数 {


    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) return false;
        List<Long> list = new ArrayList<>();
        boolean res = dfs(num , 0 , list);
        System.out.println(list);
        return res;
    }

    private boolean dfs(String num, int start, List<Long> list) {
        if (start == num.length() && list.size() > 2) return true;


        for (int i = start; i < num.length(); i++) {
            String tem = num.substring(start , i + 1);
            if (tem.charAt(0) == '0' && tem.length() > 1) return false;

            int size = list.size();
            if (size < 2 || list.get(size-2) + list.get(size-1) == Long.parseLong(tem)){
                list.add(Long.parseLong(tem));
                if (dfs(num , i + 1 , list)) return true;
                list.remove(list.size()-1);
            }
        }
        return false;
    }


}
