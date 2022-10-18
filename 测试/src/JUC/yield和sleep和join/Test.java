package JUC.yield和sleep和join;

/**
 * yield,sleep,
 */
public class Test {
    public static void main(String[] args) {
        Thread.yield();

        Thread thread = new Thread(() -> System.out.println());
        try {
            thread.join(); // 底层调用wait，会释放锁和CPU
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread.interrupted();
    }
}
