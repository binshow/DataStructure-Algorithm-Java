package Algorithm.dfs;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.cn/problems/keys-and-rooms/description/
public class _841_钥匙和房间 {


    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms.size() == 0) return true;
        Set<Integer> set = new HashSet<>(); // 去重
        dfs(0 , rooms , set);

        return set.size() == rooms.size();
    }



    void dfs(int index , List<List<Integer>> rooms , Set<Integer> set){
        // 递归截止条件
        set.add(index);
        List<Integer> list = rooms.get(index);
        if(list.size() == 0) return;


        for(int num : list){
            if(set.contains(num)) continue;
            dfs(num , rooms , set);
        }
    }
}
