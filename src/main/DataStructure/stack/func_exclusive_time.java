package DataStructure.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author shengbinbin
 * @description: TODO
 * @date 2022/8/710:50 PM
 */
public class func_exclusive_time {

    //https://leetcode.cn/problems/exclusive-time-of-functions/

    // 栈模拟题
    public static int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int preTime = 0;
        for (String log : logs){
            String[] ss = log.split(":");
            int index = Integer.parseInt(ss[0]);
            int time = Integer.parseInt(ss[2]);
            if (ss[1].equals("start")){
                // 函数调用，则当前函数调用发起时间 到 上一次记录的当前时间，都是前一个函数的执行时间
                //  将 该时间累加到栈顶对应的函数上
                if (!stack.isEmpty()) res[stack.peek()] += time - preTime;
                // 如果栈不为空，说明栈顶的线程正在执行，挂起栈顶的线程，当前线程入栈，更新当前时间
                stack.push(index);
                preTime = time; // 更新当前时间
            }else {
                // 函数结束了
                int func = stack.pop();
                res[func] += time - preTime + 1;
                preTime = time + 1;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        String[] logs = {"0:start:0","1:start:2","1:end:5","0:end:6"};
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(logs));

        System.out.println(Arrays.toString(exclusiveTime(2, list)));
    }
}
