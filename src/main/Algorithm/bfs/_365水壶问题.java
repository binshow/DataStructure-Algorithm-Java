package Algorithm.bfs;


// https://leetcode.cn/problems/water-and-jug-problem/


import java.util.*;

public class _365水壶问题 {

    //有两个水壶，容量分别为 jug1Capacity 和 jug2Capacity 升。水的供应是无限的。确定是否有可能使用这两个壶准确得到 targetCapacity 升。
    //
    //如果可以得到 targetCapacity 升水，最后请用以上水壶中的一或两个来盛放取得的 targetCapacity 升水。
    //
    //你可以：
    //
    //装满任意一个水壶
    //清空任意一个水壶
    //从一个水壶向另外一个水壶倒水，直到装满或者倒空

    public static void main(String[] args) {
        System.out.println(canMeasureWater(3, 5, 4));
    }

    public static boolean canMeasureWater(int x, int y, int target) {

        // 经典的BFS，主要看映射关系，这里用string来映射
        Queue<String> queue = new LinkedList<>();
        queue.add("0-0");

        Set<String> set = new HashSet<>();


        while (queue.size() > 0){
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String tem = queue.poll();
                int curX = getX(tem);
                int curY = getY(tem);
                System.out.println(tem);
                if (curX == target || curY == target || curX + curY == target) return true;

                // 获取临界可能
               List<String> list = getNextString(tem , x  , y);
               for (String s: list){
                   if (!set.contains(s)) {
                       queue.add(s);
                       set.add(tem);
                   }
               }
            }
        }
        return false;
    }


    private static List<String> getNextString(String s , int x , int y) {
        List<String> res = new ArrayList<>();
        int curX = getX(s);
        int curY = getY(s);

        //第一个桶填满、第二个桶填满
        if (curX < x) res.add(x + "-" + curY);
        if (curY < y) res.add(curX + "-" + y);

        //第一个桶倒空、第二个桶倒空
        if (curX > 0) res.add("0-" + curY);
        if (curY > 0) res.add(curX + "-0");

        // 从 A 到 B，使得 B 满，A 还有剩
        if (curX - (y - curY) > 0) res.add( (curX - (y - curY)) + "-" + y);
        // 从 A 到 B，此时 A 的水太少，A 倒尽，B 没有满
        if (curX + curY < y) res.add("0-" + (curX+curY));

        // 从 B 到 A，使得 A 满，B 还有剩余
        if (curY - (x-curX) > 0) res.add(x +"-0");
        // 从 B 到 A，此时 B 的水太少，B 倒尽，A 没有满
        if (curX + curY < x) res.add((curX+curY) + "-0");


        return res;
    }

    private static int getY(String s) {
        String[] str = s.split("-");
        return Integer.parseInt(str[1]);
    }

    private static int getX(String s) {
        String[] str = s.split("-");
        return Integer.parseInt(str[0]);
    }


}
