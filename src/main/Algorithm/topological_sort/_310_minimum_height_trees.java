package Algorithm.topological_sort;

import java.util.*;


// https://leetcode.cn/problems/minimum-height-trees/

public class _310_minimum_height_trees {



    // 思路：https://leetcode.cn/problems/minimum-height-trees/solutions/1398039/by-a-fei-8-hm2n/

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1){
            res.add(0);
            return res;
        }

        // 1. 建立入度 和 图
        int[] degree = new int[n];
        Map<Integer,List<Integer>> graph = new HashMap<>();

        for (int[] edge : edges){

            if (graph.containsKey(edge[0])) graph.get(edge[0]).add(edge[1]);
            else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(edge[1]);
                graph.put(edge[0] , tmp);
            }

            if (graph.containsKey(edge[1])) graph.get(edge[1]).add(edge[0]);
            else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(edge[0]);
                graph.put(edge[1] , tmp);
            }

            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        // 入度为 1 的 先入队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) queue.add(i);
        }
        while(!queue.isEmpty()){
            res = new ArrayList<>();
            int size = queue.size();
            // 因为要保留最后一批 出队列的节点，
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                res.add(cur);
                for (int neigh : graph.getOrDefault(cur , new ArrayList<>())){
                    degree[neigh]--;
                    if (degree[neigh] == 1) queue.add(neigh);
                }
            }
            System.out.println(res);
        }
        return res;

    }
}
