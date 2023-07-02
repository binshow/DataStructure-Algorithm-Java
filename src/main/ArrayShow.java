import java.util.*;


/**
 * @author shengbinbin
 * @description: TODO
 * @date 2023/4/163:10 PM
 */
public class ArrayShow {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            System.out.println(n);
            ArrayList<Integer> a = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                a.add(sc.nextInt());
            }
            int[] b = ArrayShow(n, a);
            for (int sb : b)
                System.out.println(sb);
        }
    }

    public static   int[] ArrayShow(int n,ArrayList<Integer> a)
    {
        ArrayList<Integer> tmparr = new ArrayList<Integer>();
        for(int i=0;i<a.size();i++)
        {
            if(!tmparr.contains(a.get(i)))
                tmparr.add(a.get(i));
        }
        Collections.sort(tmparr);
        int[] num = new int[tmparr.size()];
        for(int i=0;i<tmparr.size();i++)
            num[i] = (int)tmparr.get(i);
        return num;
    }



}
