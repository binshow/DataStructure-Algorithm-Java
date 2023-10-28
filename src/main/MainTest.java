import java.util.Arrays;
import java.util.PriorityQueue;

public class MainTest {


    public static void main(String[] args) {

    }


    public long pickGifts(int[] gifts, int k) {

        PriorityQueue<Long> pq = new PriorityQueue<Long>((a , b) -> (int) (b - a));
        for(int num : gifts) pq.add((long)num);
        while(k > 0){
            long num = pq.poll();
            pq.add((long)Math.sqrt(num));
            k--;
        }

        long res = 0;
        for(long num : pq) res += num;
        return (int)res;

    }
}
