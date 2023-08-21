package Algorithm.dfs;


// https://leetcode.cn/problems/all-paths-from-source-to-target/

import java.util.ArrayList;
import java.util.List;

public class _797所有可能的路径 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length-1;
        List<Integer> list = new ArrayList<>();
        dfs(graph , 0 , n , list);
        return res;
    }

    void dfs(int[][] graph , int start , int n , List<Integer> list){

        if(start == n){
            list.add(start);
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        list.add(start);
        for(int num : graph[start]) dfs(graph , num , n , list);
        list.remove(list.size()-1);
    }
}
