package DataStructure.Array._常数操作随机获取元素;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.cn/problems/insert-delete-getrandom-o1/
public class _380RandomizedSet {

    // O(1) 时间插入、删除和获取随机元素
    // 如果想「等概率」且「在 O(1) 的时间」取出元素，一定要满足：底层用数组实现，且数组必须是紧凑的。

    Map<Integer , Integer> val2Index = new HashMap<>();
    List<Integer> list = new ArrayList<>();

    public _380RandomizedSet() {

    }

    public boolean insert(int val) {
        if (val2Index.containsKey(val)) return false;
        val2Index.put(val , list.size());
        list.add(val);
        return true;
    }

    // 删除元素, 先取索引，然后和最后一个元素交换
    public boolean remove(int val) {
        if (!val2Index.containsKey(val)) return false;

        //1. 获取要删除位置的索引
        int index = val2Index.get(val);

        // 获取最后一个元素,将最后一个元素 放到 当前索引上
        Integer last = list.get(list.size() - 1);
        list.set(index , last);

        // 删除最后一个元素
        list.remove(list.size()-1);

        // 更新map
        val2Index.put(last , index); // 更新index
        val2Index.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }
}
