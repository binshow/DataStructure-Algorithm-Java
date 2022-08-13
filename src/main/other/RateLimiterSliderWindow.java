package other;

import java.time.LocalTime;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shengbinbin
 * @description: 滑动窗口实现限流
 * @date 2022/8/410:21 PM
 */
public class RateLimiterSliderWindow {

    private int qps = 2;
    private long windowSize = 1000;
    private Integer windowCount = 20;
    private WindowInfo[] windowArray = new WindowInfo[windowCount];

    public RateLimiterSliderWindow(int qps) {
        this.qps = qps;
        long curTimeMillis = System.currentTimeMillis();
        for (int i = 0; i < windowArray.length; i++) {
            windowArray[i] = new WindowInfo(curTimeMillis , new AtomicInteger(0));
        }
    }

    // 判断是否被限流
    public synchronized boolean tryAcquire(){
        long currentTimeMillis = System.currentTimeMillis();
        // 计算当前窗口
        int curIndex = (int)(currentTimeMillis % windowSize / (windowSize / windowCount));
       // System.out.println("当前窗口:" + curIndex);
        // 更新当前窗口计数 & 重置过期窗口计数
        int sum = 0;
        for (int i = 0; i < windowArray.length; i++) {
            WindowInfo windowInfo = windowArray[i];
            if ((currentTimeMillis - windowInfo.getTime()) > windowSize) {
                windowInfo.getCount().set(0);
                windowInfo.setTime(currentTimeMillis);
            }
            if (curIndex == i && windowInfo.getCount().get() < qps) {
                windowInfo.getCount().incrementAndGet();
            }
            sum = sum + windowInfo.getCount().get();
        }
        // 当前 QPS 是否超过限制
        return sum <= qps;
    }

    private class WindowInfo {
        private Long time;
        private AtomicInteger count;
        public WindowInfo(long time , AtomicInteger num){
            this.time = time;
            this.count = num;
        }

        public void setTime(Long time) {
            this.time = time;
        }
        public void setCount(AtomicInteger count) {
            this.count = count;
        }
        public Long getTime() {
            return time;
        }
        public AtomicInteger getCount() {
            return count;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int qps = 2, count = 20, sleep = 300, success = count * sleep / 1000 * qps;
        System.out.println(String.format("当前QPS限制为:%d,当前测试次数:%d,间隔:%dms,预计成功次数:%d", qps, count, sleep, success));
        success = 0;
        RateLimiterSliderWindow myRateLimiter = new RateLimiterSliderWindow(qps);
        for (int i = 0; i < count; i++) {
            Thread.sleep(sleep);
            if (myRateLimiter.tryAcquire()) {
                success++;
                if (success % qps == 0) {
                    System.out.println(LocalTime.now() + ": success, ");
                } else {
                    System.out.print(LocalTime.now() + ": success, ");
                }
            } else {
                System.out.println(LocalTime.now() + ": fail");
            }
        }
        System.out.println();
        System.out.println("实际测试成功次数:" + success);

    }

}
