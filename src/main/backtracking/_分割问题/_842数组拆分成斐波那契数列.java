package backtracking._分割问题;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class _842数组拆分成斐波那契数列 {


    @Test
    void test(){
        System.out.println(splitIntoFibonacci("1101111"));
    }


    // https://leetcode.cn/problems/split-array-into-fibonacci-sequence/
    public List<Integer> splitIntoFibonacci(String num) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(num , 0 , list , res);
        //res 中保存了所有的 斐波那契数列
        return res.size() > 0 ? res.get(0) : new ArrayList<>();
    }

    private void dfs(String num, int start, List<Integer> list , List<List<Integer>> res) {
        if (start == num.length() && list.size() > 2) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = start ; i < num.length() ; i++){
            String tem = num.substring(start , i + 1);

            if (tem.length() > 1 && tem.charAt(0) == '0') break;
            long cur = Long.parseLong(tem);
            if (cur > Integer.MAX_VALUE) break;

            //如果截取的数字大于res中前两个数字的和，说明这次截取的太大，直接终止，因为后面越截取越大
            int n = list.size();
            if (n >= 2 && list.get(n-2) + list.get(n-1) < cur) break;

            if (n <= 1 || cur == list.get(n-2) + list.get(n-1)){
                list.add((int) cur);
               // System.out.println(list);
                dfs(num , i + 1 , list , res );
                list.remove(list.size()-1);
            }
        }
    }


}
