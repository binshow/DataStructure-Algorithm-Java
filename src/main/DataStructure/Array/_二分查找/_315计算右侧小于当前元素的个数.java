package DataStructure.Array._二分查找;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/count-of-smaller-numbers-after-self/
public class _315计算右侧小于当前元素的个数 {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> list = new ArrayList<>();
        LinkedList<Integer> res = new LinkedList<>();
        int n = nums.length;
        for(int i = n - 1; i >= 0 ; i--){
            int index = find(list , nums[i]);
            //System.out.println(index);
            list.add(index , nums[i]);
            res.addFirst(index);
            //System.out.println(list);
        }
        return res;
    }

    // 搜索插入位置
    private int find(List<Integer> list, int num) {
        if(list.size() == 0) return 0;
        int l = 0 , r = list.size()-1;
        if (list.get(r) < num) return list.size();
        while (l < r){
            int mid = l + r >> 1;
            if (list.get(mid) < num) l = mid+1;
            else r = mid;
        }
        return l;
    }

}
