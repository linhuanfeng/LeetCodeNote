package JUC.JUC代码.lock.线程交替打印;

public class WaitTest {
    int num=1;
    Object obj=new Object();
    void printA(){
        synchronized (obj){
            while (num!=1){
                try {
                    obj.wait(); // 不是1就阻塞，死循环判断1
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("A...");
            num=2;
            obj.notify();
        }
    }
    void printB(){
        synchronized (obj){
            while (num!=2){
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("B...");
            num=1;
            obj.notify();
        }
    }

    public static void main(String[] args) {
        WaitTest waitTest = new WaitTest();
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                waitTest.printA();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 30; i++) {
                waitTest.printB();
            }
        }).start();
    }
}
