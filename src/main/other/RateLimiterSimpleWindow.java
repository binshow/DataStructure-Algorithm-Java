package other;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shengbinbin
 * @description: 计数器算法实现限流
 * @date 2022/8/410:21 PM
 */
public class RateLimiterSimpleWindow {

    private static Integer QPS = 2;  // 阈值
    private static long TIME_WINDOWS = 1000; // 时间窗口
    private static AtomicInteger count = new AtomicInteger(); // 计数器
    private static long startTime = System.currentTimeMillis();

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(400);
        // mock 10个请求同时进来
        for (int i = 0; i < 10; i++) {
            Thread.sleep(250);
            LocalTime now = LocalTime.now();
            if (!tryAcquire()){
                System.out.println(now + " rate limiter");
            }else System.out.println(now + " do something");
        }
    }

    // 判断是否被限流
    private static boolean tryAcquire() {
        // 超过时间窗口，就重置计数器
        if ((System.currentTimeMillis() - startTime) > TIME_WINDOWS){
            count.set(0);
            startTime = System.currentTimeMillis();
        }
        return count.incrementAndGet() <= QPS;
    }
}
