package JUC.阻塞队列;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class test {

    @Test
    public void testBQ2(){
        MyBlockingQueue2 bq2 = new MyBlockingQueue2();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                bq2.put(Thread.currentThread().getId());
            }).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                bq2.take();
            }).start();
        }
    }

    @Test
    public void testBQ1(){
        MyBlockingQueue bq = new MyBlockingQueue();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    bq.put(Thread.currentThread().getId());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    bq.take();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
