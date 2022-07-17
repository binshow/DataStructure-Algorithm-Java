package design;

import java.util.LinkedList;
import java.util.List;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/qIsx9U/
 * @date 2022/7/1611:10 AM
 */
public class moving_average {

    // 滑动窗口的平均值
    static class MovingAverage {
        LinkedList<Integer> list;
        int size;
        double sum;

        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            list = new LinkedList<>();
            this.size = size;
        }

        public double next(int val) {
            if (list.size() < size){
                list.add(val);
                sum += val;
                return (double)(sum / list.size());
            }
            Integer num = list.pollFirst();
            sum -= num;
            sum += val;
            list.add(val);
            return (double)(sum / size);
        }
    }
}
