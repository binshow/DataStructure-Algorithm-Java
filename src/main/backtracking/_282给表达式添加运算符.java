package backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class _282给表达式添加运算符 {



    @Test
    public void test(){
        Assertions.assertEquals(addOperators("123", 0).toString() , "[1+2-3]");
        Assertions.assertEquals(addOperators("1234", 10).toString() , "[1+2+3+4, 1*2*3+4]");
        Assertions.assertEquals(addOperators("123", 6).toString() , "[1+2+3, 1*2*3]");

    }



    // 只考虑 加减 怎么写
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(num , 0 ,  target , 0 , "" , res , 0);
        return res;
    }

    private void dfs(String num, int start, int target, long eval, String path, List<String> res , long pre) {
        // 递归截止
        if (start == num.length()){
            if (eval == target){
                res.add(new String(path));
                return;
            }
        }

        for(int i = start ; i < num.length() ; i++){
            // 不能以0开头
            if (i > start && num.charAt(start) == '0') break;
            long cur = Long.parseLong(num.substring(start , i + 1));
            // 第一个数不加 符号
            if (start == 0){
                dfs(num , i+1 , target  ,   cur , path + cur , res ,  cur);
            }else {
                // 加 或者 减
                dfs(num , i+1 , target , eval + cur , path + "+" + cur , res , cur);
                dfs(num , i+1 , target , eval - cur , path + "-" + cur , res , -cur);

                // 考虑乘法的话就要考虑优先级，添加一个pre 参数 , 记录上次的值

                // 1 + 2 * 3  可以等价于  3 - 2 + 3 * 2
                //另外 addOperatorsHelper 函数传进 pre 参数需要是 pre * eval
                //比如前边讲的 2+ 3 * 4 * 5 这种连乘的情况 , 记录的 pre 是 12
                // 14 - 12 + 5 * 12 = 62
                dfs(num , i+1 , target , eval - pre + pre * cur , path + "*" + cur , res , pre * cur);
            }
        }

    }
}
