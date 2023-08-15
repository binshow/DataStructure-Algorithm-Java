package backtracking._分割问题;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.cn/problems/additive-number/
public class _306累加数 {


    public boolean isAdditiveNumber(String num) {
        List<Long> list = new ArrayList<>();
        return dfs(num , 0 , list);
    }

    boolean dfs(String num , int start , List<Long> list){
        //1. 递归截止
        if(start == num.length() && list.size() > 2) return true;

        for(int i = start ; i < num.length() ; i++){
            // 2. 拿到最后一个数校验
            String tem = num.substring(start , i+1);
            if(tem.charAt(0) == '0' && tem.length() > 1) return false; // 剪枝
            if(tem.length() > num.length()/2) return false;            // 剪枝

            //3. 满足条件再进行 回溯
            int size = list.size();
            if(size < 2 || list.get(size-1) + list.get(size-2) == Long.parseLong(tem)){
                list.add(Long.parseLong(tem));
                if(dfs(num , i+1 , list)) return true; // 注意这里也要返回
                list.remove(list.size()-1);
            }
        }
        return false;
    }


}
