package Algorithm.topological_sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;


//https://leetcode.cn/problems/course-schedule/description/
public class _207_course_schedule {


    //There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
    // You are given an array prerequisites where prerequisites[i] = [ai, bi]
    // indicates that you must take course bi first if you want to take course ai.
    //
    //For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    //Return true if you can finish all courses. Otherwise, return false.

    //example 1:
    //
    //Input: numCourses = 2, prerequisites = [[1,0]]
    //Output: true
    //Explanation: There are a total of 2 courses to take.
    //To take course 1 you should have finished course 0. So it is possible.
    //Example 2:
    //
    //Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
    //Output: false
    //Explanation: There are a total of 2 courses to take.
    //To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.


    // 拓扑排序：判断图中是否有环

    @Test
    void test(){
        Assertions.assertEquals(canFinish(2 , new int[][]{{1,0}}) , true);
        Assertions.assertEquals(canFinish(2 , new int[][]{{1,0},{0,1}}) , false);
    }

    public boolean canFinish(int n, int[][] prerequisites) {
        if (n < 2) return true;

        // 1. 建图 和 入度数组
        int[] inDegree = new int[n];
        Map<Integer , List<Integer>> graph = new HashMap<>();  // key 为课程编号， value 为后续以来的课程列表


        // 先学 start , 再学 end

        for (int[] relate : prerequisites){
            int end = relate[0] , start = relate[1]; // 先学start, 再学end
            if (graph.containsKey(start)) graph.get(start).add(end);
            else graph.put(start , Arrays.asList(end));

            inDegree[end]++; // 入度++
        }

        // 2. 开始BFS，入度为0的先入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }

        int count = 0; // 记录已经学过的课程数量
        while (!queue.isEmpty()){
            int cur = queue.poll();
            count++;
            for(int neigh : graph.getOrDefault(cur , new ArrayList<>())){
                inDegree[neigh]--;
                if (inDegree[neigh] == 0) queue.add(neigh); // 入度为0了，可以加入队列
            }
        }
        return count == n;
    }



}

