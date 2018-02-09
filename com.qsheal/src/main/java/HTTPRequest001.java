import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class HTTPRequest001 implements Runnable {
    private static AtomicInteger b = new AtomicInteger();

    public void run() {
        System.out.println("--------测试" + b.getAndIncrement());//原子量计数
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 50; i++) {//并发50个用户
            service.execute(new HTTPRequest001());
        }
        b.incrementAndGet();
    }
}

