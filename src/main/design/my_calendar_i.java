package design;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shengbinbin
 * @description: https://leetcode.cn/problems/my-calendar-i/
 * @date 2022/7/510:15 AM
 */
public class my_calendar_i {

}

class MyCalendar {
    List<int[]> list;
    public MyCalendar() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        end--; // 存储的都是左右闭区间了
        for (int[] info : list){
            if (start > info[1] || end < info[0]) continue;
            else return false;
        }
        list.add(new int[]{start , end});
        return true;
    }
}
