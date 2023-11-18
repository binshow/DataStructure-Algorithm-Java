package Algorithm.topological_sort;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

//https://leetcode.cn/problems/course-schedule-ii/description/
public class _210_course_schedule_v2 {



    @Test
    void test(){
        Assertions.assertEquals(Arrays.toString(findOrder(2, new int[][]{{1, 0}})), Arrays.toString(new int[]{0, 1}));
        Assertions.assertEquals(Arrays.toString(findOrder(2, new int[][]{{1, 0}, {1, 0}})), Arrays.toString(new int[]{0, 1}));
    }


    // 和1的区别就是记录正确的学习顺序
    public int[] findOrder(int n, int[][] prerequisites) {
        List<Integer> list = new ArrayList<>();
        
        //1. 建立图和入度

        int[] inDegree = new int[n];
        Map<Integer , List<Integer>> graph = new HashMap<>();
        for (int[] relate : prerequisites){
            int end = relate[0] , start = relate[1];
            if (graph.containsKey(start)) graph.get(start).add(end);
            else graph.put(start , Arrays.asList(end));

            inDegree[end]++;
        }

        //2. 开始bfs，入度为0的入队
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()){
            int cur = queue.poll();
            list.add(cur);

            for (int neigh : graph.getOrDefault(cur , new ArrayList<>())){
                inDegree[neigh]--;
                if (inDegree[neigh] == 0) queue.add(neigh);
            }
        }

        // 没有将所有的课程学完，说明没有路径
        if (list.size() != n) return new int[0];

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = list.get(i);
        }
        return res;
        
    }

}
